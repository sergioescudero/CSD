package specs.exampledni;

public class DNI {

	public String comprobarLetra(String dni) {
		String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
		
		int dniNumero = Integer.parseInt(dni);
		int resto = dniNumero % 23;
		
		return letras[resto];
	}

}
