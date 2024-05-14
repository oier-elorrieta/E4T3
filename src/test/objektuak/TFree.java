package test.objektuak;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.objektuak.bezero.Free;

public class TFree {
	private static Free f1;
	private static Free f2;
	private static Date eguna;

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		eguna = new Date(2024, 04, 18);
		f1 = new Free("unai", "souto", "euskera", "unaisouto", "1234", eguna, eguna);
		f2 = new Free(1, "unai", "souto", "euskera", "unaisouto", "1234", eguna, eguna);
	}
	// ********************** ID **********************

	@Test
	public void TestGetID() {
		assertEquals(1, f2.getId());
	}

	@Test
	public void TestSetID() {
		f2.setId(2);
		assertEquals(2, f2.getId());
	}

	@Test
	public void TestGetIDTxarto() {
		assertNotEquals(2, f2.getId());
	}

	@Test
	public void TestSetIDTxarto() {
		f2.setId(2);
		assertNotEquals(1, f2.getId());
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

	@Test
	public void TestGetIzenaTxarto() {
		assertNotEquals("unais", f1.getIzena());
	}

	@Test
	public void TestSetIzenaTxarto() {
		f1.setIzena("iker");
		assertNotEquals("unai", f1.getIzena());
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

	@Test
	public void TestGetAbizenaTxarto() {
		assertNotEquals("soutot", f1.getAbizena());
	}

	@Test
	public void TestSetAbizenaTxarto() {
		f1.setAbizena("torres");
		assertNotEquals("souto", f1.getAbizena());
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

	@Test
	public void TestGetHizkuntzaTxarto() {
		assertNotEquals("gaztelania", f1.getHizkuntza());
	}

	@Test
	public void TestSetHizkuntzaTxarto() {
		f1.setHizkuntza("gaztelania");
		assertNotEquals("euskera", f1.getHizkuntza());
	}

	// ********************** ERABILTZAILE IZENA **********************

	@Test
	public void TestGetErabIzena() {
		assertEquals("unaisouto", f1.getErabiltzaileIzena());
	}

	@Test
	public void TestSetErabIzena() {
		f1.setErabiltzaileIzena("ikersanchez");
		assertEquals("ikersanchez", f1.getErabiltzaileIzena());
	}

	@Test
	public void TestGetErabIzenaTxarto() {
		assertNotEquals("unais", f1.getErabiltzaileIzena());
	}

	@Test
	public void TestSetErabIzenaTxarto() {
		f1.setErabiltzaileIzena("ikersanchez");
		assertNotEquals("unaisouto", f1.getErabiltzaileIzena());
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

	@Test
	public void TestGetPasahitzaTxarto() {
		assertNotEquals("123", f1.getPasahitza());
	}

	@Test
	public void TestSetPasahitzaTxarto() {
		f1.setPasahitza("123");
		assertNotEquals("1234", f1.getPasahitza());
	}

	// ********************** JAIOTEGUNA **********************

	@Test
	public void TestGetJaioteguna() {
		assertEquals(eguna, f1.getJaioteguna());
	}

	@Test
	public void TestSetJaioteguna() {
		@SuppressWarnings("deprecation")
		Date eguna2 = new Date(2024, 04, 20);
		f1.setJaioteguna(eguna2);
		assertEquals(eguna2, f1.getJaioteguna());
	}

	@Test
	public void TestGetJaiotegunaTxarto() {
		@SuppressWarnings("deprecation")
		Date eguna2 = new Date(2024, 04, 20);
		assertNotEquals(eguna2, f1.getJaioteguna());
	}

	@Test
	public void TestSetJaiotegunaTxarto() {
		@SuppressWarnings("deprecation")
		Date eguna2 = new Date(2024, 04, 20);
		f1.setJaioteguna(eguna2);
		assertNotEquals(eguna, f1.getJaioteguna());
	}

	// ********************** ERREGISTRO EGUNA **********************

	@Test
	public void TestGetErreGuna() {
		assertEquals(eguna, f1.getErregistroEguna());
	}

	@Test
	public void TestSetErreGuna() {
		@SuppressWarnings("deprecation")
		Date eguna2 = new Date(2024, 04, 20);
		f1.setErregistroEguna(eguna2);
		assertEquals(eguna2, f1.getErregistroEguna());
	}

	@Test
	public void TestGetErreGunaTxarto() {
		@SuppressWarnings("deprecation")
		Date eguna2 = new Date(2024, 04, 20);
		assertNotEquals(eguna2, f1.getErregistroEguna());
	}

	@Test
	public void TestSetErreGunaTxarto() {
		@SuppressWarnings("deprecation")
		Date eguna2 = new Date(2024, 04, 20);
		f1.setErregistroEguna(eguna2);
		assertNotEquals(eguna, f1.getErregistroEguna());
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
	public void TestEqualsObjetuBerdina() {
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

}
