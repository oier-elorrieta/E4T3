package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.objektuak.Abestia;
import model.objektuak.bezero.Free;

public class TAbestia {

	private Abestia a1;

	@Before
	public void setUp() throws Exception {
		a1 = new Abestia("1", "izena", 120, "irudia");
	}

	// ********************** ID **********************

	@Test
	public void TestGetId() {
		assertEquals("1", a1.getIdAudio());
	}

	@Test
	public void TestSetId() {
		a1.setIdAudio("2");
		assertEquals("2", a1.getIdAudio());
	}

	@Test
	public void TestGetIdTxarto() {
		assertNotEquals("2", a1.getIdAudio());
	}

	@Test
	public void TestSetIdTxarto() {
		a1.setIdAudio("2");
		assertNotEquals("1", a1.getIdAudio());
	}

	// ********************** IZENA **********************

	@Test
	public void TestGetIzenArts() {
		assertEquals("izena", a1.getIzena());
	}

	@Test
	public void TestSetIzenArts() {
		a1.setIzena("izenaa");
		assertEquals("izenaa", a1.getIzena());
	}

	@Test
	public void TestGetIzenArtsTxarto() {
		assertNotEquals("izenaa", a1.getIzena());
	}

	@Test
	public void TestSetIzenArtsTxarto() {
		a1.setIzena("izenaa");
		assertNotEquals("izena", a1.getIzena());
	}

	// ********************** IRAUPENA **********************

	@Test
	public void TestGetIraupena() {
		assertEquals(120, a1.getIraupena());
	}

	@Test
	public void TestSetIraupena() {
		a1.setIraupena(121);
		assertEquals(121, a1.getIraupena());
	}

	@Test
	public void TestGetIraupenaTxarto() {
		assertNotEquals(121, a1.getIraupena());
	}

	@Test
	public void TestSetIraupenaTxarto() {
		a1.setIraupena(121);
		assertNotEquals(120, a1.getIraupena());
	}

	// ********************** IRUDIA **********************

	@Test
	public void TestGetIrudia() {
		assertEquals("irudia", a1.getIrudia());
	}

	@Test
	public void TestSetIrudia() {
		a1.setIrudia("irudi");
		assertEquals("irudi", a1.getIrudia());
	}

	@Test
	public void TestGetIrudiaTxarto() {
		assertNotEquals("irudi", a1.getIrudia());
	}

	@Test
	public void TestSetIrudiaTxarto() {
		a1.setIrudia("irudi");
		assertNotEquals("irudia", a1.getIrudia());
	}

	// ********************** TO STRING **********************

	@Test
	public void TestToString() {
		String txt = a1.toString();

		String esperotakoa = "Audio [idAudio=" + a1.getIdAudio() + ", izena=" + a1.getIzena() + ", iraupena="
				+ a1.getIraupena() + ", irudia=" + a1.getIrudia() + "]";

		assertEquals(txt, esperotakoa);
	}

	// ********************** EQUALS **********************

	@Test
	public void TestEqualsObjetuBerdina() {
		assertTrue(a1.equals(a1));
	}

	@Test
	public void TestEqualsNull() {
		assertFalse(a1.equals(null));
	}

	@Test
	public void TestEqualsClaseEzberdinak() {
		String txarra = "";
		assertFalse(a1.equals(txarra));
	}

	@Test
	public void TestEqualsClaseAtrBerdinak() {
		Abestia a2 = new Abestia("1", "izena", 120, "irudia");
		assertTrue(a1.equals(a2));
	}

}
