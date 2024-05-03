package model;

import java.awt.image.BufferedImage;

import model.objektuak.bezero.Bezero;

// Klase hau erabiltzen da aldagai globalak gordetzeko
public class Aldagaiak {

	// Pantailaren neurri ardatzean.
	public static int resolucionX = 1000;
	public static int resolucionY = 650;

	// Bistararen hasiera koordenatua.
	public static int cordX = 100;
	public static int cordY = 100;

	// Pantailaren atzekaldeko irudia.
	public static BufferedImage imagenFondo;

	// Erabiltzailea.
	public static Bezero erabiltzailea;

	//Logoa
	public final static String logo = "/model/img/Logo.PNG";
	
	public static boolean skipSong = true;
	
}
