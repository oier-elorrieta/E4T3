package test.Dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.dao.MusikariaDao;
import model.db.DB_Konexioa;
import model.objektuak.Musikaria;

public class TMusikariaDao {

	private static ArrayList<Musikaria> testArray;
	private static MusikariaDao musikaridao;

	@Before
	public void setUp() throws Exception {
		musikaridao = new MusikariaDao();
		testArray = new ArrayList<>();
	}

	@Test
	public void testgetMusikariak() throws SQLException {
		ArrayList<Musikaria> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from musikaDeskubritu";
		ResultSet erreprodukzioak = sentencia.executeQuery(kontsulta);

		Musikaria erreprodukzioaAux;

		while (erreprodukzioak.next()) {
			erreprodukzioaAux = new Musikaria(erreprodukzioak.getString("Musikaria"),
					erreprodukzioak.getInt("Erreprodukzioak"));
			retArray.add(erreprodukzioaAux);
		}

		testArray = musikaridao.getMusikariak();
		DB_Konexioa.itxi();

		assertEquals(retArray, testArray);

	}

	@Test
	public void testgetMusikariaByIzena() throws SQLException {
		Musikaria musikariaRet;
		Musikaria musikariaTest = musikaridao.getMusikariaByIzena("Estopa");

		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from Musikaria where Izen_Artistikoa = 'Estopa'";
		ResultSet musikaria = sentencia.executeQuery(kontsulta);

		musikaria.next();

		musikariaRet = new Musikaria(musikaria.getString("ID_Musikaria"), musikaria.getString("Izen_Artistikoa"),
				musikaria.getBlob("Irudia"), musikaria.getString("Deskribapena"), musikaria.getString("Ezaugarria"));

		DB_Konexioa.itxi();

		assertEquals(musikariaRet.getId(), musikariaTest.getId());
		assertEquals(musikariaRet.getIzen_Artistikoa(), musikariaTest.getIzen_Artistikoa());
		assertEquals(musikariaRet.getDeskribapena(), musikariaTest.getDeskribapena());
		assertEquals(musikariaRet.getEzaugarria(), musikariaTest.getEzaugarria());

	}

}
