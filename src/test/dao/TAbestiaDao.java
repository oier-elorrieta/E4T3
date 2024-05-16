package test.dao;

import static org.junit.Assert.*;

import java.sql.*;
import java.util.ArrayList;
import org.junit.*;

import model.dao.AbestiaDao;
import model.db.DB_Konexioa;
import model.objektuak.*;

public class TAbestiaDao {

	private static Album album;
	private static AbestiaDao abestidao;
	private static Abestia abestia;

	@Before
	public void setUp() throws Exception {
		album = new Album("AL1", "Album 1", null, null, 2, 120, null, "deskripzioa");
		abestidao = new AbestiaDao();
		abestia = new Abestia("AU3", "Como Camaron", 218, "3");
	}

	@Test
	public void testGetAbestiaByAlbumId() throws SQLException {
		assertEquals(abestidao.getAbestiaByAlbumId(album).get(0), abestia);
	}
	
	@Test
	public void testGetAbestiaByAlbumIds() throws SQLException {
		assertEquals(abestidao.getAbestiaByAlbumId(album).get(0), abestia);
	}

}