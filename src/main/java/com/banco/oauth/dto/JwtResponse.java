package com.banco.oauth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponse {
	
	@JsonProperty(value="token_type")
	private String tokenType;

	@JsonProperty(value="acces_token")
	private String accesToken;

	@JsonProperty(value="expires_in")
	private int expiresIn;

	@JsonProperty(value="issued_at")
	private String issuedAt;

	@JsonProperty(value="client_id")
	private String clientId;

}
