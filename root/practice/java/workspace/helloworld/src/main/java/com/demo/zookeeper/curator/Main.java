package com.demo.zookeeper.curator;

import java.util.List;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.log4j.Logger;

public class Main {

	private static final Logger logger=Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String zookeeperConnectionString="127.0.0.1:2181";

		
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		CuratorFramework client = CuratorFrameworkFactory.newClient(zookeeperConnectionString, retryPolicy);
		client.start();
		
		
		try {
			
			String node="/";
			
			//String value=client.create().forPath(node);
			
			String paramString="/zookeeper";
			List<String> list=client.getChildren().forPath(paramString);
			
			
			
			logger.debug(list);
			
			
			byte[] value=client.getData().forPath(paramString);
			
			
			logger.debug(new String(value));
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
