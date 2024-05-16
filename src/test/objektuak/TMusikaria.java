package test.objektuak;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.objektuak.Musikaria;


public class TMusikaria {

	private static Musikaria m1;
	private static Musikaria m2;
	private static Musikaria m3;
	private static Musikaria m4;

	@Before
	public void setUp() throws Exception {
		m1 = new Musikaria("1", "unai", null, "deskribapena", "ezaugarria");
		m2 = new Musikaria("1", "izena", "deskribapena", "ezaugarria");
		m3 = new Musikaria("1", "izena");
		m4 = new Musikaria("izena",1000);
	}

	// ********************** EZAUGARRIA **********************

	@Test
	public void TestGetEzaugarria() {
		assertEquals("ezaugarria", m1.getEzaugarria());
	}

	@Test
	public void TestSetEzaugarria() {
		m1.setEzaugarria("ezaugarriak");
		assertEquals("ezaugarriak", m1.getEzaugarria());
	}

	@Test
	public void TestGetEzaugarriaTxarto() {
		assertNotEquals("ezaugarriak", m1.getEzaugarria());
	}

	@Test
	public void TestSetEzaugarriaTxarto() {
		m1.setEzaugarria("ezaugarriak");
		assertNotEquals("ezaugarria", m1.getEzaugarria());
	}

	// ********************** TO STRING **********************

	@Test
	public void TestToString() {
		String txt = m1.toString();

		String esperotakoa = "Artista [id=" + m1.getId() + ", izen_Artistikoa=" + m1.getIzen_Artistikoa()
				+ ", irudia=" + m1.getIrudia() + ", deskribapena=" + m1.getDeskribapena() + ", erreprodukzioak=" + m1.getErreprodukzioak() + "] Musikaria [ezaugarria="
				+ m1.getEzaugarria() + "]";

		assertEquals(txt, esperotakoa);
	}

	// ********************** EQUALS **********************

	@Test
	public void TestEqualsObjetuBerdina() {
		assertTrue(m1.equals(m1));
	}

	@Test
	public void TestEqualsNull() {
		assertFalse(m1.equals(null));
	}

	@Test
	public void TestEqualsClaseEzberdinak() {
		String txarra = "";
		assertFalse(m1.equals(txarra));
	}
}
 