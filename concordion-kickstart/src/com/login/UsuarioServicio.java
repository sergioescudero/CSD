package com.login;

import dao.UserDao;
import entity.User;

public class UsuarioServicio {
	
	private UserDao ud;

	
	public UserDao getUd() {
		return ud;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public UsuarioServicio(){
	}

	public boolean insertarUsuario(String user, String pwd,
			String nombre, String correo) {
		if (ud.findById(user)==null){
			User usuario = new User();
			usuario.setName(nombre);
			usuario.setEmail(correo);
			usuario.setUserId(user);
			ud.setPassword(usuario, pwd);
			ud.insert(usuario);
			return true;
		}
		return false;
	}

	public boolean comprobarLogin(String user, String pwd) {
		User u = ud.findById(user);
		return ud.isValidPassword(u, pwd);
	}

}
