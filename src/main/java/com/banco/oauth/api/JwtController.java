package com.banco.oauth.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1.0")
@CrossOrigin(origins = {"http://localhost:4200/"})
public class JwtController {

	@GetMapping(path = "version")
	public ResponseEntity<Object> version(){
		return ResponseEntity.ok("Version 1.0");
	}
}
