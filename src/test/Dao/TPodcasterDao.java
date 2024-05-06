package test.Dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.dao.PodcasterDao;
import model.db.DB_Konexioa;
import model.objektuak.Podcaster;

public class TPodcasterDao {
	// private static final String = null;
	private static PodcasterDao podcasterdao;

	@Before
	public void setUp() throws Exception {
		podcasterdao = new PodcasterDao();
	}

	@Test
	public void testGetPodcasterByIzena() throws SQLException {
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from Podcaster where Izen_Artistikoa = 'The Wild Project';";
		ResultSet podcaster = sentencia.executeQuery(kontsulta);

		podcaster.next();

		Podcaster podcasterAux;

		podcasterAux = new Podcaster(podcaster.getString("ID_Podcaster"), podcaster.getString("Izen_Artistikoa"),
				podcaster.getBlob("Irudia"), podcaster.getString("Deskribapena"));

		DB_Konexioa.itxi();
		Podcaster podcasterTest = podcasterdao.getPodcasterByIzena("The Wild Project");

		assertEquals(podcasterAux.getId(), podcasterTest.getId());
		assertEquals(podcasterAux.getIzen_Artistikoa(), podcasterTest.getIzen_Artistikoa());
		assertEquals(podcasterAux.getDeskribapena(), podcasterTest.getDeskribapena());
	}

	@Test
	public void testGetPodcaster() throws SQLException {
		ArrayList<Podcaster> retArray = new ArrayList<>();
		ArrayList<Podcaster> testArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from podcastDeskubritu";
		ResultSet podcaster = sentencia.executeQuery(kontsulta);

		Podcaster podcasterAux;

		while (podcaster.next()) {
			podcasterAux = new Podcaster(podcaster.getString("Podcasterra"), podcaster.getInt("Erreprodukzioak"));
			retArray.add(podcasterAux);
		}

		testArray = podcasterdao.getPodcaster();
		DB_Konexioa.itxi();
		assertEquals(retArray, testArray);

	}

}
