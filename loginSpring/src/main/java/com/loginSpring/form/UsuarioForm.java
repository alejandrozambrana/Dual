package com.loginSpring.form;


import org.hibernate.validator.constraints.NotEmpty;

public class UsuarioForm {
	private int usuario_id;

	@NotEmpty(message = "Please Specify Login")
	private String login;

	@NotEmpty(message = "Please Specify Clave")
	private String clave;

	public int getId() {
		return usuario_id;
	}

	public void setId(Integer usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
