package com.loginSpring.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "USUARIO")
public class UsuarioDto {
	
//	long serialVersionUID = 1L;

	@Id
	@Column(name = "USUARIO_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer usuario_id;
	
	@Column(name="LOGIN")
	private String login;
	
	@Column(name="CLAVE")
	private String clave;
	
	public Integer getUsuarioId(){
		return usuario_id;
	}
	
	public void setUsuarioId(Integer usuario_id){
		this.usuario_id = usuario_id;
	}

	public String getLogin(){
		return login;
	}
	
	public void setLogin(String login){
		this.login = login;
	}

	public String getClave(){
		return clave;
	}
	
	public void setClave(String clave){
		this.clave = clave;
	}
	
}
