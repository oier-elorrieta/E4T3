package control.funtzioak;

import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.mindrot.jbcrypt.BCrypt;

import model.Aldagaiak;
import model.objektuak.*;

public class Funtzioak {

    /**
     * Aplikazioa hasteko motodoa.
     * Login lehioa irekitzen du
     */
    public static void hasieratu() {
        FuntzioBista.irekiLogin();
    }

    /**
     * String batek enkriptatzen duen metodoa
     * 
     * @param txt enkriptatzen den metodoa
     * @return txt enkriptatuta
     */
    public static String enkriptatzailea(String txt) {
        return BCrypt.hashpw(txt, BCrypt.gensalt());
    }

    /**
     * String batetik Date batera pasatzen duen metodoa
     * Formatua "YYYY-MM-DD" da.
     * 
     * @param dateTXT data string moduan jasotzen duena "YYYY-MM-DD".
     * @return Date objetu bat.
     */
    @SuppressWarnings("deprecation")
	public static Date stringToDate(String dateTXT) {
        String[] dateArray = dateTXT.split("-");
        int year = (Integer.parseInt(dateArray[0]) - 1900);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);
        Date returnDate = new Date(year, month, day);
        try {
        	returnDate.setYear(Integer.parseInt(dateArray[0]) - 1900); // Date klaseak 1900 urtetik zenbatzen du
        	returnDate.setMonth(Integer.parseInt(dateArray[1])); // Hilabetea 1-12 bitartean
        	returnDate.setDate(Integer.parseInt(dateArray[2])); // Eguna 1-31 bitartean
	        
        }catch (Exception ex) {
        	
        }
        return returnDate;
    }
    
    /**
     * String batetik Date batera pasatzen duen metodoa
     * Formatua "YYYY-MM-DD" da.
     * 
     * @param dateTXT data string moduan jasotzen duena "YYYY-MM-DD".
     * @return Date objetu bat.
     */
    @SuppressWarnings("deprecation")
	public static String dateToString(Date date) {
        String dataTXT = "";
        int year = date.getYear() + 1900;
        int month = date.getMonth() + 1;
        dataTXT = year + "-" + month + "-" + date.getDate();
        return dataTXT;
    }
    
    /**
     * String batetik Date batera pasatzen duen metodoa
     * Formatua "YYYY-MM-DD" da.
     * 
     * @param dateTXT data string moduan jasotzen duena "YYYY-MM-DD".
     * @return Date objetu bat.
     */
    @SuppressWarnings("deprecation")
	public static Date date1YearMore(Date date) {
    	int year = date.getYear() + 1;
    	date.setYear(year);
        return date;
    }

    /**
     * Hitzkuntza baten indizea bilatzen duen metodoa.
     * 
     * @param hizkuntzak Hizkuntza lista.
     * @param hiz Hitzkuntzaren ID-a.
     * @return Hitzkuntzaren indizea, ez badu aurkitzen -1.
     */
    public static int getIndexFromHizkuntzak(ArrayList<Hizkuntza> hizkuntzak, String hiz) {
        for (int i = 0; i < hizkuntzak.size(); i++) {
            if (hizkuntzak.get(i).getID_Hizkuntza().equals(hiz)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Int batekin denborara konbertitzen duen metodoa formato honeri "h:m:s".
     * 
     * @param time denbora segundutan.
     * @return denbora kadena formato honekin "h:m:s".
     */
    public static String secondsToString(int time) {
        int hor;
        int min;
        int seg;
        
        if (time >= 3600) { 
            hor = time / 3600;
            min = (time % 3600) / 60;
            return hor + "h:" + min + "m";
        } else { 
            min = time / 60;
            seg = time % 60;
            return min + "m:" + seg + "s";
        }
    }

    /**
     * 10 minuturo permititzen duen metodoa (10 segundu orain).
     */
    public static void skipBaimendu() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                Aldagaiak.skipSong = true;
            }
        };
        
        timer.schedule(task, 10);
    }
    public static String longToString(long time) {
    	int miliseconds = 0;
    	miliseconds = (int)time/1000000;
    	return secondsToString(miliseconds);
    }
}
