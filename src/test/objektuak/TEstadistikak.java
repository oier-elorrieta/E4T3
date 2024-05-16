package test.objektuak;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.objektuak.Estadistikak;

public class TEstadistikak {

	private Estadistikak e1;
	private Estadistikak e2;

	@Before
	public void setUp() throws Exception {
		e1 = new Estadistikak("1", "izena", 1, 2, 3);
		e2 = new Estadistikak("1", "izena", 1, 2, 3);
	}

	// ********************** ID AUDIO **********************

	@Test
	public void TestGetID() {
		assertEquals("1", e1.getID_Audio());
	}

	@Test
	public void TestSetID() {
		e1.setID_Audio("2");
		assertEquals("2", e1.getID_Audio());
	}

	@Test
	public void TestGetIDTxarto() {
		assertNotEquals("2", e1.getID_Audio());
	}

	@Test
	public void TestSetIDTxarto() {
		e1.setID_Audio("2");
		assertNotEquals("1", e1.getID_Audio());
	}

	// ********************** IZENA **********************

	@Test
	public void TestGetIzena() {
		assertEquals("izena", e1.getIzena());
	}

	@Test
	public void TestSetIzena() {
		e1.setIzena("izen");
		assertEquals("izen", e1.getIzena());
	}

	@Test
	public void TestGetIzenaTxarto() {
		assertNotEquals("izen", e1.getIzena());
	}

	@Test
	public void TestSetIzenaTxarto() {
		e1.setIzena("izen");
		assertNotEquals("izena", e1.getIzena());
	}

	// ********************** ERREPRO EGUNA **********************

	@Test
	public void TestGetErreproEguna() {
		assertEquals(1, e1.getErreprodukzioKopEguna());
	}

	@Test
	public void TestSetErreproEguna() {
		e1.setErreprodukzioKopEguna(2);
		assertEquals(2, e1.getErreprodukzioKopEguna());
	}

	@Test
	public void TestGetErreproEgunaTxarto() {
		assertNotEquals(2, e1.getErreprodukzioKopEguna());
	}

	@Test
	public void TestSetErreproEgunaTxarto() {
		e1.setErreprodukzioKopEguna(3);
		assertNotEquals(2, e1.getErreprodukzioKopEguna());
	}

	// ********************** ERREPRO HILABETE **********************

	@Test
	public void TestGetErreproHilabete() {
		assertEquals(2, e1.getErreprodukzioKopHilabetea());
	}

	@Test
	public void TestSetErreproHilabete() {
		e1.setErreprodukzioKopHilabetea(3);
		assertEquals(3, e1.getErreprodukzioKopHilabetea());
	}

	@Test
	public void TestGetErreproHilabeteTxarto() {
		assertNotEquals(3, e1.getErreprodukzioKopHilabetea());
	}

	@Test
	public void TestSetErreproHilabeteTxarto() {
		e1.setErreprodukzioKopHilabetea(3);
		assertNotEquals(2, e1.getErreprodukzioKopHilabetea());
	}

	// ********************** ERREPRO URTERO **********************

	@Test
	public void TestGetErreproUrtero() {
		assertEquals(3, e1.getErreprodukzioKopUrtea());
	}

	@Test
	public void TestSetErreproUrtero() {
		e1.setErreprodukzioKopUrtea(2);
		assertEquals(2, e1.getErreprodukzioKopUrtea());
	}

	@Test
	public void TestGetErreproUrteroTxarto() {
		assertNotEquals(2, e1.getErreprodukzioKopUrtea());
	}

	@Test
	public void TestSetErreproUrteroTxarto() {
		e1.setErreprodukzioKopUrtea(2);
		assertNotEquals(3, e1.getErreprodukzioKopUrtea());
	}

	// ********************** TO STRING **********************

	@Test
	public void TestToString() {
		String txt = e1.toString();

		String esperotakoa = "Estadistikak [ID_Audio=" + e1.getID_Audio() + ", izena=" + e1.getIzena() + ", erreprodukzioKopEguna="
				+ e1.getErreprodukzioKopEguna() + ", erreprodukzioKopHilabetea=" + e1.getErreprodukzioKopHilabetea()
				+ ", erreprodukzioKopUrtea=" + e1.getErreprodukzioKopUrtea() + "]";

		assertEquals(txt, esperotakoa);
	}
	
	// ********************** EQUALS **********************

	@Test
	public void TestEqualsObjetuBerdina() {
		assertTrue(e1.equals(e1));
	}

	@Test
	public void TestEqualsNull() {
		assertFalse(e1.equals(null));
	}

	@Test
	public void TestEqualsClaseEzberdinak() {
		String txarra = "";
		assertFalse(e1.equals(txarra));
	}
	
	@Test
	public void TestEqualsBerdinak() {
		assertEquals(e1, e2);
	}

}
