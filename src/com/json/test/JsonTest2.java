package com.json.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTest2 {
	public static void main(String[] args) {
		
		JSONParser jp=new JSONParser();
		String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
		
		Object obj;
		try {
			obj = jp.parse(s);
			JSONArray ja=(JSONArray)obj;
			System.out.println(ja.get(1));
			
			JSONObject jb2=(JSONObject)(ja.get(1));
			System.out.println(jb2.get("1"));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
