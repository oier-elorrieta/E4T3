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
	private static ArrayList<Audio> abestiList;

	@Before
	public void setUp() throws Exception {
		album = new Album("AL001", "Album 1", null, 2, 120, null, "deskripzioa");
		abestidao = new AbestiaDao();
		abestiList = new ArrayList<>(abestidao.getAbestiaByAlbumId(album));
		
	}
	
	@Test
	public void testGetAbestiaByAlbumId() throws SQLException {
		assertEquals(abestidao.getAbestiaByAlbumId(album), abestiList);
	}

}