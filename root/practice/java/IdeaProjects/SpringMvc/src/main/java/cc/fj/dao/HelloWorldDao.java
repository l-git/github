package cc.fj.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by asus on 2015/11/20.
 */
@Repository
public interface HelloWorldDao {

    public List<Map<String,Object>> getHelloWorld();
}
