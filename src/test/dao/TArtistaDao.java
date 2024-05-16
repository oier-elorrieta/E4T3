package test.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import model.dao.ArtistaDao;
import model.db.DB_Konexioa;
import model.objektuak.Musikaria;

public class TArtistaDao {
	
	private static Musikaria m1;
	private static ArtistaDao artistadao;

	@Before
	public void setUp() throws Exception {
		DB_Konexioa.testAdmin("a", "a");
		m1 = new Musikaria("MU1", "Estopa");
		artistadao= new ArtistaDao();
	}

	@Test
	public void testGetArtistak() throws SQLException {
		assertEquals(artistadao.getArtistak().get(0), m1);
	}
	
	// SI SE AÑADE UNO HAY QUE CAMBIAR EL ID AL MÁS RECIENTE
	@Test
	public void testgetLastId() throws SQLException {
		assertEquals(artistadao.getLastId(), "MU8");
	}
	
	//TESTEAR INSERTS?????

}
