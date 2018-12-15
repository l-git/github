package com.company.controller;

import com.company.annotation.SignInRequired;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Galapagos on 2016/4/27.
 */
@Controller
@RequestMapping("welcome")
@SignInRequired
public class WelcomeController {

    private static Logger logger =Logger.getLogger(WelcomeController.class);

    @RequestMapping(value = "welcome")
    public Object index(){

        logger.debug("welcome");
        return "welcome";
    }

}
