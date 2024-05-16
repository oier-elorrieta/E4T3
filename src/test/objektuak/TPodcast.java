package test.objektuak;

import static org.junit.Assert.*;

import java.sql.Blob;

import org.junit.Before;
import org.junit.Test;

import model.objektuak.Abestia;
import model.objektuak.Podcast;
import model.objektuak.Podcaster;

public class TPodcast {

	private static Podcast podcast;
	private static Podcast podcast3;
	private static Podcast podcast2;
	private static Podcaster podcaster;

	@Before
	public void setUp() throws Exception {
		podcaster = new Podcaster("1", "unai", null, "deskribapena");
		podcast = new Podcast("1", "izena", 120, "kolab",null);
		podcast2 = new Podcast("1", "izena", "kolab", 2);
		podcast3 = new Podcast("1", "izena", 120, "kolab",null);
	}

	// ********************** KOLABORATZAILEAK **********************

	@Test
	public void TestgetKolaboratzaileak() {
		assertEquals("kolab", podcast.getKolaboratzaileak());
	}

	@Test
	public void TestsetKolaboratzaileak() {
		podcast.setKolaboratzaileak("proba");
		assertEquals("proba", podcast.getKolaboratzaileak());
	}

	@Test
	public void TestgetKolaboratzaileakTxarto() {
		assertNotEquals("kolabb", podcast.getKolaboratzaileak());
	}

	@Test
	public void TestsetKolaboratzaileakTxarto() {
		podcast.setKolaboratzaileak(null);
		assertNotEquals("kolab", podcast.getKolaboratzaileak());
	}

	// ********************** PODCASTER **********************



	@Test
	public void TestsetPodcaster() {
		podcast.setPodcaster(null);
		assertEquals(null, podcast.getPodcaster());
	}


	@Test
	public void TestsetPodcasterTxarto() {
		podcast.setPodcaster(null);
		assertNotEquals(podcaster, podcast.getPodcaster());
	}


	// ********************** TO STRING **********************

	@Test
	public void TestToString() {
		String txt = podcast.toString();

		String esperotakoa = "Audio [idAudio=" + podcast.getIdAudio() + ", izena=" + podcast.getIzena() + ", iraupena="
				+ podcast.getIraupena() + ", irudia=" + podcast.getIrudia() + "]" + " Podcast [kolaboratzaileak="
				+ podcast.getKolaboratzaileak() + ", podcaster=" + podcast.getPodcaster() + "]";
		
		assertEquals(txt, esperotakoa);
	}
	
	// ********************** EQUALS **********************

	@Test
	public void TestEqualsObjetuBerdina() {
		assertTrue(podcast.equals(podcast));
	}

	@Test
	public void TestEqualsNull() {
		assertFalse(podcast.equals(null));
	}

	@Test
	public void TestEqualsClaseEzberdinak() {
		String txarra = "";
		assertFalse(podcast.equals(txarra));
	}
	
	@Test
	public void TestEqualsBerdinak() {
		assertEquals(podcast, podcast3);
	}

}
