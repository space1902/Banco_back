package com.banco.oauth.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banco.oauth.exceptions.Apiunauthorized;
import com.banco.oauth.services.AuthService;
import com.banco.oauth.validator.AuthValidator;

@RestController
@RequestMapping(path="v1.0")
@CrossOrigin(origins = {"http://localhost:4200/"})
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private AuthValidator validator;
	
	@PostMapping(path = "oauth/client_credential/accestoken")
	public ResponseEntity<Object> login(@RequestBody MultiValueMap<String, String>paramMap, @RequestParam("grant_type")String grantType) throws Apiunauthorized{
		
		validator.validate(paramMap, grantType);
		return ResponseEntity.ok(authService.login(paramMap.getFirst("client_id"), paramMap.getFirst("client_secret")));
	}
}
