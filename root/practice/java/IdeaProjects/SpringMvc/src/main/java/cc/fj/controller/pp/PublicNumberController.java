package cc.fj.controller.pp;

import cc.fj.service.pp.PublicNumberService;
import cc.fj.util.WeChatUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by asus on 2015/12/26.
 */
@Controller
@RequestMapping(value ="/com/fj/controller/pp")
public class PublicNumberController {

    private static final Logger logger=Logger.getLogger(PublicNumberController.class);

    @Autowired
    private PublicNumberService publicNumberService;

    @RequestMapping(value = "pn",method={RequestMethod.GET})
    @ResponseBody
    public Object get(HttpServletRequest request){
        logger.info("================================");
        String signature=request.getParameter("signature");
        String timestamp=request.getParameter("timestamp");
        String nonce=request.getParameter("nonce");
        String echostr=request.getParameter("echostr");
        logger.info("\n?signature="+signature+"&timestamp="+timestamp+"&nonce="+nonce+"&echostr="+echostr);
        if(WeChatUtil.checkSignature(signature,timestamp,nonce)){
            logger.info("request is from WeChat server!");
            return echostr;
        }
        logger.info("request is not from WeChat server!");
        return "request is not from WeChat server!";
    }

    @RequestMapping(value = "pn",method = {RequestMethod.POST})
    @ResponseBody
    public Object post(HttpServletRequest request,HttpServletResponse response){
        logger.info("\npost\n");

        String responseMsg=publicNumberService.process(request);


        return responseMsg;
    }
}
