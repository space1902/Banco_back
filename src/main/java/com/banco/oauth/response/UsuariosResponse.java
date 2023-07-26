package com.banco.oauth.response;

import java.util.List;

import com.banco.oauth.dto.UserCredit;

public class UsuariosResponse {
	
	private List<UserCredit> usuarios;

	public List<UserCredit> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UserCredit> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
