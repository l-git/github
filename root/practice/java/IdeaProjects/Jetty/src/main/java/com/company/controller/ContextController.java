package com.company.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Galapagos on 2016/4/29.
 */
@Controller
@RequestMapping
public class ContextController {

    private static final Logger logger =Logger.getLogger(ContextController.class);

    @RequestMapping
    public Object context(){
        logger.debug("context");
        return "index";
    }


}
