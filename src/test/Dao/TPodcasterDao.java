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
		assertEquals(podcasterdao.getPodcasterByIzena("The Wild Project").getId(), "PO001");
	}

	@Test
	public void testGetPodcaster() throws SQLException {
		assertEquals(podcasterdao.getPodcaster().size(), 2);
	}

}
