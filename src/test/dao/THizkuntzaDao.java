package test.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.dao.HizkuntzaDao;
import model.db.DB_Konexioa;
import model.objektuak.Hizkuntza;

public class THizkuntzaDao {

	private static ArrayList<Hizkuntza> testArray;
	private static HizkuntzaDao hizkuntzadao;
	private static Hizkuntza hizkuntza;

	@Before
	public void setUp() throws Exception {
		testArray = new ArrayList<>();
		hizkuntzadao = new HizkuntzaDao();
		hizkuntza = new Hizkuntza("ES", "Spanish");
	}

	@Test
	public void testgetHizkuntzak() throws SQLException {
		assertEquals(hizkuntzadao.getHizkuntzak().get(0), hizkuntza);
	}

}
