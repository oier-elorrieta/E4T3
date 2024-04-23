package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.objektuak.Abestia;
import model.objektuak.Album;
import model.objektuak.Musikaria;
import model.objektuak.PlayList;

public class TAlbum {

	private static Album al1;
	private static Date data;
	private static Date data2;
	private static Musikaria m1;
	private static Musikaria m2;
	private static ArrayList<Abestia> abestiak;

	@Before
	public void setUp() throws Exception {
		data = new Date(2024 / 04 / 23);
		data2 = new Date(2024 / 05 / 19);
		abestiak = new ArrayList<Abestia>();
		m1 = new Musikaria("1", "unai", "irudia", "deskribapena", "ezaugarria");
		m2 = new Musikaria("2", "unai", "irudia", "deskribapena", "ezaugarria");
		al1 = new Album("1", "izenburua", data, "generoa", "irudia", m1, abestiak);
	}

	// ********************** ID **********************

	@Test
	public void TestGetId() {
		assertEquals("1", al1.getId());
	}

	@Test
	public void TestSetId() {
		al1.setId("2");
		assertEquals("2", al1.getId());
	}

	@Test
	public void TestGetIdTxarto() {
		assertNotEquals("2", al1.getId());
	}

	@Test
	public void TestSetIdTxarto() {
		al1.setId("2");
		assertNotEquals("1", al1.getId());
	}

	// ********************** IZENBURUA **********************

	@Test
	public void TestGetIzenBuru() {
		assertEquals("izenburua", al1.getIzenburua());
	}

	@Test
	public void TestSetIzenBuru() {
		al1.setIzenburua("izenburu");
		assertEquals("izenburu", al1.getIzenburua());
	}

	@Test
	public void TestGetIzenBuruTxarto() {
		assertNotEquals("izenburu", al1.getIzenburua());
	}

	@Test
	public void TestSetIzenBuruTxarto() {
		al1.setIzenburua("izenburu");
		assertNotEquals("izenburua", al1.getIzenburua());
	}

	// ********************** DATA **********************

	@Test
	public void TestGetUrtea() {
		assertEquals(data, al1.getUrtea());
	}

	@Test
	public void TestSetUrtea() {
		al1.setUrtea(data2);
		assertEquals(data2, al1.getUrtea());
	}

	@Test
	public void TestGetUrteaTxarto() {
		assertNotEquals(data2, al1.getUrtea());
	}

	@Test
	public void TestSetUrteaTxarto() {
		al1.setUrtea(data2);
		assertNotEquals(data, al1.getUrtea());
	}

	// ********************** GENEROA **********************

	@Test
	public void TestGetGeneroa() {
		assertEquals("generoa", al1.getGeneroa());
	}

	@Test
	public void TestSetGeneroa() {
		al1.setGeneroa("genero");
		assertEquals("genero", al1.getGeneroa());
	}

	@Test
	public void TestGetGeneroaTxarto() {
		assertNotEquals("genero", al1.getGeneroa());
	}

	@Test
	public void TestSetGeneroaTxarto() {
		al1.setGeneroa("genero");
		assertNotEquals("generoa", al1.getGeneroa());
	}

	// ********************** IRUDIA **********************

	@Test
	public void TestGetIrudia() {
		assertEquals("irudia", al1.getIrudia());
	}

	@Test
	public void TestSetIrudia() {
		al1.setIrudia("irudi");
		assertEquals("irudi", al1.getIrudia());
	}

	@Test
	public void TestGetIrudiaTxarto() {
		assertNotEquals("irudi", al1.getIrudia());
	}

	@Test
	public void TestSetIrudiaTxarto() {
		al1.setIrudia("irudi");
		assertNotEquals("irudia", al1.getIrudia());
	}

	// ********************** MUSIKARIA **********************

	@Test
	public void TestGetMusikaria() {
		assertEquals(m1, al1.getMusikaria());
	}

	@Test
	public void TestSetMusikaria() {
		al1.setMusikaria(m2);
		assertEquals(m2, al1.getMusikaria());
	}

	@Test
	public void TestGetMusikariaTxarto() {
		assertNotEquals(m2, al1.getMusikaria());
	}

	@Test
	public void TestSetMusikariaTxarto() {
		al1.setMusikaria(m2);
		assertNotEquals(m1, al1.getMusikaria());
	}

	// ********************** ABESTIAK **********************

	@Test
	public void TestGetAbestiak() {
		assertEquals(abestiak, al1.getAbestiak());
	}

	@Test
	public void TestSetAbestiak() {
		ArrayList<Abestia> abestiak2 = new ArrayList<Abestia>();
		al1.setAbestiak(abestiak2);
		assertEquals(abestiak2, al1.getAbestiak());
	}

	@Test
	public void TestGetAbestiakTxarto() {
		ArrayList<Abestia> abestiak2 = new ArrayList<Abestia>();
		abestiak.add(null);
		assertNotEquals(abestiak2, al1.getAbestiak());
	}

	@Test
	public void TestSetAbestiakTxarto() {
		ArrayList<Abestia> abestiak2 = new ArrayList<Abestia>();
		abestiak.add(null);
		al1.setAbestiak(abestiak2);
		assertNotEquals(abestiak, al1.getAbestiak());
	}

	// ********************** TO STRING **********************

	@Test
	public void TestToString() {
		String txt = al1.toString();

		String esperotakoa = "Album [id=" + al1.getId() + ", izenburua=" + al1.getIzenburua() + ", urtea="
				+ al1.getUrtea() + ", generoa=" + al1.getGeneroa() + ", irudia=" + al1.getIrudia() + ", musikaria="
				+ al1.getMusikaria() + ", abestiak=" + al1.getAbestiak() + "]";

		assertEquals(txt, esperotakoa);
	}

	// ********************** EQUALS **********************

	@Test
	public void TestEqualsObjetuBerdina() {
		assertTrue(al1.equals(al1));
	}

	@Test
	public void TestEqualsNull() {
		assertFalse(al1.equals(null));
	}

	@Test
	public void TestEqualsClaseEzberdinak() {
		String txarra = "";
		assertFalse(al1.equals(txarra));
	}

	@Test
	public void TestEqualsClaseAtrBerdinak() {
		Album al2 = new Album("1", "izenburua", data, "generoa", "irudia", m1, abestiak);
		assertTrue(al1.equals(al2));
	}
}
