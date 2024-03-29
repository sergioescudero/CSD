
public class MailVerifier {

	public boolean isValidEmailAddress(String email) {
		boolean resultado = true;
		
		resultado = resultado && isTodosLosCaracteresValidos(email);
		resultado = resultado && hasAlMenosUnaArroba(email);
		resultado = resultado && hasSoloUnaArroba(email);
		resultado = resultado && hasPuntoDespuesDeArroba(email);
		
		return resultado;
	}

	private boolean hasPuntoDespuesDeArroba(String email) {
		int index = email.substring(email.indexOf('@')+1).lastIndexOf(".");
		
		return index >0;
	}

	private boolean hasSoloUnaArroba(String email) {
		
		int index = email.substring(email.indexOf('@')+1).lastIndexOf("@");
		
		return index ==-1;
	}

	private boolean hasAlMenosUnaArroba(String email) {
		return email.contains("@");
	}

	private boolean isTodosLosCaracteresValidos(String email){
		boolean resultado = true;
		String[] caracteresValidos = {" ", ","};
		for (String caracter : caracteresValidos) {
			resultado = resultado && !email.contains(caracter);
		}
		return resultado;
	}
}
