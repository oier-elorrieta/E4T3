package control.funtzioak;

import java.awt.Rectangle;

import model.Aldagaiak;
import vista.*;
import vista.bezero.BezeroMenu;

/**
 * Kontrolatzaileak bistaren konfigurazioa kudeatzen duen klasea.
 */
public class FuntzioBista {

	/**
	 * Bistararen kokapena eta neurriak aldatzen dituen metodoa.
	 * @param kordenada Bistaren kokapena
	 * @param x Neurria X ardatzean
	 * @param y Neurria Y ardatzean
	 */
	public static void bistaAldatu(Rectangle kordenada, int x, int y) {
		kordenadak(kordenada);
		resoluzioa(x, y);
	}

	/**
	 * Bistararen kokapena aldatzen duen metodoa.
	 * @param kordenada Bistaren kokapena
	 */
	public static void kordenadak(Rectangle kordenada) {
		Aldagaiak.cordX = (int) kordenada.getX();
		Aldagaiak.cordY = (int) kordenada.getY();
	}

	/**
	 * Bistararen neurriak aldatzen dituen metodoa.
	 * @param x Neurria X ardatzean
	 * @param y Neurria Y ardatzean
	 */
	public static void resoluzioa(int x, int y) {
		Aldagaiak.resolucionX = x;
		Aldagaiak.resolucionY = y;
	}

	/**
	 * Login bista irekitzen duen metodoa.
	 */
	public static void irekiLogin() {
		try {
			Login frame = new Login();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Erregistro bista irekitzen duen metodoa.
	 */
	public static void irekiErregistroa() {
		try {
			Erregistroa frame = new Erregistroa();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * BezeroMenu bista irekitzen duen metodoa.
	 */
	public static void irekiBezeroMenu() {
		try {
			BezeroMenu frame = new BezeroMenu();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
