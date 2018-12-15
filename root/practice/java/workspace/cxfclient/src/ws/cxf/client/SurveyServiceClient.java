package ws.cxf.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ws.cxf.HelloService;
import ws.cxf.ISurveyService;
import ws.cxf.User;
 
public class SurveyServiceClient
{
    public static void main(String[] args)
    {
        // 加载客户端的配置定义
        ApplicationContext context = new 
                ClassPathXmlApplicationContext("beanRefClient.xml");
        // 获取定义的 Web Service Bean
        ISurveyService surveyService = 
            (ISurveyService)context.getBean("surveyServiceClient");
        // 1、定义调查投票的变量与内容，用来发送给服务
        String username = "Test";
        int point = 88;
        // 调用方法进行服务消费
        String result = surveyService.vote(username,point);
        System.out.println("Result:" + result);
        // 2、传递不一样的调查投票内容
        username = "Michael";
        point = 100;
        // 再次调用方法进行服务消费，得到不一样的结果
        result = surveyService.vote(username,point);
        System.out.println("Result:" + result);
        // 3、第三次传递与调用
        username = "Jordan";
        point = 9;
        result = surveyService.vote(username,point);
        System.out.println("Result:" + result);
        
        
        
        System.out.println("=================================" );
        
        
        
        
        
        
        HelloService helloService=(HelloService) context.getBean("helloServiceClient");
        String r=helloService.f("1234", "5ffffff678");
        
        System.out.println(r);
        
        
        String r1=helloService.f2("65", 1000L);
        System.out.println(r1);
        
        
        
        User u=helloService.getUser(1L);
        
        
        System.out.println(u);
        
        
        
        
        
    }
}
