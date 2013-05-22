package unit.com.csd.login;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.login.UsuarioServicio;

import dao.UserDao;
import entity.User;

public class UsuarioServicioTest {


	
	@Test
	public void comprobarDarDeAltaUsuario() {
		UserDao ud = mock(UserDao.class);
		when(ud.findById(anyString())).thenReturn(null);
		UsuarioServicio us = new UsuarioServicio();
		us.setUd(ud);
		assertTrue(us.insertarUsuario("pepe", "clave", "Pepe", "pepe@micorreo.com"));
		User.Builder b = new User.Builder();
		User u = b.name("Pepe").userId("pepe").email("pepe@micorreo.com").build();
		verify(ud).findById("pepe");
		verify(ud).insert(u);
	}

	@Test
	public void comprobarNoDaDeAltaUsuario() {
		UserDao ud = mock(UserDao.class);
		when(ud.findById(anyString())).thenReturn(new User());
		UsuarioServicio us = new UsuarioServicio();
		us.setUd(ud);
		assertFalse(us.insertarUsuario("pepe", "clave", "Pepe", "pepe@micorreo.com"));
		verify(ud).findById("pepe");
		verify(ud,never()).insert((User)anyObject());
	}
	
	@Test
	public void comprobarLoginCorrecto() {
		User.Builder b = new User.Builder();
		User u = b.name("Pepe").userId("pepe").email("pepe@micorreo.com").build();
		
		UserDao ud = mock(UserDao.class);
		when(ud.findById("pepe")).thenReturn(u);
		when(ud.isValidPassword(u, "clave")).thenReturn(true);
		UsuarioServicio us = new UsuarioServicio();
		us.setUd(ud);
		assertTrue(us.comprobarLogin("pepe", "clave"));
		
		verify(ud).findById("pepe");
		verify(ud).isValidPassword(u,"clave");
	}
	
	@Test
	public void comprobarLoginIncorrecto() {
		User.Builder b = new User.Builder();
		User u = b.name("Pepe").userId("pepe").email("pepe@micorreo.com").build();
		
		UserDao ud = mock(UserDao.class);
		when(ud.findById("pepe")).thenReturn(u);
		when(ud.isValidPassword((User)anyObject(), anyString())).thenReturn(false);
		UsuarioServicio us = new UsuarioServicio();
		us.setUd(ud);
		assertFalse(us.comprobarLogin("pepe", "otra"));
		
		verify(ud).findById("pepe");
		verify(ud).isValidPassword(u,"otra");
	}
}
