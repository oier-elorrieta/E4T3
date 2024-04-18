package control.funtzioak;

import java.awt.Rectangle;

import model.Aldagaiak;
import vista.*;

public class FuntzioBista {
	
	public static void cambioVentana(Rectangle Cordenada, int x, int y) {
		cordenadas(Cordenada);
		resolucion(x, y);
	}
	
	public static void cordenadas(Rectangle Cordenada) {
		Aldagaiak.cordX = (int)Cordenada.getX();
		Aldagaiak.cordY = (int)Cordenada.getY();
	}
	
	public static void resolucion(int x, int y) {
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
	
}
