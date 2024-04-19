package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;


public class TPremium {
	private static model.objektuak.Premium p1;

	@Before
	public void setUp() throws Exception {
		Date eguna = new Date(2024, 04, 18);
		p1 = new model.objektuak.Premium("unai", "souto", "euskera", "unaisouto", "1234", eguna, eguna, eguna);
	}

	// ********************** IRAUNGITZE DATA **********************

	@Test
	public void TestGetErreGuna() {
		Date eguna = new Date(2024, 04, 18);
		assertEquals(eguna, p1.getIraungitzeData());
	}

	@Test
	public void TestSetErreGuna() {
		Date eguna = new Date(2024, 04, 18);
		Date eguna2 = new Date(2024, 04, 20);
		p1.setIraungitzeData(eguna2);
		assertEquals(eguna2, p1.getIraungitzeData());
	}

	// ********************** TO STRING **********************

	@Test
	public void TestToString() {
		String txt = p1.toString();

		String esperotakoa = "Premium [izena=" + p1.getIzena() + ", abizena=" + p1.getAbizena() + ", hizkuntza="
				+ p1.getHizkuntza() + ", erabiltzaileIzena=" + p1.getErabiltzaileIzena() + ", pasahitza="
				+ p1.getPasahitza() + ", jaioteguna=" + p1.getJaioteguna() + ", erregistroEguna="
				+ p1.getErregistroEguna() + "iraungitzeData=" + p1.getIraungitzeData() + "]";
	}

	// ********************** EQUALS **********************

	@Test
	public void TestEqualsDira() {
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

	@Test
	public void TestEqualsClaseBerdinak() {
		Date eguna = new Date(2024, 04, 18);
		model.objektuak.Premium p2 = new model.objektuak.Premium("unai", "souto", "euskera", "unaisouto", "1234", eguna, eguna, eguna);
		assertTrue(p1.equals(p2));
	}

}
