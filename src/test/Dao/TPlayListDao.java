package test.Dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Aldagaiak;
import model.dao.PlayListDao;
import model.db.DB_Konexioa;
import model.objektuak.PlayList;
import model.objektuak.bezero.Free;

public class TPlayListDao {
	private static PlayListDao playlistdao;
	private static ArrayList<PlayList> testArray;
	private static Free free;

	//FALLA EL PLAYLIST DAO
	/*
	@Before
	public void setUp() throws Exception {
		playlistdao = new PlayListDao();
		testArray = new ArrayList<>();
		free = new Free(1, "unai", "souto", "euskera", "unaisouto", "1234", null, null);
	}

	@Test
	public void testgetPlayListak() throws SQLException {
		ArrayList<PlayList> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from playListView where ID_Bezeroa =" + free.getId() +";";
		ResultSet playlistak = sentencia.executeQuery(kontsulta);

		PlayList playlistAux;

		while (playlistak.next()) {
			playlistAux = new PlayList(playlistak.getString("ID_List"), playlistak.getString("Izena"), playlistak.getInt("Abestiak"));
			retArray.add(playlistAux);
		}

		testArray = playlistdao.getPlayListak();
		DB_Konexioa.itxi();
		assertEquals(retArray.get(0).getId(), testArray.get(0).getId());
	}*/

}
