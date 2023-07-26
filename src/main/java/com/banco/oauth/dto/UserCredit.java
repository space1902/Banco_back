package com.banco.oauth.dto;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserCredit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	
	private String nombre;
	
	private Float monto;
	
	private int plazoMeses;
	
	private Float interesEA;
	
	private Float cuotaMensual;
}
