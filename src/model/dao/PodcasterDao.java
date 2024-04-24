package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.db.DB_Konexioa;
import model.objektuak.Podcaster;

public class PodcasterDao {
	public ArrayList<Podcaster> getPodcaster() throws SQLException{
		ArrayList<Podcaster> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from podcastDeskubritu";
		ResultSet podcaster = sentencia.executeQuery(kontsulta);

		Podcaster podcasterAux;

		while (podcaster.next()) {
			podcasterAux = new Podcaster(podcaster.getString("Podcasterra"), podcaster.getInt("Erreprodukzioak"));
			retArray.add(podcasterAux);
		}

		DB_Konexioa.itxi();
		return retArray;
	}
}
