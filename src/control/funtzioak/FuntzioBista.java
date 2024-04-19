package control.funtzioak;


import java.awt.Rectangle;


import model.Aldagaiak;
import vista.*;


public class FuntzioBista {
	
	public static void bistaAldatu(Rectangle kordenada, int x, int y) {
		kordenadak(kordenada);
		resoluzioa(x, y);
	}
	
	public static void kordenadak(Rectangle kordenada) {
		Aldagaiak.cordX = (int)kordenada.getX();
		Aldagaiak.cordY = (int)kordenada.getY();
	}
	
	public static void resoluzioa(int x, int y) {
		Aldagaiak.resolucionX = x;
		Aldagaiak.resolucionY = y;
	}
	
	public static void irekiLogin() {
		try {
			Login frame = new Login();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void irekiErregistroa() {
		try {
			Erregistroa frame = new Erregistroa();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}




