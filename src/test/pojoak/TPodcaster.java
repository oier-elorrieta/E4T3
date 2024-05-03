package test.pojoak;

import static org.junit.Assert.*;

import java.sql.Blob;

import org.junit.Before;
import org.junit.Test;

import model.objektuak.Podcaster;


public class TPodcaster {

	private Podcaster pd1;
	private Podcaster pd2;
	private Blob blob;
	private Blob blob2;

	@Before
	public void setUp() throws Exception {
		byte[] blobData = "Datos de ejemplo".getBytes();
		byte[] blobData2 = "Datos de ejemplo2".getBytes();
		blob = new javax.sql.rowset.serial.SerialBlob(blobData);
		blob2 = new javax.sql.rowset.serial.SerialBlob(blobData2);
		pd1 = new Podcaster("1", "unai", blob, "deskribapena");
		pd2 = new Podcaster("unai", 200);
		
	}

	// ********************** ID **********************

	@Test
	public void TestGetIzena() {
		assertEquals("1", pd1.getId());
	}

	@Test
	public void TestSetIzena() {
		pd1.setId("2");
		assertEquals("2", pd1.getId());
	}

	@Test
	public void TestGetIdTxarto() {
		assertNotEquals("2", pd1.getId());
	}

	@Test
	public void TestSetIdTxarto() {
		pd1.setId("2");
		assertNotEquals("1", pd1.getId());
	}

	// ********************** IZEN ARTISTIKOA **********************

	@Test
	public void TestGetIzenArts() {
		assertEquals("unai", pd1.getIzen_Artistikoa());
	}

	@Test
	public void TestSetIzenArts() {
		pd1.setIzen_Artistikoa("unais");
		assertEquals("unais", pd1.getIzen_Artistikoa());
	}

	@Test
	public void TestGetIzenArtsTxarto() {
		assertNotEquals("unais", pd1.getIzen_Artistikoa());
	}

	@Test
	public void TestSetIzenArtsTxarto() {
		pd1.setIzen_Artistikoa("unais");
		assertNotEquals("unas", pd1.getIzen_Artistikoa());
	}

	// ********************** IRUDIA **********************

	@Test
	public void TestGetIrudia() {
		assertEquals(blob, pd1.getIrudia());
	}

	@Test
	public void TestSetIrudia() {
		pd1.setIrudia(blob2);
		assertEquals(blob2, pd1.getIrudia());
	}

	@Test
	public void TestGetIrudiaTxarto() {
		assertNotEquals(blob2, pd1.getIrudia());
	}

	@Test
	public void TestSetIrudiaTxarto() {
		pd1.setIrudia(blob2);
		assertNotEquals(blob, pd1.getIrudia());
	}

	// ********************** DESKRIBAPENA **********************

	@Test
	public void TestGetDesk() {
		assertEquals("deskribapena", pd1.getDeskribapena());
	}

	@Test
	public void TestSetDesk() {
		pd1.setDeskribapena("desk");
		assertEquals("desk", pd1.getDeskribapena());
	}

	@Test
	public void TestGetDeskTxarto() {
		assertNotEquals("desk", pd1.getDeskribapena());
	}

	@Test
	public void TestSetDeskTxarto() {
		pd1.setDeskribapena("desk");
		assertNotEquals("deskribapena", pd1.getDeskribapena());
	}
	
	// ********************** ERREPRODUKZIOAK **********************

	@Test
	public void TestGetErrep() {
		assertEquals(200, pd2.getErreprodukzioak());
	}

	@Test
	public void TestSetErrep() {
		pd2.setErreprodukzioak(300);
		assertEquals(300, pd2.getErreprodukzioak());
	}

	@Test
	public void TestGetErrepTxarto() {
		assertNotEquals(300, pd2.getErreprodukzioak());
	}

	@Test
	public void TestSetErrepTxarto() {
		pd2.setErreprodukzioak(300);
		assertNotEquals(200, pd2.getErreprodukzioak());
	}

	// ********************** TO STRING **********************

	@Test
	public void TestToString() {
		String txt = pd1.toString();

		String esperotakoa = "Artista [id=" + pd1.getId() + ", izen_Artistikoa=" + pd1.getIzen_Artistikoa()
				+ ", irudia=" + pd1.getIrudia() + ", deskribapena=" + pd1.getDeskribapena() + ", erreprodukzioak=" + pd1.getErreprodukzioak() +"]";

		assertEquals(txt, esperotakoa);
	}

	// ********************** EQUALS **********************

	@Test
	public void TestEqualsObjetuBerdina() {
		assertTrue(pd1.equals(pd1));
	}

	@Test
	public void TestEqualsNull() {
		assertFalse(pd1.equals(null));
	}

	@Test
	public void TestEqualsClaseEzberdinak() {
		String txarra = "";
		assertFalse(pd1.equals(txarra));
	}

	@Test
	public void TestEqualsClaseAtrBerdinak() {
		Podcaster pd2 = new Podcaster("1", "unai", blob, "deskribapena");
		assertTrue(pd1.equals(pd2));
	}

}
