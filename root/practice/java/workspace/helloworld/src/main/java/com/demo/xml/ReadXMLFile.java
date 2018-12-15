package com.demo.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.xpath.XPath;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ReadXMLFile {
	
	static String prefix="x";
	public static void main(String[] args) {

	  SAXBuilder builder = new SAXBuilder();
	  File xmlFile = new File("pom.xml");

	  try {
		  System.out.println("document");
		  
		  builder.setValidation(false); 
		  
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
			  
		  });
		Document document = (Document) builder.build(xmlFile);
		//Element rootNode = document.getRootElement();
		
		
		Element root=document.getRootElement();
		
		String str[]={"project","dependencies"};
		String xpathExpression=getXPathExpression(str);
		xpathExpression+="/x:project/x:name=\"msg-manager\"";
		XPath xpath = XPath.newInstance(xpathExpression);
		if(null!=prefix){
			xpath.addNamespace(prefix, document.getRootElement().getNamespaceURI());
		}
		List<Element> elementList= xpath.selectNodes(document);
		
		System.out.println(elementList.size());
		
		
		/*root.addContent("<ba>fff</ba");
		System.out.println(document);
		System.out.println("ok");
		
		Format forMat = Format.getPrettyFormat();
		forMat.setEncoding("UTF-8");
		XMLOutputter out = new XMLOutputter(forMat);
		String xml = out.outputString(document);*/
		
		//System.out.println(xml);
		
		
		/*XPath xpath = XPath.newInstance("x:beans/x:bean/x:property[@name=\"url\"]/x:value");
	    xpath.addNamespace("x", document.getRootElement().getNamespaceURI());
	    List list=xpath.selectNodes(document);
	    System.out.println(list);*/
	   /* Element e=(Element) xpath.selectSingleNode(document);
	    System.out.println(e.getName()+e.getValue());
	    System.out.println(e.getAttributeValue("base-package"));*/

		
		/*XPath xpath = XPath.newInstance("x:project/x:t[x:name=\"ab\"]");
	    xpath.addNamespace("x", document.getRootElement().getNamespaceURI());
	    Element e=(Element) xpath.selectSingleNode(document);
	    System.out.println(e.getName()+e.getValue());
	    
	    e.setText("abc");
	    System.out.println(e.getName()+e.getValue());*/
		
		
		
		/*Namespace namespace=rootNode.getNamespace();
		
		System.out.println(namespace);
		
		
		System.out.println(rootNode);
		List<Element> eleList=rootNode.getChildren();*/
		
		//rootNode.getChild("name", "a11");
		/*Element child=rootNode.getChild("name", Namespace.getNamespace("a11"));
		System.out.println(child);
		System.out.println(eleList.size());*/
		/*for(Element e:eleList){
			System.out.println(e);
			System.out.println(e.getName());
		}*/
		//System.out.println(e);
		
		/*Element ele=(Element) XPath.selectSingleNode(document, "project");
		
		System.out.println(ele);*/
		/*List list = rootNode.getChildren("staff");

		for (int i = 0; i < list.size(); i++) {

		   Element node = (Element) list.get(i);

		   System.out.println("First Name : " + node.getChildText("firstname"));
		   System.out.println("Last Name : " + node.getChildText("lastname"));
		   System.out.println("Nick Name : " + node.getChildText("nickname"));
		   System.out.println("Salary : " + node.getChildText("salary"));

		}*/

	  } catch (IOException io) {
		System.out.println(io.getMessage());
	  } catch (JDOMException jdomex) {
		System.out.println(jdomex.getMessage());
	  }
	}
	
	static public String getXPathExpression(String str[]){
		String xpath="";
		String slash="/";
		String prefixColon=prefix+":";
		for(String s:str){
			if(null!=prefix){
				xpath+=slash+prefixColon+s;
			}else{
				xpath=slash+s;
			}
		}
		return xpath;
	}
}