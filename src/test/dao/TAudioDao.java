package test.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.dao.AudioDao;
import model.db.DB_Konexioa;
import model.objektuak.Abestia;
import model.objektuak.Album;
import model.objektuak.Audio;

public class TAudioDao {
	
	private static Album album;
	private static AudioDao audiodao;
	private static Abestia abestia;

	@Before
	public void setUp() throws Exception {
		album = new Album("AL1", "Album 1", null, null, 2, 120, null, "deskripzioa");
		audiodao = new AudioDao();
		abestia = new Abestia("AU3", "Como Camaron", 218, "");
		DB_Konexioa.testAdmin("a", "a");
	}
	
	@Test
	public void testgetAudio() throws SQLException {
		assertEquals(audiodao.getAudio(album).get(0), abestia);
	}
	
	@Test
	public void testgetLastId() throws SQLException {
		assertEquals(audiodao.getLastId(), "AU17");
	}


}
