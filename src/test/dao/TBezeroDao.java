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
	}

	@Test
	public void testkomprobatuErabiltzaileaFree() throws SQLException {
		assertTrue(bezerodao.komprobatuErabiltzailea("a", "a"));
	}
	
	@Test
	public void testkomprobatuErabiltzaileaPremium() throws SQLException {
		assertTrue(bezerodao.komprobatuErabiltzailea("jane_smith", "12345"));
	}
	


}
