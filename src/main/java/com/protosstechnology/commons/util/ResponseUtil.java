package com.protosstechnology.commons.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;

public class ResponseUtil {
	
	private ResponseUtil() {
		super();
	}

	public static BodyBuilder getResponseOk(){
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
		return ResponseEntity.ok().headers(headers);
	}
	
	public static HttpHeaders getHeaderJson() {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return headers;
	}
	
	
}
