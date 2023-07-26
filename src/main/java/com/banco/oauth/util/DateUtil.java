package com.banco.oauth.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DateUtil {
	
	@Value("${jms.jwt.timezone}")
	private String TIMEZONE;
	
	private SimpleDateFormat simpleDateFormat() {
		SimpleDateFormat sdtf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		sdtf.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
		return sdtf;
	}
	
	public String getDateString() {
		Date now = new Date();
		return simpleDateFormat().format(now);
	}
	
	public Long getDateMillis() {
		Date now = new Date();
		String strDate = simpleDateFormat().format(now);
		Date strNow = new Date();
		
		try {
			strNow = simpleDateFormat().parse(strDate);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return strNow.getTime();
		}
	

}
