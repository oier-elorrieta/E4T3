package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Aldagaiak;
import model.db.DB_Konexioa;
import model.objektuak.PlayList;

public class PlayListDao {
	public ArrayList<PlayList> getPlayListak() throws SQLException{
		ArrayList<PlayList> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from Playlist";
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
