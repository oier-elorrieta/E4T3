package test.Dao;

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
import model.objektuak.Musikaria;

public class TAlbumDao {
	private static Musikaria m1;
	private static AlbumDao albumdao;

	@Before
	public void setUp() throws Exception {
		m1 = new Musikaria("MU001", "unai", null, "deskribapena", "ezaugarria");
		albumdao = new AlbumDao();
	}

	// konprobatzen dut itzultzen duen Array-a elementu bakarra daukala barruan
	@Test
	public void testgetAlbumakByMusikaria() throws SQLException {
		assertEquals(albumdao.getAlbumakByMusikaria(m1).size(), 1);
	}

	// konparatzen dut "AL001" IDarekin bueltatzen duen deskripzioa, espero
	// dudanarekin. Horrela dakigu funtzioa ondo doala.
	@Test
	public void testgetAlbumById() throws SQLException {
		assertEquals(albumdao.getAlbumById("AL001").getDeskripzioa(), "Estoparen lehen albuma");
	}
}
