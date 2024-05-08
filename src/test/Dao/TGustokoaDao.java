package test.Dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import model.dao.GustokoaDao;
import model.objektuak.Abestia;
import model.objektuak.Audio;
import model.objektuak.Gustokoa;
import model.objektuak.bezero.Free;

public class TGustokoaDao {

	private static Free bezeroa;
	private static Audio abestia;
	private static GustokoaDao gustokoadao;

	@Before
	public void setUp() throws Exception {
		bezeroa = new Free(1, "unai", "souto", "euskera", "unaisouto", "1234", null, null);
		abestia = new Abestia("AU003", "izena", 120, null);

		gustokoadao = new GustokoaDao();
	}

	@Test
	public void testgustokoaKonprobatuDago() throws SQLException {
		Gustokoa gustokoa = new Gustokoa(bezeroa, abestia);
		gustokoadao.gustokoaGehiKen(gustokoa);
		assertTrue(gustokoadao.gustokoaKonprobatu(gustokoa));
	}
	
	@Test
	public void testgustokoaKonprobatuEZDago() throws SQLException {
		Gustokoa gustokoa = new Gustokoa(bezeroa, abestia);
		gustokoadao.gustokoaGehiKen(gustokoa);
		assertFalse(gustokoadao.gustokoaKonprobatu(gustokoa));
	}



}
