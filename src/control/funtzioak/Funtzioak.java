package control.funtzioak;

import java.util.ArrayList;
import java.util.Date;

import org.mindrot.jbcrypt.BCrypt;
import model.objektuak.*;

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
	
	public static Date StringToDate(String dateTXT) {
		String[] dateArray = dateTXT.split("-");
		int year = (Integer.parseInt(dateArray[0])-1900);
		int month = Integer.parseInt(dateArray[1]);
		int day = Integer.parseInt(dateArray[2]);
		Date returnDate = new Date(year,month,day);
		
		return returnDate;
	}
	
	public static int getIndexFromHizkuntzak(ArrayList<Hizkuntza> hizkuntzak, String hiz) {
		for (int i = 0; i< hizkuntzak.size(); i++) {
			if (hizkuntzak.get(i).getID_Hizkuntza().equals(hiz)) {
				return i;
			}
		}
		return -1;
	}

}
