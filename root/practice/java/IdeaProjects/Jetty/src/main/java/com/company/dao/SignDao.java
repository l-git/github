package com.company.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by Galapagos on 2016/4/29.
 */
public interface SignDao {
    public List<Map<String,Object>> selectUser(Map<String,Object> map);

    public int insertUser(Map<String,Object> map);
}
