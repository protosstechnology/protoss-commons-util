package com.protosstechnology.commons.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateUtil {
	
	private DateUtil() {
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
}
