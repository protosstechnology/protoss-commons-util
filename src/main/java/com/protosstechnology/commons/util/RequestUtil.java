package com.protosstechnology.commons.util;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
	
	private RequestUtil() {
		super();
	}

	public static Map<String,String> getMapParam(Map<String,String[]> parameterMap){
		Map<String,String> mapContext = new HashMap();
		for(Object key:parameterMap.entrySet()){
			String value = parameterMap.get(key)[0];
			mapContext.put(String.valueOf(key), value);
		}
		return mapContext;
	}
	
	public static String getUsername(HttpServletRequest request){
		if(request.getHeader("authorization") !=null){
			String userToken = request.getHeader("authorization").replaceAll("Basic ", "");
			byte[] decodedBytes = Base64.getDecoder().decode(userToken);
			String decodedString = new String(decodedBytes);
			return decodedString.split(":")[0];
		}else if(request.getParameter("username") !=null){
			return request.getParameter("username");
		}else{
			return "DEFAULT";
		}
		
	}
	
	public static String getValueString(String value1,String value2){
		if(value1 !=null){
			return value1;
		}else{
			return value2;
		}
		
	}
}
