import java.util.HashSet;
import java.util.Set;


public class MailList {

	public Set<String> getMails(String listado) {
		Set<String> listaMails = new HashSet<String>();
		
		String[] arrayMails = listado.split(",");
		
		for (String email : arrayMails) {
			boolean esValido = new MailVerifier().isValidEmailAddress(email.trim());
			if(esValido){
				listaMails.add(email.trim());
			}
		}
		
		return listaMails;
	}

	
}
