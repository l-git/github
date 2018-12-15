package com.demo.json;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Main {

	 private String s;
	
	 private List<Main> mainList;
	
	
	 
	 
	public String getS() {
		return s;
	}




	public void setS(String s) {
		this.s = s;
	}




	public List<Main> getMainList() {
		return mainList;
	}




	public void setMainList(List<Main> mainList) {
		this.mainList = mainList;
	}




	public static void main(String args[]){
		
		
		/*String s="{\"layout\": \"layout5\", \"data\" : [{\"title\" : \"公告信息\", \"id\" : \"3\", \"column\" : \"first\",\"editurl\" : \" ?userid=0&portletInstanceId=3\",\"open\" : true,\"url\" : \"system/portlet/index/yw_index_notice?userid=0&portletInstanceId=3\",\"metadata\":{}},{\"title\" : \"问题反馈\", \"id\" : \"1\", \"column\" : \"first\",\"editurl\" : \" ?userid=0&portletInstanceId=1\",\"open\" : true,\"url\" : \"  system/portlet/index/yw_index_feedbackproblem?userid=0&portletInstanceId=1\",\"metadata\":{}},{\"title\" : \"客户统计\", \"id\" : \"5\", \"column\" : \"first\",\"editurl\" : \" ?userid=0&portletInstanceId=5\",\"open\" : true,\"url\" : \"system/portlet/index/client?userid=0&portletInstanceId=5\",\"metadata\":{}},{\"title\" : \"项目考核\", \"id\" : \"6\", \"column\" : \"first\",\"editurl\" : \" ?userid=0&portletInstanceId=6\",\"open\" : true,\"url\" : \"system/portlet/index/review?userid=0&portletInstanceId=6\",\"metadata\":{}},{\"title\" : \"轮播宣传图\", \"id\" : \"9\", \"column\" : \"second\",\"editurl\" : \" ?userid=0&portletInstanceId=9\",\"open\" : true,\"url\" : \"system/portlet/index/yw_index_carousel?userid=0&portletInstanceId=9\",\"metadata\":{}},{\"title\" : \"项目统计\", \"id\" : \"7\", \"column\" : \"second\",\"editurl\" : \" ?userid=0&portletInstanceId=7\",\"open\" : true,\"url\" : \"system/portlet/index/project?userid=0&portletInstanceId=7\",\"metadata\":{}},{\"title\" : \"常用网站\", \"id\" : \"8\", \"column\" : \"third\",\"editurl\" : \" ?userid=0&portletInstanceId=8\",\"open\" : true,\"url\" : \"system/portlet/index/yw_index_externallinks?userid=0&portletInstanceId=8\",\"metadata\":{}},{\"title\" : \"快捷链接通道\", \"id\" : \"4\", \"column\" : \"third\",\"editurl\" : \" ?userid=0&portletInstanceId=4\",\"open\" : true,\"url\" : \"system/portlet/dynamicmodule?userid=0&portletInstanceId=4\",\"metadata\":{}},{\"title\" : \"导出列表\", \"id\" : \"2\", \"column\" : \"third\",\"editurl\" : \" ?userid=0&portletInstanceId=2\",\"open\" : true,\"url\" : \"system/portlet/export?userid=0&portletInstanceId=2\",\"metadata\":{}}]}";
		
		
		s="{\"layout\": \"layout5\", \"data\" : [{\"title\" : \"公告信息\", \"id\" : \"3\", \"column\" : \"first\",\"editurl\" : \" ?userid=0&portletInstanceId=3\",\"open\" : true,\"url\" : \"system/portlet/index/yw_index_notice?userid=0&portletInstanceId=3\",\"metadata\":{}},{\"title\" : \"问题反馈\", \"id\" : \"1\", \"column\" : \"first\",\"editurl\" : \" ?userid=0&portletInstanceId=1\",\"open\" : true,\"url\" : \"  system/portlet/index/yw_index_feedbackproblem?userid=0&portletInstanceId=1\",\"metadata\":{}},{\"title\" : \"客户统计\", \"id\" : \"5\", \"column\" : \"first\",\"editurl\" : \" ?userid=0&portletInstanceId=5\",\"open\" : true,\"url\" : \"system/portlet/index/client?userid=0&portletInstanceId=5\",\"metadata\":{}},{\"title\" : \"项目考核\", \"id\" : \"6\", \"column\" : \"first\",\"editurl\" : \" ?userid=0&portletInstanceId=6\",\"open\" : true,\"url\" : \"system/portlet/index/review?userid=0&portletInstanceId=6\",\"metadata\":{}},{\"title\" : \"轮播宣传图\", \"id\" : \"9\", \"column\" : \"second\",\"editurl\" : \" ?userid=0&portletInstanceId=9\",\"open\" : true,\"url\" : \"system/portlet/index/yw_index_carousel?userid=0&portletInstanceId=9\",\"metadata\":{}},{\"title\" : \"项目统计\", \"id\" : \"7\", \"column\" : \"second\",\"editurl\" : \" ?userid=0&portletInstanceId=7\",\"open\" : true,\"url\" : \"system/portlet/index/project?userid=0&portletInstanceId=7\",\"metadata\":{}},{\"title\" : \"常用网站\", \"id\" : \"8\", \"column\" : \"third\",\"editurl\" : \" ?userid=0&portletInstanceId=8\",\"open\" : true,\"url\" : \"system/portlet/index/yw_index_externallinks?userid=0&portletInstanceId=8\",\"metadata\":{}},{\"title\" : \"快捷链接通道\", \"id\" : \"4\", \"column\" : \"third\",\"editurl\" : \" ?userid=0&portletInstanceId=4\",\"open\" : true,\"url\" : \"system/portlet/dynamicmodule?userid=0&portletInstanceId=4\",\"metadata\":{}},{\"title\" : \"导出列表\", \"id\" : \"2\", \"column\" : \"third\",\"editurl\" : \" ?userid=0&portletInstanceId=2\",\"open\" : true,\"url\" : \"system/portlet/export?userid=0&portletInstanceId=2\",\"metadata\":{}}]}";
		
		JSONObject j=JSONObject.parseObject(s);
		
		System.out.println(j.get("layout"));*/
		
		
		Main m=new Main();
		
		m.s="sss";
		
		System.out.println(JSON.toJSONString(m));
		
		
	}
	
	
}
