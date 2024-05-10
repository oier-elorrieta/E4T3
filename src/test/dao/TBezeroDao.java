package test.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import control.funtzioak.Funtzioak;
import model.dao.BezeroDao;
import model.db.DB_Konexioa;
import model.objektuak.bezero.Free;
import model.objektuak.bezero.Premium;

public class TBezeroDao {

	private static BezeroDao bezerodao;
	private static Free free;
	private static Premium premium;
	private static Date eguna;
	
	@Before
	public void setUp() throws Exception {
		bezerodao = new BezeroDao();
//		eguna = new Date(2024, 04, 18);
//		free = new Free("unai", "souto", "ES", "unaisouto", Funtzioak.enkriptatzailea("1234"), eguna, eguna);
//		premium = new Premium("unai", "souto", "ES", "unaisouto", Funtzioak.enkriptatzailea("1234"), eguna, eguna, eguna);
	}

	@Test
	public void testkomprobatuErabiltzaileaFree() throws SQLException {
		assertTrue(bezerodao.komprobatuErabiltzailea("a", "a"));
	}
	
	@Test
	public void testkomprobatuErabiltzaileaPremium() throws SQLException {
		assertTrue(bezerodao.komprobatuErabiltzailea("jane_smith", "12345"));
	}
	
	//SE REGISTRA DOS VECES Y DA ERROR. HACER DELETE EN EL DAO
	/*@Test
	public void testerregistratuErabiltzaileaFree() throws SQLException {
		assertTrue(bezerodao.erregistratuErabiltzailea(free));
	}
	
	@Test
	public void testerregistratuErabiltzaileaPremium() throws SQLException {
		assertTrue(bezerodao.erregistratuErabiltzailea(premium));
	}
	
	@Test
	public void testupdateErabiltzailea() throws SQLException {
		
	}*/


}
