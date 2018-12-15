package com.company.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by Galapagos on 2017/4/20.
 */
public interface TestDao {


    public List<Map<String,Object>> query(Map<String,Object> param);


}
