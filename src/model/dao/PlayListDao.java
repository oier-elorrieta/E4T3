package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.Aldagaiak;
import model.db.DB_Konexioa;
import model.objektuak.PlayList;

public class PlayListDao {
	public ArrayList<PlayList> getPlayListak() throws SQLException{
		ArrayList<PlayList> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from Playlist where ID_Bezeroa = " + Aldagaiak.erabiltzailea.getId();
		ResultSet playlistak = sentencia.executeQuery(kontsulta);

		PlayList playlistAux;

		while (playlistak.next()) {
			playlistAux = new PlayList(playlistak.getString("ID_List"), playlistak.getString("Izenburua"), playlistak.getDate("Sorrera_data"), Aldagaiak.erabiltzailea );
			retArray.add(playlistAux);
		}

		DB_Konexioa.itxi();
		return retArray;
	}
}
