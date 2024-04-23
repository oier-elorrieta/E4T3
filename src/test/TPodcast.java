package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.objektuak.Podcast;
import model.objektuak.Podcaster;
import model.objektuak.bezero.Premium;

public class TPodcast {

	private static Podcast pc1;
	private static Podcaster pd1;
	private static Podcaster pd2;

	@Before
	public void setUp() throws Exception {
		pd1 = new Podcaster("1", "unai", "irudia", "deskribapena");
		pc1 = new Podcast("1", "izena", 120, "irudia", "unai, iker, jon", pd1);
		pd2 = new Podcaster("2", "unai", "irudia", "deskribapena");
	}

	// ********************** KOLABORATZAILEAK **********************

	@Test
	public void TestGetKolab() {
		assertEquals("unai, iker, jon", pc1.getKolaboratzaileak());
	}

	@Test
	public void TestSetKolab() {
		pc1.setKolaboratzaileak("unai");
		assertEquals("unai", pc1.getKolaboratzaileak());
	}

	@Test
	public void TestGetKolabTxarto() {
		assertNotEquals("unai", pc1.getKolaboratzaileak());
	}

	@Test
	public void TestSetKolabTxarto() {
		pc1.setKolaboratzaileak("unai");
		assertNotEquals("unai, iker, jon", pc1.getKolaboratzaileak());
	}

	// ********************** PODCASTER **********************

	@Test
	public void TestGetPodcaster() {
		assertEquals(pd1, pc1.getPodcaster());
	}

	@Test
	public void TestSetPodcaster() {
		pc1.setPodcaster(pd2);
		assertEquals(pd2, pc1.getPodcaster());
	}

	@Test
	public void TestGetPodcasterTxarto() {
		assertNotEquals(pd2, pc1.getPodcaster());
	}

	@Test
	public void TestSetPodcasterTxarto() {
		pc1.setPodcaster(pd2);
		assertNotEquals(pd1, pc1.getPodcaster());
	}

	// ********************** TO STRING **********************

	@Test
	public void TestToString() {
		String txt = pc1.toString();

		String esperotakoa = "Audio [idAudio=" + pc1.getIdAudio() + ", izena=" + pc1.getIzena() + ", iraupena="
				+ pc1.getIraupena() + ", irudia=" + pc1.getIrudia() + "]" + "Podcast [kolaboratzaileak="
				+ pc1.getKolaboratzaileak() + ", podcaster=" + pc1.getPodcaster() + "]";

		assertEquals(txt, esperotakoa);
	}

	// ********************** EQUALS **********************

	@Test
	public void TestEqualsObjetuBerdina() {
		assertTrue(pc1.equals(pc1));
	}

	@Test
	public void TestEqualsNull() {
		assertFalse(pc1.equals(null));
	}

	@Test
	public void TestEqualsClaseEzberdinak() {
		String txarra = "";
		assertFalse(pc1.equals(txarra));
	}

	@Test
	public void TestEqualsClaseAtrBerdinak() {
		Podcast pc2 = new Podcast("1", "izena", 120, "irudia", "unai, iker, jon", pd1);
		assertTrue(pc1.equals(pc2));
	}

}
