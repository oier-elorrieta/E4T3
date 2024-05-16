package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.db.DB_Konexioa;
import model.objektuak.Abestia;
import model.objektuak.Artista;
import model.objektuak.Musikaria;
import model.objektuak.Podcaster;

public class PodcasterDao {
	
	private final String defaultBlob = "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\r\n";

	
	/**
	 * Podcaster guztiak bilatzen dituen metodo bat da.
	 * 
	 * @param Podcaster objetua
	 * @return ArrayList podcaster
	 * @throws SQLException
	 */
	public ArrayList<Podcaster> getPodcaster() throws SQLException{
		ArrayList<Podcaster> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from podcastDeskubritu";
		ResultSet podcaster = sentencia.executeQuery(kontsulta);

		Podcaster podcasterAux;

		while (podcaster.next()) {
			podcasterAux = new Podcaster(podcaster.getString("ID"),podcaster.getString("Podcasterra"), podcaster.getInt("Erreprodukzioak"));
			retArray.add(podcasterAux);
		}

		DB_Konexioa.itxi();
		return retArray;
	}
	
	/**
	 * Podcaster bat izen artistikoaren arabera lortzen duen metodoa.
	 * 
	 * @param izena Podcasterraren izen artistikoa.
	 * @return Podcaster objektua, bilatutako podcasterra ordezkatzen duena.
	 * @throws SQLException SQL errore bat gertatzen bada.
	 */
	public Podcaster getPodcasterByIzena(String izena) throws SQLException{
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from Podcaster where Izen_Artistikoa = '" + izena + "';";
		ResultSet podcaster = sentencia.executeQuery(kontsulta);
		
		podcaster.next();

		Podcaster podcasterAux;

		podcasterAux = new Podcaster(podcaster.getString("ID_Podcaster"), podcaster.getString("Izen_Artistikoa"), podcaster.getBlob("Irudia"), podcaster.getString("Deskribapena"));

		DB_Konexioa.itxi();
		return podcasterAux;
	}
	
	public String getLastId() throws SQLException {
		String ret = "";
		Connection conex = DB_Konexioa.admin();
		
		Statement sentencia = conex.createStatement();
		
		String kontsulta = "select ID_Podcaster from Podcaster ORDER BY char_length(ID_Podcaster) desc, substr(ID_Podcaster,3) desc;";
		ResultSet lastID = sentencia.executeQuery(kontsulta);
		try {
			lastID.next();
			ret = lastID.getString(1);
			conex.close();
			return ret;	
		}catch(SQLException e) {
			ret = "PO0";
			return ret;
		}
		
		
	}
	
	public boolean podcasterGehitu(Artista artista) throws SQLException {
		Connection conex = DB_Konexioa.admin();
		
		Statement sentencia = conex.createStatement();
		

		String kontsulta = "INSERT INTO Podcaster (ID_Podcaster, Izen_Artistikoa,Irudia, Deskribapena) VALUES ('"+ artista.getId() + "', '" + artista.getIzen_Artistikoa() + "', FROM_BASE64('" + defaultBlob+ "'), '" + artista.getDeskribapena() + "');";
		sentencia.executeUpdate(kontsulta);
		
		DB_Konexioa.itxi();
		return true;

	}
	
	public boolean deletePodcasterByIzena(Artista artista) throws SQLException{
		Connection conex = DB_Konexioa.admin();
		
		Statement sentencia = conex.createStatement();
		
		String kontsulta = "DELETE from Podcaster where Izen_Artistikoa='" + artista.getIzen_Artistikoa() +"';";
		
		
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
	
	public boolean updatePodcaster(Podcaster podcaster) throws SQLException {
		Connection conex = DB_Konexioa.admin();

		Statement statement = conex.createStatement();

		
		String kontsulta = "UPDATE Podcaster SET Izen_Artistikoa ='"+podcaster.getIzen_Artistikoa()+"',Deskribapena ='"+podcaster.getDeskribapena()+"' where ID_Podcaster ='"+podcaster.getId()+"';";
		
		statement.executeUpdate(kontsulta);
	

		DB_Konexioa.itxi();
		return true;
	}
}
