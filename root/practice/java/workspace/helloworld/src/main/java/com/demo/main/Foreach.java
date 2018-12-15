package com.demo.main;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.VelocityContext;
  
public class Foreach
{
    public static void main(String[] args) throws Exception {
    	Properties p = new Properties();  
    	p.put("file.resource.loader.class",  
    	"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");  
        FileWriter file = null;
        try {
            Velocity.init(p);
            VelocityContext context = new VelocityContext();
            java.util.List<String> list = new ArrayList<String>();
            list.add("java");
            list.add("c++");
            list.add("c#");
            context.put("langList", list);
            
            file = new FileWriter(new File("out.html"));
            
            Velocity.mergeTemplate("foreach.vm", "UTF-8", context, file);
            System.out.println("ok");
        } catch (Exception ex) {
        	ex.printStackTrace();
            System.out.println("\nException : " + ex.getMessage());
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (Exception ex2) {
                }
            }
        }
    }
}
