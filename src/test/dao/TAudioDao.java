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
	private static ArrayList<Audio> testArray;

	@Before
	public void setUp() throws Exception {
		album = new Album("AL001", "Album 1", null, 2, 120, null, "deskripzioa");
		audiodao = new AudioDao();
		testArray = new ArrayList<>();
	}
	
	// bueltatzen duen Array-a bi posizio baditu ondo egongo da
	@Test
	public void testgetAudio() throws SQLException {
		assertEquals(audiodao.getAudio(album).size(), 2);
	}

}
