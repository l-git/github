package com.company.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by Galapagos on 2017/4/22.
 */
public interface TransactionDao {

    public List<Map<String,Object>> query(Map<String,Object> param);

    public int updateById(Map<String,Object> param);


}
