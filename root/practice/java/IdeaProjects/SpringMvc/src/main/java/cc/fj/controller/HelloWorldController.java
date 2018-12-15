package cc.fj.controller;

import cc.fj.model.Shop;
import cc.fj.service.HelloWorldService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by asus on 2015/11/20.
 */

@Controller
@RequestMapping("HelloWorld")
public class HelloWorldController {

    private static Logger logger=Logger.getLogger(HelloWorldController.class);

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("index")
    public String index(){
        try {
            logger.info("HelloWorldController index");
            List<Map<String, Object>> mapList = helloWorldService.getHelloWorld();
            logger.info(mapList);

            helloWorldService.insert();

        }catch(Exception e){
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value="interceptor")
    public String interceptor(){
        System.out.println("interceptor controller");
        return "interceptor";
    }

    @RequestMapping(value="exception")
    public String exception() throws Exception {
        System.out.println("exception controller");
        if(true){
            throw new Exception("this is exception throw from HelloWorldController exception method");
        }
        return "exception";
    }

    @RequestMapping(value="{name}")
    @ResponseBody
    public Shop getShopInJson(@PathVariable String name){
        Shop shop=new Shop();
        shop.setName(name);
        shop.setStaffName(new String[]{"stuff1","stuff2"});
        return shop;
    }

    @RequestMapping(value="echostr")
    @ResponseBody
    public String echostr(){

        return "echostr";
    }
}
