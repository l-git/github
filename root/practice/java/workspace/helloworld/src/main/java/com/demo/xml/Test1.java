package com.demo.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SAXBuilder builder = new SAXBuilder();
		  File xmlFile = new File("org.eclipse.wst.common.component");

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
			Element wm=root.getChild("wb-module");
			System.out.println(wm.getText());
			List<Element> wrList=wm.getChildren("wb-resource");
			
			System.out.println(wrList);
			
			for(Element e:wrList){
				
				System.out.println(e.getAttribute("source-path"));
				
				
			}
			
			
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		
		
		
	}

}
