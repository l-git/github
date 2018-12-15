package com.company.service.impl;

import com.company.dao.IndexDao;
import com.company.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Galapagos on 2016/4/27.
 */
@Service
public class IndexServiceImpl implements IndexService{

    @Autowired
    private IndexDao indexDao;

    @Override
    public Map<String, Object> index() {
        Map<String,Object> indexMap=indexDao.index();
        return indexMap;
    }
}
