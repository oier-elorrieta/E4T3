package control.funtzioak;

import org.mindrot.jbcrypt.BCrypt;

public class Funtzioak {
	
	public static void hasieratu() {
		FuntzioBista.irekiLogin();
	}
	
	public static String enkriptatzailea(String txt) {
		String enkriptatuta;
		
		enkriptatuta = BCrypt.hashpw(txt, BCrypt.gensalt());
		
		return enkriptatuta;
	}
	
}
