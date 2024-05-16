package test.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import model.dao.EstadistikakDao;
import model.objektuak.Estadistikak;

public class TEstadistikakDao {
	
	private static Estadistikak e1;
	private static EstadistikakDao dao;

	@Before
	public void setUp() throws Exception {
		e1 = new Estadistikak("AU3", "Como Camaron", 1000, 4300, 2398542);
		dao = new EstadistikakDao();
	}

	@Test
	public void testgetEstadistikak() throws SQLException {
		assertEquals(dao.getEstadistikak().get(0), e1);
	}

}
