package com.company.service.impl;

import com.company.dao.HelloWorldDao;
import com.company.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Galapagos on 2016/5/9.
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {


    @Autowired
    private HelloWorldDao helloWorldDao;


    @Override
    public void hello(Map<String,Object> param,Map<String,Object> result) {
        Map<String,Object> dualMap=helloWorldDao.selectDual();
        result.put("dual",dualMap);
    }
}
