package test.objektuak;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.objektuak.Abestia;
import model.objektuak.Album;
import model.objektuak.Musikaria;

public class TAlbum {

	private static Blob blob;
	private static Blob blob2;
	private static Album album;
	private static Album album2;
	private static Album album3;
	private static Album album4;
	private static Album album5;
	private static Date eguna;
	private static Musikaria m1;
	private static ArrayList<Abestia> abestiak;

	@Before
	public void setUp() throws Exception {
		byte[] blobData = "Datos de ejemplo".getBytes();
		byte[] blobData2 = "Datos de ejemplo2".getBytes();
		blob = new javax.sql.rowset.serial.SerialBlob(blobData);
		blob2 = new javax.sql.rowset.serial.SerialBlob(blobData2);
		eguna = new Date(2024 / 04 / 18);
		m1 = new Musikaria("1", "unai", null, "deskribapena", "ezaugarria");
		abestiak = new ArrayList<>();
		album = new Album("1", "izenburua", eguna, "generoa", 2, 300, blob, "deskribapena");
		album2 = new Album("1", "izenburua", 2);
		album4 = new Album("1", "izenburua", eguna, "generoa", "deskribapena");
		album3 = new Album("5", "izenburua", 5);
		album5 = new Album("5", "izenburua", 5);
		
	}

	// ********************** ID **********************

	@Test
	public void TestGetID() {
		assertEquals("1", album.getId());
	}

	@Test
	public void TestSetID() {
		album.setId("2");
		assertEquals("2", album.getId());
	}

	@Test
	public void TestGetIDTxarto() {
		assertNotEquals("2", album.getId());
	}

	@Test
	public void TestSetIDTxarto() {
		album.setId("2");
		assertNotEquals("1", album.getId());
	}

	// ********************** IZENBURUA **********************

	@Test
	public void TestGetIzenburua() {
		assertEquals("izenburua", album.getIzenburua());
	}

	@Test
	public void TestSetIzenburua() {
		album.setIzenburua("2");
		assertEquals("2", album.getIzenburua());
	}

	@Test
	public void TestGetIzenburuaTxarto() {
		assertNotEquals("2", album.getIzenburua());
	}

	@Test
	public void TestSetIzenburuaTxarto() {
		album.setIzenburua("2");
		assertNotEquals("izenburua", album.getIzenburua());
	}

	// ********************** URTEA **********************

	@Test
	public void TestGetUrtea() {
		assertEquals(eguna, album.getUrtea());
	}

	@Test
	public void TestSetUrtea() {
		Date eguna2 = new Date(2024 / 04 / 20);
		album.setUrtea(eguna2);
		assertEquals(eguna2, album.getUrtea());
	}

	@Test
	public void TestGetUrteaTxarto() {
		Date eguna2 = new Date(2024 / 04 / 20);
		assertNotEquals(eguna2, album.getUrtea());
	}

	@Test
	public void TestSetUrteaTxarto() {
		Date eguna2 = new Date(2024 / 04 / 20);
		album.setUrtea(eguna2);
		assertNotEquals(eguna, album.getUrtea());
	}

	// ********************** KONT ABESTIAK **********************

	@Test
	public void TestGetkontAbestiak() {
		assertEquals(2, album.getKontAbestiak());
	}

	@Test
	public void TestSetkontAbestiak() {
		album.setKontAbestiak(1);
		assertEquals(1, album.getKontAbestiak());
	}

	@Test
	public void TestGetkontAbestiakTxarto() {
		assertNotEquals(1, album.getKontAbestiak());
	}

	@Test
	public void TestSetkontAbestiakTxarto() {
		album.setKontAbestiak(1);
		assertNotEquals(2, album.getKontAbestiak());
	}

	// ********************** IRAUPENA **********************

	@Test
	public void TestGetIraupena() {
		assertEquals(300, album.getIraupena());
	}

	@Test
	public void TestSetIraupena() {
		album.setIraupena(1);
		assertEquals(1, album.getIraupena());
	}

	@Test
	public void TestGetIraupenaTxarto() {
		assertNotEquals(1, album.getIraupena());
	}

	@Test
	public void TestSetIraupenaTxarto() {
		album.setIraupena(1);
		assertNotEquals(300, album.getIraupena());
	}

	// ********************** IRUDIA **********************

	@Test
	public void TestGetIrudia() {
		assertEquals(blob, album.getIrudia());
	}

	@Test
	public void TestSetIrudia() {
		album.setIrudia(blob2);
		assertEquals(blob2, album.getIrudia());
	}

	@Test
	public void TestGetIrudiaTxarto() {
		assertNotEquals(blob2, album.getIrudia());
	}

	@Test
	public void TestSetIrudiaTxarto() {
		album.setIrudia(blob2);
		assertNotEquals(blob, album.getIrudia());
	}

	// ********************** DESKRIBAPENA **********************

	@Test
	public void TestGetDesk() {
		assertEquals("deskribapena", album.getDeskripzioa());
	}

	@Test
	public void TestSetDesk() {
		album.setDeskripzioa("desk");
		assertEquals("desk", album.getDeskripzioa());
	}

	@Test
	public void TestGetDeskTxarto() {
		assertNotEquals("desk", album.getDeskripzioa());
	}

	@Test
	public void TestSetDeskTxarto() {
		album.setDeskripzioa("desk");
		assertNotEquals("deskribapena", album.getDeskripzioa());
	}

	// ********************** GENEROA **********************

	@Test
	public void TestGetGeneroa() {
		assertEquals("generoa", album.getGeneroa());
	}

	@Test
	public void TestSetGeneroa() {
		album3.setGeneroa("g");
		assertEquals("g", album3.getGeneroa());
	}

	@Test
	public void TestGetGeneroaTxarto() {
		assertNotEquals("g", album3.getGeneroa());
	}

	@Test
	public void TestSetGeneroaTxarto() {
		album3.setGeneroa("g");
		assertNotEquals("generoa", album3.getGeneroa());
	}

	

	// ********************** TO STRING **********************

	@Test
	public void TestToString() {
		String txt = album.toString();

		String esperotakoa = "Album [id=" + album.getId() + ", izenburua=" + album.getIzenburua() + ", urtea="
				+ album.getUrtea() + ", generoa=" + album.getGeneroa() + ", irudia=" + album.getIrudia()
				+ ", musikaria=" + album.getMusikaria() + "]";

		assertEquals(txt, esperotakoa);
	}
	
	// ********************** EQUALS **********************

	@Test
	public void TestEqualsObjetuBerdina() {
		assertTrue(album.equals(album));
	}

	@Test
	public void TestEqualsNull() {
		assertFalse(album.equals(null));
	}

	@Test
	public void TestEqualsClaseEzberdinak() {
		String txarra = "";
		assertFalse(album.equals(txarra));
	}
	
	@Test
	public void TestEqualsBerdinak() {
		assertEquals(album3, album5);
	}

}
