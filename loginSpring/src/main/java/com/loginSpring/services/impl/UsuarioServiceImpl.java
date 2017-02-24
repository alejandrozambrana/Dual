package com.loginSpring.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.loginSpring.dao.UsuarioDao;
import com.loginSpring.dto.UsuarioDto;
import com.loginSpring.form.SeachForm;
import com.loginSpring.form.UsuarioForm;
import com.loginSpring.services.UsuarioService;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	public boolean checkLogin(String userName, String userPassword){
        return usuarioDao.checkLogin(userName, userPassword);
 }
	
	@Override
	public void addUsuario(UsuarioForm usuarioForm) {

		usuarioDao.addUsuario(usuarioForm);
	}

	public List<UsuarioDto> findUsuario(SeachForm seachForm) {

		return usuarioDao.findUsuario(seachForm);
	}

	@Override
	public List<UsuarioDto> displayUsuario(UsuarioForm usuarioForm) {
		// TODO Auto-generated method stub
		return usuarioDao.displayEmployee(usuarioForm);
	}

	public UsuarioForm findUsuario(int id) {
		return usuarioDao.findUsuario(id);
	}

}
