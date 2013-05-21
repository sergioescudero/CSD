import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;


public class TestMailList {

	MailList mailList = new MailList();
	@Test
	public void testObtenerListado() {
		String listado = "hemarque@gmail.com, jj@@acme.com, abc @hotmail.com, xyz@abc";
		Set<String> correos = mailList.getMails(listado); 
		assertTrue(correos.contains("hemarque@gmail.com"));
	}

	@Test
	public void testObtenerListadoCorreosValidos() {
		String listado = "hemarque@gmail.com, jj@@acme.com, abc @hotmail.com, xyz@abc";
		Set<String> correos = mailList.getMails(listado); 
		assertFalse(correos.contains("jj@@acme.com"));
		assertFalse(correos.contains("abc @hotmail.com"));
		assertFalse(correos.contains("xyz@abc"));
	}
	
	@Test
	public void testListadoSinDuplicados(){
		String listado = "hemarque@gmail.com, hemarque@gmail.com";
		Set<String> correos = mailList.getMails(listado); 
		assertTrue(correos.contains("hemarque@gmail.com") && correos.size()==1);
	}
	
	@Test
	public void testNoDevuelveNull(){
		String listado = "";
		Set<String> correos = mailList.getMails(listado); 
		assertTrue(correos != null);
		assertTrue(correos.size()==0);
	}
}
