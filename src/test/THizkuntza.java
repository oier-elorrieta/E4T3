package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.objektuak.Hizkuntza;

public class THizkuntza {

	Hizkuntza h;

	@Before
	public void setUp() throws Exception {
		h = new Hizkuntza("1", "deskribapena");
	}

	// ********************** ID **********************

	@Test
	public void TestGetId() {
		assertEquals("1", h.getID_Hizkuntza());
	}

	@Test
	public void TestSetId() {
		h.setID_Hizkuntza("2");
		assertEquals("2", h.getID_Hizkuntza());
	}

	@Test
	public void TestGetIdTxarto() {
		assertNotEquals("2", h.getID_Hizkuntza());
	}

	@Test
	public void TestSetIdTxarto() {
		h.setID_Hizkuntza("2");
		assertNotEquals("1", h.getID_Hizkuntza());
	}

	// ********************** DESKRIBAPENA **********************

	@Test
	public void TestGetDesk() {
		assertEquals("deskribapena", h.getDeskribapena());
	}

	@Test
	public void TestSetDesk() {
		h.setDeskribapena("desk");
		assertEquals("desk", h.getDeskribapena());
	}

	@Test
	public void TestGetDeskTxarto() {
		assertNotEquals("desk", h.getDeskribapena());
	}

	@Test
	public void TestSetDeskTxarto() {
		h.setDeskribapena("desk");
		assertNotEquals("deskribapena", h.getDeskribapena());
	}

	// ********************** TO STRING **********************

	@Test
	public void TestToString() {
		String txt = h.toString();

		String esperotakoa = "Hizkuntza [ID_Hizkuntza=" + h.getID_Hizkuntza() + ", Deskribapena=" + h.getDeskribapena()
				+ "]";
		assertEquals(txt, esperotakoa);
	}

	// ********************** EQUALS **********************

	@Test
	public void TestEqualsObjetuBerdina() {
		assertTrue(h.equals(h));
	}

	@Test
	public void TestEqualsNull() {
		assertFalse(h.equals(null));
	}

	@Test
	public void TestEqualsClaseEzberdinak() {
		String txarra = "";
		assertFalse(h.equals(txarra));
	}

	@Test
	public void TestEqualsClaseAtrBerdinak() {
		Hizkuntza h2 = new Hizkuntza("1", "deskribapena");
		assertTrue(h.equals(h2));
	}

}
