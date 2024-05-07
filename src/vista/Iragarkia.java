package vista;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.funtzioak.FuntzioBista;
import model.objektuak.Audio;
import javax.swing.JLabel;
import java.awt.Font;

public class Iragarkia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 * @throws LineUnavailableException
	 * @throws InterruptedException 
	 */
	public Iragarkia(ArrayList<Audio> audioList, int index) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Random rand = new Random();
		int ramIragarki = rand.nextInt(2);

		setContentPane(contentPane);
		
		JLabel lblMensajea = new JLabel("Iragarkia!");
		contentPane.add(lblMensajea);
		lblMensajea.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 40));

		String filepath;
		
		if (ramIragarki == 0) {
			filepath = "\\\\10.5.6.220\\music\\iragarkiak\\Terranator.wav";
		} else {
			filepath = "\\\\10.5.6.220\\music\\iragarkiak\\AlbionOnline.wav";
		}
		
		File file = new File(filepath);
		AudioInputStream aui = AudioSystem.getAudioInputStream(file.getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(aui);

		clip.start();
		long tiempo = clip.getMicrosecondLength();
		tiempo = tiempo / 1000;
		
		Timer timer = new Timer();

		TimerTask task = new TimerTask() {
			public void run() {
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiErreprodukzioa(audioList, index);
				dispose();
			}
		};
		
		timer.schedule(task, tiempo);
		
		

	}

}
