package test.objektuak;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.objektuak.bezero.Premium;

@SuppressWarnings("deprecation")
public class TPremium {
	private static Premium p1;
	@SuppressWarnings("unused")
	private static Premium p2;
	private static Date eguna;

	@Before
	public void setUp() throws Exception {
		eguna = new Date(2024, 04, 18);
		p1 = new model.objektuak.bezero.Premium("unai", "souto", "euskera", "unaisouto", "1234", eguna, eguna, eguna);
		p2 = new model.objektuak.bezero.Premium(1, "unai", "souto", "euskera", "unaisouto", "1234", eguna, eguna, eguna);
	}

	// ********************** IRAUNGITZE DATA **********************

	@Test
	public void TestGetErreGuna() {
		assertEquals(eguna, p1.getIraungitzeData());
	}

	@Test
	public void TestSetErreGuna() {
		Date eguna2 = new Date(2024, 04, 20);
		p1.setIraungitzeData(eguna2);
		assertEquals(eguna2, p1.getIraungitzeData());
	}

	@Test
	public void TestGetErreGunaTxarto() {
		Date eguna2 = new Date(2024, 04, 20);
		assertNotEquals(eguna2, p1.getIraungitzeData());
	}

	@Test
	public void TestSetErreGunaTxarto() {
		Date eguna2 = new Date(2024, 04, 20);
		p1.setIraungitzeData(eguna2);
		assertNotEquals(eguna, p1.getIraungitzeData());
	}

	// ********************** TO STRING **********************

	@Test
	public void TestToString() {
		String txt = p1.toString();

		String esperotakoa = "Bezero [izena=" + p1.getIzena() + ", abizena=" + p1.getAbizena() + ", hizkuntza="
				+ p1.getHizkuntza() + ", erabiltzaileIzena=" + p1.getErabiltzaileIzena() + ", pasahitza="
				+ p1.getPasahitza() + ", jaioteguna=" + p1.getJaioteguna() + ", erregistroEguna="
				+ p1.getErregistroEguna() + "]" + " Premium [iraungitzeData=" + p1.getIraungitzeData() + "]";

		assertEquals(txt, esperotakoa);
	}

	// ********************** EQUALS **********************

	@Test
	public void TestEqualsObjetuBerdina() {
		assertTrue(p1.equals(p1));
	}

	@Test
	public void TestEqualsNull() {
		assertFalse(p1.equals(null));
	}

	@Test
	public void TestEqualsClaseEzberdinak() {
		String txarra = "";
		assertFalse(p1.equals(txarra));
	}

	// ********************** FUNTZIOAK **********************
	
	@Test
    public void testPremiumErosi() {
		eguna = p1.premiumErosi();

		// Assertatu urtea +1 egin duela
        assertEquals(2025, eguna.getYear()); 
    }
}
