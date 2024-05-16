package test.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.dao.AlbumDao;
import model.db.DB_Konexioa;
import model.objektuak.Album;
import model.objektuak.Artista;
import model.objektuak.Audio;
import model.objektuak.Musikaria;

public class TAlbumDao {
	private static Musikaria m1;
	private static AlbumDao albumdao;

	@Before
	public void setUp() throws Exception {
		m1 = new Musikaria("MU1", "E", null, "deskribapena", "ezaugarria");
		albumdao = new AlbumDao();
		DB_Konexioa.testAdmin("a", "a");
		
	}
	
	@Test
	public void testgetAlbumakByMusikaria() throws SQLException {
		Album a1 = new Album("AL1", "Album 1", null, null, 2, 0, null, null);
		assertEquals(albumdao.getAlbumakByMusikaria(m1).get(0), a1);
	}
	
	@Test
	public void testgetAlbumakByMusikariaArrayList() throws SQLException {
		Album a1 = new Album("AL1", "Album 1", null, null, 2, 0, null, null);
		ArrayList<Album> albumList = new ArrayList<Album>();
		albumList.add(a1);
		assertEquals(albumdao.getAlbumakByMusikaria(m1), albumList);
	}

	// konparatzen dut "AL001" IDarekin bueltatzen duen deskripzioa, espero
	// dudanarekin. Horrela dakigu funtzioa ondo doala.
	@Test
	public void testgetAlbumById() throws SQLException {
		assertEquals(albumdao.getAlbumById("AL1").getDeskripzioa(), "Estoparen lehen albuma");
	}
	
	// SI SE AÑADE UNO HAY QUE CAMBIAR EL ID AL MÁS RECIENTE
	@Test
	public void testgetLastId() throws SQLException {
		assertEquals(albumdao.getLastId(), "AL3");
	}
	
	//TESTEAR LOS INSERTS????????
}
