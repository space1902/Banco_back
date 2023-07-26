package com.banco.oauth.security;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix="jms.jwt")
public class JwtIOProperties {

	private security security;
	private String timezone;
	private String issuer;
	private Token token;
	private Excluded excluded;
	
	@Data
	public static class security{
		private Boolean enable;	
	}
	
	@Data
	public static class Token{
		private Auth auth;
		private String secret;
		private int expires_in;
	}
	
	@Data
	public static class Auth{
		private String path;
	}
	
	@Data
	public static class Excluded{
		private String path;
	}
	
}
