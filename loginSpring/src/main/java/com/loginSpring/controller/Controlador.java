package com.loginSpring.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loginSpring.form.SeachForm;
import com.loginSpring.form.UsuarioForm;
import com.loginSpring.services.UsuarioService;


@Controller
public class Controlador {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/index.html")
	public String loadSearchForm(Map model, SeachForm seachForm) {
		model.put("login", seachForm);
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		UsuarioForm loginForm = new UsuarioForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid UsuarioForm loginForm, BindingResult result,
			Map model) {
		
		if (result.hasErrors()) {
			return "incorrecto";
		}

		boolean userExists = usuarioService.checkLogin(loginForm.getLogin(),
                loginForm.getClave());
		if(userExists){
			model.put("loginForm", loginForm);
			return "acceso";
		}else{
			result.rejectValue("login","invaliduser");
			return "incorrecto";
		}

	}
	}
