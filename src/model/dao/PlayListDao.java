package model.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Aldagaiak;
import model.db.DB_Konexioa;
import model.objektuak.Audio;
import model.objektuak.PlayList;
import model.salbuespenak.PlayListLimit;
import vista.interfaseak.daoGetId;

public class PlayListDao implements daoGetId{
	
	Connection conex;
	
	/**
	 * Bezero baten playlist dituen bilatzen dituen metodo bat da.
	 * 
	 * @param Playlist objetua
	 * @return ArrayList playlist
	 * @throws SQLException
	 */
	public ArrayList<PlayList> getPlayListak(boolean gustokoak) throws SQLException{
		ArrayList<PlayList> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from playListView where ID_Bezeroa =" + Aldagaiak.erabiltzailea.getId()+";";
		ResultSet playlistak = sentencia.executeQuery(kontsulta);

		PlayList playlistAux;
		if (gustokoak) {
			playlistAux = new PlayList("noID","Gustokoak");
			retArray.add(playlistAux);
		}
		while (playlistak.next()) {
			playlistAux = new PlayList(playlistak.getString("ID_List"), playlistak.getString("Izena"), playlistak.getInt("Abestiak"));
			retArray.add(playlistAux);
		}

		DB_Konexioa.itxi();
		return retArray;
	}
	
	/**
	 * Abesti bat playlist batean txertatzeko metodoa.
	 * 
	 * @param playlist PlayList objektua, zeina abestia gehituko duen.
	 * @param abestia Audio objektua, gehitu nahi dena.
	 * @throws SQLException SQL errore bat gertatzen bada.
	 */
	public void insertAbestiaIntoPlayList(PlayList playlist, Audio abestia) throws SQLException {
		Connection conex = DB_Konexioa.bezeroa();
		
		Statement sentencia = conex.createStatement();
		
		String kontsulta = "INSERT INTO Playlist_Abestiak (ID_List, ID_Audio) VALUES ('"+ playlist.getId() + "', '" + abestia.getIdAudio() + "');";
		sentencia.executeUpdate(kontsulta);
		
		DB_Konexioa.itxi();
	}
	
	public boolean newPlayList(PlayList playlist) throws SQLException{
		conex = DB_Konexioa.bezeroa();
		
		Statement sentencia = conex.createStatement();
		java.sql.Date sqlDateSorreraData = new java.sql.Date(playlist.getSorreraData().getTime());
		String bezeroID = Integer.toString(playlist.getBezeroa().getId());
		
		String kontsulta = "INSERT INTO Playlist (ID_List, Izenburua, Sorrera_data, ID_Bezeroa) VALUES ('"+ playlist.getId() + "', '" + playlist.getIzena() + "', '" + sqlDateSorreraData + "' , '" +bezeroID +"');";
		
		int maxPlaylist = 0;
		if (Aldagaiak.erabiltzailea.getClass().getSimpleName().equals("Free")) {
			maxPlaylist = getMaxPlaylist();
		}
		
		try {
		
			if(maxPlaylist < 3) {
				throw new PlayListLimit();
			}
			sentencia.executeUpdate(kontsulta);
			DB_Konexioa.itxi();
			return true;
			
			
		}catch(PlayListLimit pl){
			JOptionPane.showMessageDialog(null, pl.getMessage(), "", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	}
	
	@Override
	public String getLastId() throws SQLException {
		String ret = "";
		Connection conex = DB_Konexioa.bezeroa();
		
		Statement sentencia = conex.createStatement();
		
		String kontsulta = "select ID_List from Playlist ORDER BY char_length(ID_List) desc, substr(ID_List,3) desc;";
		ResultSet lastID = sentencia.executeQuery(kontsulta);
		
		lastID.next();
		ret = lastID.getString(1);
		
		return ret;
		
		
	}
	
	public boolean deletePlayListById(PlayList playlist) throws SQLException{
		Connection conex = DB_Konexioa.bezeroa();
		
		Statement sentencia = conex.createStatement();
		
		String kontsulta = "DELETE from Playlist where ID_List='" + playlist.getId() +"';";
		
		
		try {
			sentencia.executeUpdate(kontsulta);
			DB_Konexioa.itxi();
			return true;
		}catch (Exception ex) {
			ex.printStackTrace();
			DB_Konexioa.itxi();
			return false;
		}

	}
	
	private int getMaxPlaylist() throws SQLException{
		
		Statement sent = conex.createStatement();
		
		String konsulta ="select count(ID_List) as 'count' from Playlist where ID_Bezeroa=" + Aldagaiak.erabiltzailea.getId() +";";		
		ResultSet counts = sent.executeQuery(konsulta);
		
		counts.next();
		
		return counts.getInt(1);
		
		
		
	}
	
	
}