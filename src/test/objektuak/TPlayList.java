package test.objektuak;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.objektuak.*;
import model.objektuak.bezero.Free;

public class TPlayList {

	private static PlayList pl2;
	private static PlayList pl3;
	private static PlayList pl4;
	private static PlayList pl5;
	private static Free f1;
	private static Date eguna;
	private static ArrayList<Audio> abestiak;

	@Before
	public void setUp() throws Exception {
		eguna = new Date(2024, 04, 19);
		abestiak = new ArrayList<Audio>();
		f1 = new Free("unai", "souto", "euskera", "unaisouto", "1234", eguna, eguna);
		pl2 = new PlayList("1", "Rock lista", eguna, f1);
		pl3 = new PlayList("1", "Rock lista", 3);
		pl4 = new PlayList("1", "Rock lista");
		pl5 = new PlayList();
	}

	// ********************** ID **********************

	@Test
	public void TestGetId() {
		assertEquals("1", pl2.getId());
	}

	@Test
	public void TestSetId() {
		pl2.setId("2");
		assertEquals("2", pl2.getId());
	}

	@Test
	public void TestGetIdTxarto() {
		assertNotEquals("2", pl2.getId());
	}

	@Test
	public void TestSetIdTxarto() {
		pl2.setId("2");
		assertNotEquals("1", pl2.getId());
	}

	// ********************** IZENA **********************

	@Test
	public void TestGetIzena() {
		assertEquals("Rock lista", pl2.getIzena());
	}

	@Test
	public void TestSetIzena() {
		pl2.setIzena("Rap lista");
		assertEquals("Rap lista", pl2.getIzena());
	}

	@Test
	public void TestGetIzenaTxarto() {
		assertNotEquals("Rock list", pl2.getIzena());
	}

	@Test
	public void TestSetIzenaTxarto() {
		pl2.setIzena("Rap lista");
		assertNotEquals("Rap list", pl2.getIzena());
	}

	// ********************** SORRERA DATA **********************

	@Test
	public void TestGetSorreraData() {
		assertEquals(eguna, pl2.getSorreraData());
	}

	@Test
	public void TestSetSorreraData() {
		Date eguna2 = new Date(2024, 05, 19);
		pl2.setSorreraData(eguna2);
		assertEquals(eguna2, pl2.getSorreraData());
	}

	@Test
	public void TestGetSorreraDataTxarto() {
		Date eguna2 = new Date(2024, 05, 19);
		assertNotEquals(eguna2, pl2.getSorreraData());
	}

	@Test
	public void TestSetSorreraDataTxarto() {
		Date eguna2 = new Date(2024, 05, 19);
		pl2.setSorreraData(eguna2);
		assertNotEquals(eguna, pl2.getSorreraData());
	}

	// ********************** BEZEROA **********************

	@Test
	public void TestGetBezeroa() {
		assertEquals(f1, pl2.getBezeroa());
	}

	@Test
	public void TestSetBezeroa() {
		Free f2 = new Free("iker", "sanchez", "euskera", "ikersahe", "1234", null, null);
		pl2.setBezeroa(f2);
		assertEquals(f2, pl2.getBezeroa());
	}

	@Test
	public void TestGetBezeroaTxarto() {
		Free f2 = new Free("iker", "sanchez", "euskera", "ikersahe", "1234", null, null);
		assertNotEquals(f2, pl2.getBezeroa());
	}

	@Test
	public void TestSetBezeroaTxarto() {
		Free f2 = new Free("iker", "sanchez", "euskera", "ikersahe", "1234", null, null);
		pl2.setBezeroa(f2);
		assertNotEquals(f1, pl2.getBezeroa());
	}

	// ********************** ABESTIAK **********************


	@Test
	public void TestSetAbestiak() {
		ArrayList<Audio> abestiak2 = new ArrayList<Audio>();
		pl2.setAbestiak(abestiak2);
		assertEquals(abestiak2, pl2.getAbestiak());
	}

	@Test
	public void TestGetAbestiakTxarto() {
		ArrayList<Abestia> abestiak2 = new ArrayList<Abestia>();
		abestiak.add(null);
		assertNotEquals(abestiak2, pl2.getAbestiak());
	}

	@Test
	public void TestSetAbestiakTxarto() {
		ArrayList<Audio> abestiak2 = new ArrayList<Audio>();
		abestiak.add(null);
		pl2.setAbestiak(abestiak2);
		assertNotEquals(abestiak, pl2.getAbestiak());
	}
	
	// ********************** ABESTI KONT **********************

	@Test
	public void TestGetAbestiKont() {
		assertEquals(3, pl3.getAbestiKont());
	}

	@Test
	public void TestSetAbestiKont() {
		pl3.setAbestiKont(2);
		assertEquals(2, pl3.getAbestiKont());
	}
	
	@Test
	public void TestGetAbestiKontTxarto() {
		assertNotEquals(4, pl3.getAbestiKont());
	}

	@Test
	public void TestSetAbestiKontTxarto() {
		pl3.setAbestiKont(2);
		assertNotEquals(3, pl3.getAbestiKont());
	}
	
	@Test
	public void TestAbestiKontGehi() {
		pl3.gehituAbestiKont();
		assertEquals(4, pl3.getAbestiKont());
	}

	@Test
	public void TestAbestiKontKen() {
		pl3.kenduAbestiKont();
		assertEquals(2, pl3.getAbestiKont());
	}

	// ********************** TO STRING **********************

	@Test
	public void TestToString() {
		String txt = pl2.toString();

		String esperotakoa = "PlayList [id=" + pl2.getId() + ", izena=" + pl2.getIzena() + ", sorreraData="
				+ pl2.getSorreraData() + ", bezeroa=" + pl2.getBezeroa() + ", abestiak=" + "null" + "]";

		assertEquals(txt, esperotakoa);
	}

	// ********************** EQUALS **********************

	@Test
	public void TestEqualsObjetuBerdina() {
		assertTrue(pl2.equals(pl2));
	}

	@Test
	public void TestEqualsNull() {
		assertFalse(pl2.equals(null));
	}

	@Test
	public void TestEqualsClaseEzberdinak() {
		String txarra = "";
		assertFalse(pl2.equals(txarra));
	}
}
