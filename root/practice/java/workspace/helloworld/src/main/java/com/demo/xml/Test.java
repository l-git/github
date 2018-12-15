package com.demo.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SAXBuilder builder = new SAXBuilder();
		  File xmlFile = new File("applicationContext-common.xml");

		  try {
			  
			 /* builder.setValidation(false); 
			  
			  builder.setEntityResolver(new EntityResolver(){

				public InputSource resolveEntity(String publicId, String systemId)
						throws SAXException, IOException {
					// TODO Auto-generated method stub
					InputStream stream = new FileInputStream( "mybatis-3-config.dtd" );
					InputSource is = new InputSource(stream);  
	                is.setPublicId(publicId);  
	                is.setSystemId(systemId);  
					return is;
				}
				  
			  });*/
			Document document = (Document) builder.build(xmlFile);
			//Element rootNode = document.getRootElement();
			
			
			Element root=document.getRootElement();
			
			System.out.println(root);
			
			Element e=root.getChild("component-scan",Namespace.getNamespace("http://www.springframework.org/schema/context"));
			
			System.out.println(e);
			
			
			System.out.println(e.getAttributeValue("base-package"));
			
			
			//http://www.springframework.org/schema/tx
			Element ee=root.getChild("advice",Namespace.getNamespace("http://www.springframework.org/schema/tx"));
			System.out.println(ee);
			System.out.println(ee.getAttributeValue("id"));
			
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		
		
		
	}

}
