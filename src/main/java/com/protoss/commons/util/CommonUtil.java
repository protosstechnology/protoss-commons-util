package com.protoss.commons.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.springframework.http.HttpHeaders;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonUtil {
	
	private CommonUtil() {
		super();
	}

	public static Timestamp getCurrentDateTimestamp() {
        Timestamp today = null;
        try {
            Date nowDate = Calendar.getInstance().getTime();
            today = new java.sql.Timestamp(nowDate.getTime());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return today;
    }
	
	public static HttpHeaders getHeaderJson() {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return headers;
	}

}
