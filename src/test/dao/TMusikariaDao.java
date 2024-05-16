package test.dao;

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

	private static Musikaria m1;
	private static MusikariaDao musikaridao;

	@Before
	public void setUp() throws Exception {
		musikaridao = new MusikariaDao();
		m1 = new Musikaria("Estopa", 2);
		
	}

	@Test
	public void testgetMusikariak() throws SQLException {
		assertEquals(musikaridao.getMusikariak().get(0), m1);
	}

	@Test
	public void testgetMusikariaByIzena() throws SQLException {
		assertEquals(musikaridao.getMusikariaByIzena("Estopa").getIzen_Artistikoa(), "Estopa");
	}

}
