package test.Dao;

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
	
	@Before
	public void setUp() throws Exception {
		testArray = new ArrayList<>();
		hizkuntzadao = new HizkuntzaDao();
	}

	@Test
	public void test() throws SQLException {
		ArrayList<Hizkuntza> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from Hizkuntza";
		ResultSet hizkuntzak = sentencia.executeQuery(kontsulta);

		Hizkuntza HizkuntzaAux;

		while (hizkuntzak.next()) {
			HizkuntzaAux = new Hizkuntza(hizkuntzak.getString("ID_Hizkuntza"), hizkuntzak.getString("Deskribapena"));
			retArray.add(HizkuntzaAux);
		}

		DB_Konexioa.itxi();
		
		testArray = hizkuntzadao.getHizkuntzak();
		for (int i=0;i<testArray.size();i++) {
			assertEquals(retArray.get(i).getID_Hizkuntza(), testArray.get(i).getID_Hizkuntza());
			assertEquals(retArray.get(i).getDeskribapena(), testArray.get(i).getDeskribapena());
		}
		
	}

}
