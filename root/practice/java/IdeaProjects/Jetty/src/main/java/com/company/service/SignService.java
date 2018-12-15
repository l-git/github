package com.company.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Galapagos on 2016/4/29.
 */
public interface SignService {

    public void signUp(Map<String,Object> param,Map<String,Object> result);
    public void signIn(HttpServletRequest httpServletRequest,Map<String,Object> param,Map<String,Object> result);
    public void signOut(HttpServletRequest httpServletRequest);

}
