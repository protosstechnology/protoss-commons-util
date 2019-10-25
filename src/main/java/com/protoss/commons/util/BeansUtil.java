package com.protoss.commons.util;

public class BeansUtil {

	private BeansUtil() {
		super();
	}
	
	public static boolean isNotEmpty(String str) {
		return (str !=null && !str.isEmpty());
	}

}
