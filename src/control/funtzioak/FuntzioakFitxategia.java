package control.funtzioak;

import java.io.*;



import model.objektuak.Audio;

public class FuntzioakFitxategia {
	public static boolean audioKompartitu(Audio audio) throws IOException{
		String rutaArchivo = audio.getIzena() + ".txt";
		File archivo = new File(rutaArchivo);
		FileWriter escritor = new FileWriter(archivo);
		BufferedWriter bufferedWriter = new BufferedWriter(escritor);
		
		bufferedWriter.write("ID_Abestia: " + audio.getIdAudio() +".");
		bufferedWriter.newLine();
		bufferedWriter.write("Izena: " + audio.getIzena() +".");
		bufferedWriter.newLine();
		bufferedWriter.write("Iraupena: " + Funtzioak.secondsToString(audio.getIraupena()));
		bufferedWriter.newLine();
		
		bufferedWriter.close();
		
		return true;
	}
}
