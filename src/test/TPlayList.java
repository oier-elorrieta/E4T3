package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.objektuak.*;
import model.objektuak.bezero.Free;

public class TPlayList {

	private static PlayList pl1;
	private static Free f1;
	private static Date eguna;

	@Before
	public void setUp() throws Exception {
		eguna = new Date(2024, 04, 19);
		f1 = new Free("unai", "souto", "euskera", "unaisouto", "1234", eguna, eguna);
		pl1 = new PlayList(1, "Rock lista", eguna, f1);
	}

	// ********************** ID **********************

	@Test
	public void TestGetId() {
		assertEquals(1, pl1.getId());
	}

	@Test
	public void TestSetId() {
		pl1.setId(2);
		assertEquals(2, pl1.getId());
	}

	@Test
	public void TestGetIdTxarto() {
		assertNotEquals(2, pl1.getId());
	}

	@Test
	public void TestSetIdTxarto() {
		pl1.setId(2);
		assertNotEquals(1, pl1.getId());
	}

	// ********************** IZENA **********************

	@Test
	public void TestGetIzena() {
		assertEquals("Rock lista", pl1.getIzena());
	}

	@Test
	public void TestSetIzena() {
		pl1.setIzena("Rap lista");
		assertEquals("Rap lista", pl1.getIzena());
	}

	@Test
	public void TestGetIzenaTxarto() {
		assertNotEquals("Rock list", pl1.getIzena());
	}

	@Test
	public void TestSetIzenaTxarto() {
		pl1.setIzena("Rap lista");
		assertNotEquals("Rap list", pl1.getIzena());
	}

	// ********************** SORRERA DATA **********************

	@Test
	public void TestGetSorreraData() {
		assertEquals(eguna, pl1.getSorreraData());
	}

	@Test
	public void TestSetSorreraData() {
		Date eguna2 = new Date(2024, 05, 19);
		pl1.setSorreraData(eguna2);
		assertEquals(eguna2, pl1.getSorreraData());
	}

	@Test
	public void TestGetSorreraDataTxarto() {
		Date eguna2 = new Date(2024, 05, 19);
		assertNotEquals(eguna2, pl1.getSorreraData());
	}

	@Test
	public void TestSetSorreraDataTxarto() {
		Date eguna2 = new Date(2024, 05, 19);
		pl1.setSorreraData(eguna2);
		assertNotEquals(eguna, pl1.getSorreraData());
	}

	// ********************** BEZEROA **********************

	@Test
	public void TestGetBezeroa() {
		assertEquals(f1, pl1.getBezeroa());
	}

	@Test
	public void TestSetBezeroa() {
		Free f2 = new Free("iker", "sanchez", "euskera", "ikersahe", "1234", null, null);
		pl1.setBezeroa(f2);
		assertEquals(f2, pl1.getBezeroa());
	}

	@Test
	public void TestGetBezeroaTxarto() {
		Free f2 = new Free("iker", "sanchez", "euskera", "ikersahe", "1234", null, null);
		assertNotEquals(f2, pl1.getBezeroa());
	}

	@Test
	public void TestSetBezeroaTxarto() {
		Free f2 = new Free("iker", "sanchez", "euskera", "ikersahe", "1234", null, null);
		pl1.setBezeroa(f2);
		assertNotEquals(f1, pl1.getBezeroa());
	}

	// ********************** TO STRING **********************

	@Test
	public void TestToString() {
		String txt = pl1.toString();

		String esperotakoa = "PlayList [id=" + pl1.getId() + ", izena=" + pl1.getIzena() + ", sorreraData="
				+ pl1.getSorreraData() + ", bezeroa=" + pl1.getBezeroa() + "]";

		assertEquals(txt, esperotakoa);
	}

	// ********************** EQUALS **********************

	@Test
	public void TestEqualsObjetuBerdina() {
		assertTrue(pl1.equals(pl1));
	}

	@Test
	public void TestEqualsNull() {
		assertFalse(pl1.equals(null));
	}

	@Test
	public void TestEqualsClaseEzberdinak() {
		String txarra = "";
		assertFalse(pl1.equals(txarra));
	}

	@Test
	public void TestEqualsClaseAtrBerdinak() {
		PlayList pl2 = new PlayList(1, "Rock lista", eguna, f1);
		assertTrue(pl1.equals(pl2));
	}
}
