package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;


import model.dao.AbestiaDao;
import model.db.DB_Konexioa;
import model.objektuak.Abestia;
import model.objektuak.Album;
import model.objektuak.Audio;

public class TAbestiaDao {
	
	//NO VA
	/*
	private static Album album;
	private static AbestiaDao abestidao;

	@Before
	public void setUp() throws Exception {
		album = new Album("AL001", "Album 1", null, 2, 120, null, "deskripzioa");
		abestidao = new AbestiaDao();
	}

	@Test
	public void testGetAbestiaByAlbumId() throws SQLException {
	    ArrayList<Audio> retArray = new ArrayList<>();
	    Connection conex = DB_Konexioa.bezeroa();

	    Statement sentencia = conex.createStatement();

	    String kontsulta = "select * from Abestia join Audio using(ID_Audio) where ID_Album ='" + album.getId() + "'";
	    ResultSet podcasts = sentencia.executeQuery(kontsulta);

	    Abestia AbestiAux = null;

	    while (podcasts.next()) {
	        AbestiAux = new Abestia(podcasts.getString("ID_Audio"), podcasts.getString("Izena"), podcasts.getInt("Iraupena"), podcasts.getBlob("Irudia"));
	        retArray.add(AbestiAux);
	    }

	    ArrayList<Audio> array2 = abestidao.getAbestiaByAlbumId(album);

	    assertEquals(retArray,array2);
	}*/


}
