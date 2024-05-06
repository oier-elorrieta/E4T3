package control.funtzioak;

import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.mindrot.jbcrypt.BCrypt;

import model.Aldagaiak;
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
	
	/**
     * Testu bat (String) data bihurtzen du, urtea, hilabetea, eta eguna
     * adierazten dituzten zatiak erabiltzen ditu.
     * 
     * @param dateTXT Testu formatuan dagoen data, "YYYY-MM-DD" formatua erabiliz
     * @return Data objektua
     */
    public static Date StringToDate(String dateTXT) {
        String[] dateArray = dateTXT.split("-");
        int year = (Integer.parseInt(dateArray[0]) - 1900); // Date klaseak 1900 urtetik zenbatzen du
        int month = Integer.parseInt(dateArray[1]); // Hilabetea 1-12 bitartean
        int day = Integer.parseInt(dateArray[2]); // Eguna 1-31 bitartean
        @SuppressWarnings("deprecation")
        Date returnDate = new Date(year, month, day);
        return returnDate;
    }

    /**
     * Hizkuntzen zerrenda batean hizkuntza baten indizea aurkitzen du.
     * 
     * @param hizkuntzak Hizkuntzen zerrenda
     * @param hiz Bilatu nahi den hizkuntza
     * @return Hizkuntza aurkitu den indizea, edo -1 ez bada aurkitu
     */
    public static int getIndexFromHizkuntzak(ArrayList<Hizkuntza> hizkuntzak, String hiz) {
        for (int i = 0; i < hizkuntzak.size(); i++) {
            if (hizkuntzak.get(i).getID_Hizkuntza().equals(hiz)) {
                return i; // Hizkuntza aurkitu den indizea
            }
        }
        return -1; // Hizkuntza ez bada aurkitu
    }

    
    public static String secondsToString(int time) {
    	int hor;
    	int min;
    	int seg;
    	
    	if(time >= 3600) {
    		hor = time/ 3600;
    		min = (time % 3600) / 60;
    		return hor+"h:"+min+"m";
    	}else {
    		min = time / 60;
    		seg = time % 60;
    		return min+"m:"+seg+"s";
    	}
    }
    
    public static void skipBaimendu() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				Aldagaiak.skipSong = true;
				System.out.println("skip");
			}
		};
		
		timer.schedule(task, 10000);
    }
    
    
    
}
