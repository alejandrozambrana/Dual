package com.loginSpring.dao;

import java.util.List;

import com.loginSpring.dto.UsuarioDto;
import com.loginSpring.form.SeachForm;
import com.loginSpring.form.UsuarioForm;

public interface UsuarioDao {
	public boolean checkLogin(String userName, String userPassword);
	public void addUsuario(UsuarioForm usuarioForm);
	public List<UsuarioDto> displayEmployee(UsuarioForm usuarioForm);
	public List<UsuarioDto> findUsuario(SeachForm seachForm);
	public UsuarioForm findUsuario(int id);
	public UsuarioDto loadUsuario(int id);
}
