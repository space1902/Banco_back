package com.banco.oauth.response;

import java.util.List;

import com.banco.oauth.dto.UserCredit;

public class UsuariosResponseRest extends ResponseRest{


	private UsuariosResponse usuarioResponse = new UsuariosResponse();

	public UsuariosResponse getUsuarioResponse() {
		return usuarioResponse;
	}

	public void setUsuarioResponse(List<UserCredit> users) {
		this.usuarioResponse = (UsuariosResponse) users;
	}
	

}
