package com.company.service.impl;

import com.company.dao.TestDao;
import com.company.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Galapagos on 2017/4/20.
 */

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;


    @Override
    public void query(Map<String, Object> param, Map<String, Object> result) {

        List<Map<String,Object>> mapList=testDao.query(param);

        result.put("result",mapList);

    }
}
