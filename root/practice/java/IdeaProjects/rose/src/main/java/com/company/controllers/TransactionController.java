package com.company.controllers;

import com.company.service.TransactionService;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.rest.Get;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Galapagos on 2017/4/22.
 */
public class TransactionController {


    @Autowired
    private TransactionService transactionService;


    @Get
    public Object index(){

        return "@1";
    }


    public Object testTransaction(Invocation inv){

        Map<String,Object> param=new HashMap<String,Object>();
        Map<String,Object> result=new HashMap<String,Object>();

        transactionService.testTransacton(param,result);

        return "@2";
    }





}
