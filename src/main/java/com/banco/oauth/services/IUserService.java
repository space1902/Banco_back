package com.banco.oauth.services;

import org.springframework.http.ResponseEntity;

import com.banco.oauth.dto.UserCredit;
import com.banco.oauth.response.UsuariosResponseRest;

public interface IUserService {
 
	public ResponseEntity<UsuariosResponseRest> save(UserCredit user);
	public ResponseEntity<UsuariosResponseRest> userList();
	
}
