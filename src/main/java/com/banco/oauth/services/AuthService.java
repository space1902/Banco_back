package com.banco.oauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.banco.oauth.dto.JwtResponse;
import com.banco.oauth.security.JwtIo;
import com.banco.oauth.util.DateUtil;

@Service
public class AuthService {
	
	@Autowired
	private JwtIo jwtIo;
	@Autowired
	private DateUtil dateUtil;
	@Value("${jms.jwt.token.expires-in}")
	private int EXPIRES_IN;	
	
	public JwtResponse login(String clientId, String clientSecret) {
		
		JwtResponse jwt = JwtResponse.builder()
				.tokenType("bearer")
				.accesToken(jwtIo.generateToken("Hola mundo desde auth"))
				.issuedAt(dateUtil.getDateMillis()+"")
				.clientId(clientId)
				.expiresIn(EXPIRES_IN)
				.build();
		return jwt;
		
	}

}
