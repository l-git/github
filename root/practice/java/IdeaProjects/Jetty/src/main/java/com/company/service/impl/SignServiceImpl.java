package com.company.service.impl;

import com.company.constant.SessionName;
import com.company.dao.SignDao;
import com.company.domain.User;
import com.company.service.SignService;
import com.company.utils.Md5Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Galapagos on 2016/4/29.
 */
@Service
public class SignServiceImpl implements SignService {

    private static final Logger logger=Logger.getLogger(SignServiceImpl.class);

    @Autowired
    private SignDao signDao;


    @Override
    public void signUp(Map<String, Object> param, Map<String, Object> result) {
        Map<String,Object> paramMap=new HashMap<String, Object>();
        paramMap.put("username",param.get("username"));
        List<Map<String,Object>> userList=signDao.selectUser(paramMap);
        if(userList!=null&&userList.size()==0){
            signDao.insertUser(param);
            result.put("success",true);
            result.put("msg","sign up success");

        }else {
            result.put("success",false);
            result.put("msg","username not available");
        }
    }

    @Override
    public void signIn(HttpServletRequest httpServletRequest, Map<String, Object> param, Map<String, Object> result) {
        List<Map<String,Object>> userList=signDao.selectUser(param);
        if(userList!=null&&userList.size()==1){
            Map<String,Object> userMap=userList.get(0);
            String password= (String) userMap.get("password");
            String nonce= (String) param.get("nonce");
            String response= Md5Utils.getMd5(nonce+password);
            if(response.equals(param.get("response"))){
                result.put("success",true);
                User user=new User();
                user.setUsername((String) param.get("username"));
                user.setPassword(password);
                httpServletRequest.getSession().setAttribute(SessionName.USER,user);
            }else{
                result.put("success",false);
                result.put("msg","login fail");
            }
        }else {
            result.put("success",false);
            result.put("msg","login fail");
        }
    }

    @Override
    public void signOut(HttpServletRequest httpServletRequest) {

        httpServletRequest.getSession().invalidate();
    }
}
