package com.company.controllers;


import com.alibaba.fastjson.JSON;
import com.company.service.TestService;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.rest.Get;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Galapagos on 2017/4/20.
 */


public class TestController {


    @Autowired
    private TestService testService;

    @Get
    public String test(){


        return "@a";
    }


    public Object query(Invocation inv){

        Map<String,Object> param=new HashMap<String,Object>();

        Map<String,Object> result=new HashMap<String,Object>();

        testService.query(param,result);


        return "@"+ JSON.toJSONString(result);
    }

}