package com.loginSpring.services;

import java.util.List;

import com.loginSpring.dto.UsuarioDto;
import com.loginSpring.form.UsuarioForm;

public interface UsuarioService {
	public boolean checkLogin(String userName, String userPassword);
	public void addUsuario(UsuarioForm usuarioForm);
	public List<UsuarioDto> displayUsuario(UsuarioForm usuarioForm);
	public UsuarioForm findUsuario(int id);
}
