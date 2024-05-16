package test.objektuak;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.objektuak.Estadistikak;

public class TEstadistikak {

	private Estadistikak e1;

	@Before
	public void setUp() throws Exception {
		e1 = new Estadistikak("1", "izena", 1, 2, 3);
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
	
	

}
