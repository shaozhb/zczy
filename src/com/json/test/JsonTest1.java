package com.json.test;
import java.io.IOException;
import java.io.StringWriter;

import org.json.*;
import org.json.simple.JSONObject;

import com.sun.org.apache.xpath.internal.operations.Bool;
public class JsonTest1 {
	
	public static void main(String[] args) {
		
		JSONObject js=new JSONObject();
		js.put("test", "test1");
		js.put("test1", new Integer(100));
		js.put("test2", new Boolean(true));
		
		System.out.println(js);
		
		StringWriter sw=new StringWriter();
		try {
			js.writeJSONString(sw);
			
			String str=js.toString();
			System.out.println(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
