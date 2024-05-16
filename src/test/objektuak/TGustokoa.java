package test.objektuak;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.objektuak.Abestia;
import model.objektuak.Gustokoa;
import model.objektuak.bezero.Free;

public class TGustokoa {

	private static Gustokoa gustokoa;
	private static Free free;
	private static Abestia abestia;

	@Before
	public void setUp() throws Exception {
		free = new Free("unai", "souto", "euskera", "unaisouto", "1234", null, null);
		abestia = new Abestia("1", "izena", 100 , "aa");
		gustokoa = new Gustokoa(free, abestia);
	}

	// ********************** BEZEROA **********************
	
	@Test
	public void testGetBezeroa() {
		assertEquals(free, gustokoa.getBezeroa());
	}

	@Test
	public void testGetBezeroaTxarto() {
		assertNotEquals(null, gustokoa.getBezeroa());
	}
	
	// ********************** ABESTIA **********************
	
	@Test
	public void testGetAbestia() {
		assertEquals(abestia, gustokoa.getAbestia());
	}

	@Test
	public void testGetAbestiaTxarto() {
		assertNotEquals(null, gustokoa.getAbestia());
	}

}
