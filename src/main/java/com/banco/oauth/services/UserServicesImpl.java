package com.banco.oauth.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banco.oauth.dao.IUserDao;
import com.banco.oauth.dto.UserCredit;
import com.banco.oauth.response.UsuariosResponseRest;

@Service
public class UserServicesImpl implements IUserService{

	@Autowired
	private IUserDao userDao;

	@Override
	public ResponseEntity<UsuariosResponseRest> save(UserCredit user) {

		UsuariosResponseRest response = new UsuariosResponseRest();
		
		List<UserCredit> userSave = (List<UserCredit>) userDao.save(user);

		response.setUsuarioResponse(userSave);

		response.setMetadata("Respuesta ok", "00", "Usuario guardado");
		
		return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UsuariosResponseRest> userList() {

		UsuariosResponseRest response = new UsuariosResponseRest();
		
		List<UserCredit> users = (List<UserCredit>) userDao.findAll();
		response.setUsuarioResponse(users);

		response.setMetadata("Respuesta ok", "00", "Usuarios listados");
		
		return new ResponseEntity<UsuariosResponseRest>(response, HttpStatus.OK);
	}

}
