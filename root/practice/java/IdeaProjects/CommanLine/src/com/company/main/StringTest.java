package com.company.main;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Galapagos on 2016/7/12.
 */
public class StringTest {
    public static final String NULL="null";
    public static void main(String args[]){
        Map<String,Object> map=new HashMap<String, Object>();
        String s1=String.valueOf(map.get("n"));
        System.out.println(NULL.equals(s1));
    }
}
