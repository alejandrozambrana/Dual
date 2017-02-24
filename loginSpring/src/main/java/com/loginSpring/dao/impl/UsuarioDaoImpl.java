package com.loginSpring.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.loginSpring.dao.UsuarioDao;
import com.loginSpring.dto.UsuarioDto;
import com.loginSpring.form.SeachForm;
import com.loginSpring.form.UsuarioForm;


@Component
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	protected Session getSession(){
        return sessionFactory.openSession();
	}
	
	public boolean checkLogin(String login, String clave){
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY = "from UsuarioDto u where u.login=:login and u.clave=:clave";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter("login",login);
		query.setParameter("clave",clave);
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}

		session.close();
		return userFound;              
   }

	 @Override
	public void addUsuario(UsuarioForm usuarioForm) {
		UsuarioDto usuario = new UsuarioDto();
		usuario.setUsuarioId(usuarioForm.getId());
		usuario.setLogin(usuarioForm.getLogin());
		usuario.setClave(usuarioForm.getClave());
		sessionFactory.openSession().saveOrUpdate(usuario);
	}

	@SuppressWarnings("unchecked")
	public List<UsuarioDto> displayEmployee(UsuarioForm usuarioForm) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UsuarioDto.class);
		List<UsuarioDto> usuarios = new ArrayList<UsuarioDto>();
		usuarios = criteria.list();

		return usuarios;
	}

	@SuppressWarnings("unchecked")
	public List<UsuarioDto> findUsuario(SeachForm seachForm) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String sql = "SELECT USUARIO_ID FROM USUARIO";
		String where = "";

		if (seachForm.getLogin() != "") {
			where = " where LOGIN like '%" + seachForm.getLogin() + "%'";
		}

		if (seachForm.getClave() != "") {
			where = " where CLAVE like '%" + seachForm.getClave() + "%'";
		}

		if (seachForm.getUsuarioId() != null) {
			if (where == "") {
				where = " where USUARIO_ID=" + seachForm.getUsuarioId();
			} else {
				where = where + " and USUARIO_ID=" + seachForm.getUsuarioId();
			}
		}

		Query query = session.createQuery(sql + where);
		tx.commit();
		return query.list();
	}

	public UsuarioForm findUsuario(int id) {
		Session session = sessionFactory.openSession();
		String sql = "select USUARIO_ID from USUARIO where USUARIO_ID=" + id;
		Query query = session.createQuery(sql);
		UsuarioDto usuario = (UsuarioDto) query.list().get(0);
		UsuarioForm usuarioForm = new UsuarioForm();
		usuarioForm.setId(usuario.getUsuarioId());
		usuarioForm.setLogin(usuario.getLogin());
		usuarioForm.setClave(usuario.getClave());
		return usuarioForm;
	}

	public UsuarioDto loadUsuario(int id) {
		Session session = sessionFactory.openSession();
		String sql = "select USUARIO_ID from USUARIO where USUARIO_ID=" + id;
		Query query = session.createQuery(sql);
		UsuarioDto usuario = (UsuarioDto) query.list().get(0);
		return usuario;
	}
	
}
