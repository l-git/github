package com.company.controller;

import com.company.service.HelloWorldService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Galapagos on 2016/5/9.
 */
@Controller
@RequestMapping("helloWorld")
public class HelloWorldController {

    private static final Logger logger=Logger.getLogger(HelloWorldController.class);

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("hello")
    public Object hello(){
        Map<String,Object> result=new HashMap<String,Object>();
        Map<String,Object> param=new HashMap<String,Object>();
        helloWorldService.hello(param,result);
        logger.debug(result);
        return "hello";
    }


}
