package test.Dao;

import static org.junit.Assert.*;

import java.sql.Connection;
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
	private static ArrayList<Album> testArray;

	@Before
	public void setUp() throws Exception {
		m1 = new Musikaria("MU001", "unai", null, "deskribapena", "ezaugarria");
		albumdao= new AlbumDao();
		testArray = new ArrayList<>(albumdao.getAlbumakByMusikaria(m1));
	}

	@Test
	public void testgetAlbumakByMusikaria() throws SQLException {
		ArrayList<Album> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from AlbumView where ID_Musikaria ='" + m1.getId() + "'";
		ResultSet albumak = sentencia.executeQuery(kontsulta);

		Album AlbumAux;

		while (albumak.next()) {
			AlbumAux = new Album(albumak.getString("ID_Album"), albumak.getString("Izenburua"), albumak.getInt("Abestiak"));
			retArray.add(AlbumAux);
		}

		DB_Konexioa.itxi();
		
		assertEquals(retArray, testArray);
	}
	
	@Test
	public void testgetAlbumById() throws SQLException {
		Album albumRet;
		
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from AlbumInfo where ID_Album = 'AL001';";
		ResultSet albuma = sentencia.executeQuery(kontsulta);
		
		albuma.next();
		
		albumRet = new Album(albuma.getString("ID_Album"), albuma.getString("Izenburua"), albuma.getDate("Urtea"), albuma.getInt("AbestiKop"), 
				albuma.getInt("Iraupena"), albuma.getBlob("Irudia"), albuma.getString("Deskribapena"));
		
		DB_Konexioa.itxi();
		
		Album albumTest = albumdao.getAlbumById("AL001");
		
		assertEquals(albumRet.getId(), albumTest.getId());
		assertEquals(albumRet.getIzenburua(), albumTest.getIzenburua());
		assertEquals(albumRet.getUrtea(), albumTest.getUrtea());
		assertEquals(albumRet.getKontAbestiak(), albumTest.getKontAbestiak());
		assertEquals(albumRet.getIraupena(), albumTest.getIraupena());
		assertEquals(albumRet.getDeskripzioa(), albumTest.getDeskripzioa());
	}
}
