package com.company.controller;

import com.company.domain.User;
import com.company.service.SignService;
import com.company.utils.Md5Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Galapagos on 2016/4/29.
 */

/**
 * If the algorithm directive's value is "MD5" or unspecified, then HA1 is

 HA1=MD5(username:realm:password)
 If the algorithm directive's value is "MD5-sess", then HA1 is

 HA1=MD5(MD5(username:realm:password):nonce:cnonce)
 If the qop directive's value is "auth" or is unspecified, then HA2 is

 HA2=MD5(method:digestURI)
 If the qop directive's value is "auth-int", then HA2 is

 HA2=MD5(method:digestURI:MD5(entityBody))
 If the qop directive's value is "auth" or "auth-int", then compute the response as follows:

 response=MD5(HA1:nonce:nonceCount:cnonce:qop:HA2)
 If the qop directive is unspecified, then compute the response as follows:

 response=MD5(HA1:nonce:HA2)
* */


/**
 * Client request (no authentication)
 GET /dir/index.html HTTP/1.0
 Host: localhost
 (followed by a new line, in the form of a carriage return followed by a line feed).[5]

 Server response
 HTTP/1.0 401 Unauthorized
 Server: HTTPd/0.9
 Date: Sun, 10 Apr 2014 20:26:47 GMT
 WWW-Authenticate: Digest realm="testrealm@host.com",
 qop="auth,auth-int",
 nonce="dcd98b7102dd2f0e8b11d0f600bfb0c093",
 opaque="5ccc069c403ebaf9f0171e9517f40e41"
 Content-Type: text/html
 Content-Length: 153

 <html>
 <head>
 <meta charset="UTF-8" />
 <title>Error</title>
 </head>
 <body>
 <h1>401 Unauthorized.</h1>
 </body>
 </html>
 Client request (username "Mufasa", password "Circle Of Life")
 GET /dir/index.html HTTP/1.0
 Host: localhost
 Authorization: Digest username="Mufasa",
 realm="testrealm@host.com",
 nonce="dcd98b7102dd2f0e8b11d0f600bfb0c093",
 uri="/dir/index.html",
 qop=auth,
 nc=00000001,
 cnonce="0a4f113b",
 response="6629fae49393a05397450978507c4ef1",
 opaque="5ccc069c403ebaf9f0171e9517f40e41"
 (followed by a blank line, as before).

 Server response
 HTTP/1.0 200 OK
 Server: HTTPd/0.9
 Date: Sun, 10 Apr 2005 20:27:03 GMT
 Content-Type: text/html
 Content-Length: 7984
 */

/**
 *  HA1 = MD5( "Mufasa:testrealm@host.com:Circle Of Life" )
 = 939e7578ed9e3c518a452acee763bce9

 HA2 = MD5( "GET:/dir/index.html" )
 = 39aff3a2bab6126f332b942af96d3366

 Response = MD5( "939e7578ed9e3c518a452acee763bce9:\
 dcd98b7102dd2f0e8b11d0f600bfb0c093:\
 00000001:0a4f113b:auth:\
 39aff3a2bab6126f332b942af96d3366" )
 = 6629fae49393a05397450978507c4ef1
 */


@Controller
@RequestMapping("sign")
public class SignController {

    private static final Logger logger =Logger.getLogger(SignController.class);


    @Autowired
    private SignService signService;

    @RequestMapping(value = "signIn",method = RequestMethod.GET)
    @ResponseBody
    public Object signIn(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        Map<String,Object> result=new HashMap<String, Object>();
        String nonce= Md5Utils.getMd5(UUID.randomUUID().toString());

        /*WWW-Authenticate: Digest realm="testrealm@host.com",
                qop="auth,auth-int",
                nonce="dcd98b7102dd2f0e8b11d0f600bfb0c093",
                opaque="5ccc069c403ebaf9f0171e9517f40e41"*/
        /*String realm="company";
        String qop="auth";
        String opaque="5ccc069c403ebaf9f0171e9517f40e41";

        String WWWAuthenticate="Digest realm="+realm+",qop="+qop+",nonce="+nonce+",opaque="+opaque;

        httpServletResponse.setHeader("WWW-Authenticate",WWWAuthenticate);*/

        result.put("success",true);
        result.put("nonce",nonce);
        result.put("username",result.get("username"));

        return result;
    }

    @RequestMapping(value = "signInPost",method = RequestMethod.POST)
    @ResponseBody
    public Object signInPost(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        Map<String,Object> result=new HashMap<String, Object>();
        Map<String,Object> param=new HashMap<String, Object>();
        param.put("username",httpServletRequest.getParameter("username"));
        param.put("nonce",httpServletRequest.getParameter("nonce"));
        param.put("response",httpServletRequest.getParameter("response"));
        signService.signIn(httpServletRequest,param,result);
        return result;
    }


    @RequestMapping(value = "signUp",method = RequestMethod.POST)
    @ResponseBody
    public Object signUp(User user){
        Map<String,Object> result=new HashMap<String, Object>();
        Map<String,Object> param=new HashMap<String, Object>();
        param.put("username",user.getUsername());
        param.put("password",user.getPassword());
        signService.signUp(param,result);
        return result;
    }

    @RequestMapping(value = "signOut",method=RequestMethod.GET)
    public Object signOut(HttpServletRequest httpServletRequest){
        signService.signOut(httpServletRequest);
        return "redirect:/";
    }

}
