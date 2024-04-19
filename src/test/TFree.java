package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.objektuak.*;

public class TFree {
	private static Free f1;
	private static Date eguna;

	@Before
	public void setUp() throws Exception {
		eguna = new Date(2024, 04, 18);
		f1 = new Free("unai", "souto", "euskera", "unaisouto", "1234", eguna, eguna);
	}

	// ********************** IZENA **********************

	@Test
	public void TestGetIzena() {
		assertEquals("unai", f1.getIzena());
	}

	@Test
	public void TestSetIzena() {
		f1.setIzena("iker");
		assertEquals("iker", f1.getIzena());
	}

	// ********************** ABIZENA **********************

	@Test
	public void TestGetAbizena() {
		assertEquals("souto", f1.getAbizena());
	}

	@Test
	public void TestSetAbizena() {
		f1.setAbizena("torres");
		assertEquals("torres", f1.getAbizena());
	}

	// ********************** HIZKUNTZA **********************

	@Test
	public void TestGetHizkuntza() {
		assertEquals("euskera", f1.getHizkuntza());
	}

	@Test
	public void TestSetHizkuntza() {
		f1.setHizkuntza("gaztelania");
		assertEquals("gaztelania", f1.getHizkuntza());
	}

	// ********************** ERABILTZAILE IZENA **********************

	@Test
	public void TestGetErabIzena() {
		assertEquals("unai", f1.getIzena());
	}

	@Test
	public void TestSetErabIzena() {
		f1.setErabiltzaileIzena("ikersanchez");
		assertEquals("ikersanchez", f1.getErabiltzaileIzena());
	}

	// ********************** PASAHITZA **********************

	@Test
	public void TestGetPasahitza() {
		assertEquals("1234", f1.getPasahitza());
	}

	@Test
	public void TestSetPasahitza() {
		f1.setPasahitza("123");
		assertEquals("123", f1.getPasahitza());
	}

	// ********************** JAIOTEGUNA **********************

	@Test
	public void TestGetJaioteguna() {
		Date eguna = new Date(2024, 04, 18);
		assertEquals(eguna, f1.getJaioteguna());
	}

	@Test
	public void TestSetJaioteguna() {
		Date eguna = new Date(2024, 04, 18);
		Date eguna2 = new Date(2024, 04, 20);
		f1.setJaioteguna(eguna2);
		assertEquals(eguna2, f1.getJaioteguna());
	}

	// ********************** ERREGISTRO EGUNA **********************

	@Test
	public void TestGetErreGuna() {
		Date eguna = new Date(2024, 04, 18);
		assertEquals(eguna, f1.getErregistroEguna());
	}

	@Test
	public void TestSetErreGuna() {
		Date eguna = new Date(2024, 04, 18);
		Date eguna2 = new Date(2024, 04, 20);
		f1.setErregistroEguna(eguna2);
		assertEquals(eguna2, f1.getErregistroEguna());
	}

	// ********************** TO STRING **********************

	@Test
	public void TestToString() {
		String txt = f1.toString();

		String esperotakoa = "Bezero [izena=" + f1.getIzena() + ", abizena=" + f1.getAbizena() + ", hizkuntza="
				+ f1.getHizkuntza() + ", erabiltzaileIzena=" + f1.getErabiltzaileIzena() + ", pasahitza="
				+ f1.getPasahitza() + ", jaioteguna=" + f1.getJaioteguna() + ", erregistroEguna="
				+ f1.getErregistroEguna() + "]";

		assertEquals(txt, esperotakoa);
	}

	// ********************** EQUALS **********************

	@Test
	public void TestEqualsDira() {
		assertTrue(f1.equals(f1));
	}

	@Test
	public void TestEqualsNull() {
		assertFalse(f1.equals(null));
	}

	@Test
	public void TestEqualsClaseEzberdinak() {
		String txarra = "";
		assertFalse(f1.equals(txarra));
	}

	@Test
	public void TestEqualsClaseBerdinak() {
		Free f2 = new Free("unai", "souto", "euskera", "unaisouto", "1234", eguna,
				eguna);
		assertTrue(f1.equals(f2));
	}

}
