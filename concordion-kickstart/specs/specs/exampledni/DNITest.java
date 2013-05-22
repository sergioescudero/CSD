package specs.exampledni;


import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class DNITest {

	private DNI dniCheck = new DNI();
	
	public String comprobarLetraDNICorrecta(String dni) {
		if (dni.equals("16584851")){
			return dniCheck.comprobarLetra(dni);
		}
		else{
			return null;
		}
	}

}
