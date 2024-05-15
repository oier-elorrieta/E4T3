package test.dao;

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
	private static Podcaster podcaster;

	@Before
	public void setUp() throws Exception {
		podcasterdao = new PodcasterDao();
		podcaster = new Podcaster("The Wild Project", 4);
	}

	@Test
	public void testGetPodcasterByIzena() throws SQLException {
		assertEquals(podcasterdao.getPodcasterByIzena("The Wild Project").getIzen_Artistikoa(), "The Wild Project");
	}

	@Test
	public void testGetPodcaster() throws SQLException {
		assertEquals(podcasterdao.getPodcaster().get(0), podcaster);
	}

}
