package com.company.service.impl;

import com.company.dao.TransactionDao;
import com.company.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Galapagos on 2017/4/22.
 */
@Service
public class TransactionServiceImpl implements TransactionService {


    @Autowired
    private TransactionDao transactionDao;


    @Override
    public void testTransacton(Map<String,Object> param,Map<String,Object> result) {

        param.put("id","2");

        List<Map<String,Object>> mapList=transactionDao.query(param);

        param.put("password","123");

        transactionDao.updateById(param);

        mapList=transactionDao.query(param);

        throw new RuntimeException("r");


    }
}
