package control.funtzioak;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Erabilgarritasun funtzioak gordetzen dituen klasea.
 */
public class Funtzioak {

	/**
	 * Aplikazioa hasieratzeko metodoa.
	 */
	public static void hasieratu() {
		FuntzioBista.irekiLogin();
	}

	/**
	 * Testu kate bat BCrypt algoritmoa erabiliz enkriptatzeko metodoa.
	 * 
	 * @param txt enkriptatu beharreko testu katea.
	 * @return enkriptatutako katea.
	 */
	public static String enkriptatzailea(String txt) {
		String enkriptatuta;

		enkriptatuta = BCrypt.hashpw(txt, BCrypt.gensalt());

		return enkriptatuta;
	}

}
