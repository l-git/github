package com.demo.velocity;

import java.io.StringWriter;






import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;



import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
public class HelloWorld
{
    public static void main( String[] args )
        throws Exception
    {
    	
    	
    	
    	Element company = new Element("company");
		Document doc = new Document(company);
		doc.setRootElement(company);

		Element list = new Element("list");
		
		company.addContent(list);
		
		
		Element staff = new Element("staff");
		staff.setAttribute(new Attribute("id", "1"));
		staff.addContent(new Element("firstname").setText("yong"));
		staff.addContent(new Element("lastname").setText("mook kim"));
		staff.addContent(new Element("nickname").setText("mkyong"));
		staff.addContent(new Element("salary").setText("199999"));

		doc.getRootElement().addContent(staff);

		Element staff2 = new Element("staff");
		staff2.setAttribute(new Attribute("id", "2"));
		staff2.addContent(new Element("firstname").setText("low"));
		staff2.addContent(new Element("lastname").setText("yin fong"));
		staff2.addContent(new Element("nickname").setText("fong fong"));
		staff2.addContent(new Element("salary").setText("188888"));

		doc.getRootElement().addContent(staff2);

		// new XMLOutputter().output(doc, System.out);
		XMLOutputter xmlOutput = new XMLOutputter();

		// display nice nice
		xmlOutput.setFormat(Format.getPrettyFormat());
		xmlOutput.output(doc, new FileWriter("c:\\file.xml"));
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
        /*  first, get and initialize an engine  */
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        System.out.println(System.getProperty("user.dir"));
        /*  next, get the Template  */
        Template t = ve.getTemplate( "helloworld.vm" );
        /*  create a context and add data */
        VelocityContext context = new VelocityContext();
        context.put("name", "World");
        
        
        context.put("company", company);
        
        
        
        List<String> l=new ArrayList<String>();
        
        for(int i=0;i<3;i++){
        	l.add(i+"");
        }
        
        
        context.put("l", l);
        
        List<A> aList=new ArrayList<A>();
        
        for(int i=0;i<5;i++){
        	A a=new A();
        	a.setS(i+"");
        	aList.add(a);
        	context.put("a"+i, a);
        }
        
        
        context.put("aList", aList);
        
        
        
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge( context, writer );
        /* show the World */
        System.out.println( writer.toString() );     
    }
    
    
    
    
    
    
}

