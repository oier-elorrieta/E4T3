package test.Dao;

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

	@Test
	public void testgetAudio() throws SQLException {
		ArrayList<Audio> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from Abestia join Audio using(ID_Audio) where ID_Album ='" + album.getId() + "'";
		ResultSet podcasts = sentencia.executeQuery(kontsulta);

		Abestia AbestiAux;

		while (podcasts.next()) {
			AbestiAux = new Abestia(podcasts.getString("ID_Audio"), podcasts.getString("Izena"), podcasts.getInt("Iraupena"), podcasts.getBlob("Irudia"));
			retArray.add(AbestiAux);
		}

		testArray = audiodao.getAudio(album);
		DB_Konexioa.itxi();
		
		for(int i=0;i<testArray.size();i++) {
		assertEquals(retArray.get(i).getIdAudio(), testArray.get(i).getIdAudio());
		assertEquals(retArray.get(i).getIzena(), testArray.get(i).getIzena());
		assertEquals(retArray.get(i).getIraupena(), testArray.get(i).getIraupena());
		}
	}

}
