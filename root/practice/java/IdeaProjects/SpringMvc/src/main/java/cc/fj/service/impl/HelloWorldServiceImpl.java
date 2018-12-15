package cc.fj.service.impl;

import cc.fj.dao.HelloWorldDao;
import cc.fj.dao.Test2Dao;
import cc.fj.dao.Test3Dao;
import cc.fj.service.HelloWorldService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asus on 2015/11/20.
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    private int i=1;

    @Resource
    private HelloWorldDao helloWorldDao;

    @Resource
    private Test2Dao test2Dao;

    @Resource
    private Test3Dao test3Dao;

    @Override
    public List<Map<String, Object>> getHelloWorld() {
        System.out.println("HelloWorldSerivceImpl");
        return helloWorldDao.getHelloWorld();
    }

    @Override
    public void insert() {
        Map<String,Object> m1=new HashMap<String, Object>();
        m1.put("name","kobe");
        m1.put("value","35");
        test2Dao.insert(m1);

        Map<String,Object> m2=new HashMap<String, Object>();
        m2.put("name","bryant");
        m2.put("value","36");
        test3Dao.insert(m2);

        i++;
        if(i%2==0){
            throw new RuntimeException("roll back");
        }

    }
}
