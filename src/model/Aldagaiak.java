package model;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import model.objektuak.Bezero;

// Klase hau erabiltzen da aldagai globalak gordetzeko
public class Aldagaiak {

	// Sistema erabiltzeko Toolkit objektua.
	public static Toolkit tk = Toolkit.getDefaultToolkit();

	// Pantailaren neurri X ardatzean.
	public static int resolucionX = 1000;

	// Pantailaren neurri Y ardatzean.
	public static int resolucionY = 650;

	// Bistararen hasiera X koordenatua.
	public static int cordX = 100;

	// Bistararen hasiera Y koordenatua.
	public static int cordY = 100;

	// Pantailaren atzekaldeko irudia.
	public static BufferedImage imagenFondo;

	// Erabiltzailea.
	public static Bezero erabiltzailea;

}
