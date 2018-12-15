package com.demo.log4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class Main {

	private static final Logger logger = Logger.getLogger(Main.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Object> scopeOutParam = new HashMap<String, Object>();
		scopeOutParam.put("1", "2");
		List<String> linkIdArr=new ArrayList<String>();
		linkIdArr.add("11");
		scopeOutParam.put("array", linkIdArr);
		String message="map:scopeOutParam" + scopeOutParam;
		logger.debug(message);

	}

}
