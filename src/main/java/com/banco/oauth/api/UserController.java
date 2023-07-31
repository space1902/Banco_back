package com.banco.oauth.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.oauth.dao.IUserDao;
import com.banco.oauth.dto.UserCredit;
import com.banco.oauth.response.UsuariosResponseRest;
import com.banco.oauth.services.IUserService;


@RestController
@RequestMapping(path = "/v1.0/")
@CrossOrigin(origins = {"http://localhost:4200/"})
public class UserController {
	
	@Autowired(required=true)
	private IUserDao userDao;

	@GetMapping(path = "calcular/{monto}/{plazomeses}/{interesea}")
	public ResponseEntity<Object> calcuar(@PathVariable Float monto, @PathVariable Float plazomeses, @PathVariable Float interesea){
		
		float montoPlazo = monto/plazomeses;
		float interesMeses = (interesea/100)/12;
		float cuotaMensual = montoPlazo*(1+interesMeses);
		
		return ResponseEntity.ok(cuotaMensual);
	}
	
	@CrossOrigin
	@GetMapping(path ="listar")
	public ResponseEntity<Object> listar(){
		List<UserCredit> users = userDao.findAll();
		return ResponseEntity.ok(users);
	}
	
	@PostMapping(path ="guardar")
	public ResponseEntity<Object> guardar(@RequestBody UserCredit userCredit ){
		UserCredit users = userDao.save(userCredit);
		return ResponseEntity.ok(users);
	}
	}
