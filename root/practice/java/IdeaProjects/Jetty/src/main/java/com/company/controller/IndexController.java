package com.company.controller;

import com.company.annotation.SignInRequired;
import com.company.service.IndexService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by Galapagos on 2016/4/27.
 */
@Controller
@RequestMapping("index")
@SignInRequired
public class IndexController {

    private static Logger logger=Logger.getLogger(IndexController.class);


    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public Object index(){
        logger.debug("........................");
        Map<String,Object> indexMap=indexService.index();
        logger.debug(indexMap);
        return "index";
    }


}
