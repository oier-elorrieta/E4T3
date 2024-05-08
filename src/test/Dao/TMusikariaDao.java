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
		assertEquals(musikaridao.getMusikariak().size(), 2);
	}

	@Test
	public void testgetMusikariaByIzena() throws SQLException {
		assertEquals(musikaridao.getMusikariaByIzena("Estopa").getId(), "MU001");
	}

}
