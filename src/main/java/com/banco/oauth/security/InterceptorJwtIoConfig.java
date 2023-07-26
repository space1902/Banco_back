package com.banco.oauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorJwtIoConfig implements WebMvcConfigurer {

	@Value("${jms.jwt.security.enable:false}")
	private boolean securityEnable;
	
	@Autowired
	private InterceptorJwtIo interceptorJwtIo;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		if(securityEnable == true) {
			registry.addInterceptor(interceptorJwtIo);
		}
	}
	
	
}
