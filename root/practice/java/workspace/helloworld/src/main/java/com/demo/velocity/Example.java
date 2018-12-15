package com.demo.velocity;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.Template;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Example
{
    public Example(String templateFile)
    {
        try
        {

            //Velocity.init("velocity.properties");

            VelocityContext context = new VelocityContext();
            CurrencyUtil cu = new CurrencyUtil();
            cu.setCurrencyRate("EUR", 1.25);
            context.put("formatter", cu); 
            
            List<Person> pList=new ArrayList<Person>();
            
            for(long i=0;i<3;i++){
            	Person p=new Person();
            	p.setId(i);
            	p.setName("name"+i);
            	pList.add(p);
            	
            	A a=new A();
            	a.setS("aaaaa"+i);
            	p.setA(a);
            	
            }
            
            
            context.put("pList", pList);
            
            /*Person p=new Person();
            p.setName("nakkkk");
            context.put("formatter", p); */

            Template template =  null;

            try
            {
                template = Velocity.getTemplate(templateFile);
            }
            catch( ResourceNotFoundException rnfe )
            {
                System.out.println("Example : error : cannot find template " + templateFile );
            }
            catch( ParseErrorException pee )
            {
                System.out.println("Example : Syntax error in template " + templateFile + ":" + pee );
            }


            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(System.out));

            if ( template != null)
                template.merge(context, writer);


            writer.flush();
            writer.close();
        }
        catch( Exception e )
        {
            System.out.println(e);
        }
    }


    public static void main(String[] args)
    {
        Example t = new Example("example.vm");
    }
}
