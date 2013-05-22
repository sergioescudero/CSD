package specs.exampleLogin;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import com.login.UsuarioServicio;

import dao.UserDao;

@RunWith(ConcordionRunner.class)
public class loginTest {

	private UsuarioServicio us = new UsuarioServicio();
	
	public String comprobarLogin(String user, String pwd){
		if (us.comprobarLogin(user, pwd)){
			return "SI";
		}
					
		return "NO";
	}
	
	public String altaUsuario(String user, String pwd, String nombre, String correo){
		if (us.insertarUsuario(user,pwd,nombre,correo)){
			return "SI";
		}
		return "NO";
	}
}
