package vista.bezeroa;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import control.funtzioak.FuntzioBista;
import control.funtzioak.Funtzioak;
import model.Aldagaiak;
import model.dao.*;
import model.objektuak.*;

import javax.swing.table.DefaultTableModel;;

public class Erreprodukzioa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel model;
	private boolean entzuten = false;
	JLabel lblIrudia = new JLabel("");
	/* audio variables */
	String filepath = "";
	Clip clip = null;
	AudioInputStream aui = null;
	File file = null;

	MusikariaDao musikariadao = new MusikariaDao();
	GustokoaDao gustokoadao = new GustokoaDao();
	ArrayList<Musikaria> musikariak = new ArrayList<Musikaria>();
	int indexx = -1;
	ImageIcon icon = null;

	private JButton btnAurrekoa = new JButton("<");
	private JButton btnHurrengoa = new JButton(">");
	private JPanel panelBotoiak = new JPanel();
	private String[] abiadura = { "x0.5", "x1", "x1.5", "x2" };
	private int abiaduraKont = 1;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 * @throws LineUnavailableException
	 */
	public Erreprodukzioa(ArrayList<Audio> audioList, int index)
			throws SQLException, UnsupportedAudioFileException, IOException, LineUnavailableException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Erreprodukzioa.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelHeader = new JPanel();
		contentPane.add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new BorderLayout(0, 0));
		// ***************************
		System.out.println(index);
		filepath = "\\\\10.5.6.220\\music\\" + audioList.get(index).getIzena() + ".wav";
		file = new File(filepath);
		aui = AudioSystem.getAudioInputStream(file.getAbsoluteFile());
		clip = AudioSystem.getClip();
		clip.open(aui);

		// Erabiltzailearen izena bistaratzeko botoia
		JButton btnPerfil = new JButton(Aldagaiak.erabiltzailea.getErabiltzaileIzena());
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiErregistroa();
				dispose();
			}
		});
		btnPerfil.setSize(325, 20);
		panelHeader.add(btnPerfil, BorderLayout.EAST);

		// Atzera botoia
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setSize(325, 20);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiBezeroMenu();
				dispose();
			}
		});
		panelHeader.add(btnAtzera, BorderLayout.WEST);

		JLabel lblErreprodukzioak = new JLabel("Erreprodukzioak");
		lblErreprodukzioak.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblErreprodukzioak.setHorizontalAlignment(SwingConstants.CENTER);
		panelHeader.add(lblErreprodukzioak, BorderLayout.CENTER);

		JPanel Erreprodukzioa = new JPanel();
		contentPane.add(Erreprodukzioa, BorderLayout.CENTER);
		Erreprodukzioa.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("          ");
		Erreprodukzioa.add(lblNewLabel_1, BorderLayout.WEST);

		JLabel lblNewLabel_2 = new JLabel("          ");
		Erreprodukzioa.add(lblNewLabel_2, BorderLayout.EAST);

		JLabel lblNewLabel_3 = new JLabel("  ");
		Erreprodukzioa.add(lblNewLabel_3, BorderLayout.NORTH);

		JLabel lblNewLabel_4 = new JLabel(" ");
		Erreprodukzioa.add(lblNewLabel_4, BorderLayout.SOUTH);

		JPanel panelKontenidoa = new JPanel();
		Erreprodukzioa.add(panelKontenidoa, BorderLayout.CENTER);
		panelKontenidoa.setLayout(new BorderLayout(0, 0));

		JPanel panelFooter = new JPanel();
		panelKontenidoa.add(panelFooter, BorderLayout.SOUTH);
		panelFooter.setLayout(new BorderLayout(0, 0));

		panelFooter.add(panelBotoiak, BorderLayout.CENTER);

		JButton btnMenu = new JButton("Menu");
		panelBotoiak.add(btnMenu);

		panelBotoiak.add(btnAurrekoa);
		JButton btnStartStop = new JButton("Play");

		panelBotoiak.add(btnStartStop);
		panelBotoiak.add(btnHurrengoa);
		btnStartStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!entzuten) {
					clip.start();
					btnStartStop.setText("Stop");
					entzuten = true;
				} else {
					clip.stop();
					btnStartStop.setText("Play");
					entzuten = false;
				}
			}
		});

		if (audioList.get(0).getClass().getSimpleName().equals("Abestia")) {
			Gustokoa gustokoAux = new Gustokoa(Aldagaiak.erabiltzailea, audioList.get(index));
			JButton btnGustokoa = new JButton();
			if (gustokoadao.gustokoaKonprobatu(gustokoAux)) {
				btnGustokoa.setText("✅");
			} else {
				btnGustokoa.setText("❎");
			}

			panelBotoiak.add(btnGustokoa);

			btnGustokoa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						if (gustokoadao.gustokoaGehiKen(gustokoAux)) {
							btnGustokoa.setText("❎");
							JOptionPane.showMessageDialog(null, "Gustokoetara gehituta", "",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							btnGustokoa.setText("✅");
							JOptionPane.showMessageDialog(null, "Gustokoetara kenduta", "",
									JOptionPane.INFORMATION_MESSAGE);

						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
		} else {

			JButton btnArindu = new JButton();
			btnArindu.setText(abiadura[abiaduraKont]);
			panelBotoiak.add(btnArindu);
			btnArindu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (abiaduraKont < abiadura.length-1) {
						abiaduraKont++;

					} else {
						abiaduraKont = 0;
					}
					btnArindu.setText(abiadura[abiaduraKont]);

				}
			});

		}

		JPanel panelInformazioa = new JPanel();
		panelFooter.add(panelInformazioa, BorderLayout.SOUTH);
		panelInformazioa.setLayout(new BorderLayout(0, 0));

		JTextPane textPaneInformazioa = new JTextPane();
		panelInformazioa.add(textPaneInformazioa);

		try {
			icon = new ImageIcon(
					audioList.get(index).getIrudia().getBytes(1, (int) audioList.get(index).getIrudia().length()));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JPanel panelIrudia = new JPanel();
		panelKontenidoa.add(panelIrudia, BorderLayout.CENTER);
		panelIrudia.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_5 = new JLabel("                    ");
		panelIrudia.add(lblNewLabel_5, BorderLayout.WEST);

		JLabel lblNewLabel_7 = new JLabel(" ");
		panelIrudia.add(lblNewLabel_7, BorderLayout.NORTH);

		JLabel lblNewLabel_6 = new JLabel("                    ");
		panelIrudia.add(lblNewLabel_6, BorderLayout.EAST);

		JPanel panelProgress = new JPanel();
		panelIrudia.add(panelProgress, BorderLayout.SOUTH);
		panelProgress.setLayout(new BorderLayout(0, 0));

		JProgressBar progressBar = new JProgressBar();
		panelProgress.add(progressBar, BorderLayout.CENTER);

		JLabel lblProgressNorth = new JLabel(" ");
		panelProgress.add(lblProgressNorth, BorderLayout.NORTH);

		JLabel lblProgressSouth = new JLabel(" ");
		panelProgress.add(lblProgressSouth, BorderLayout.SOUTH);

		JLabel lblProgressWest = new JLabel("                                                      ");
		panelProgress.add(lblProgressWest, BorderLayout.WEST);

		JLabel lblProgressEast = new JLabel("                                                      ");
		panelProgress.add(lblProgressEast, BorderLayout.EAST);

		lblIrudia.setHorizontalAlignment(SwingConstants.CENTER);
		lblIrudia.setIcon(icon);
		panelIrudia.add(lblIrudia, BorderLayout.CENTER);

		String[] stringAux = { "Musikaria", "Erreprodukzioa" };

		model = new DefaultTableModel();
		model.setColumnIdentifiers(stringAux);
		Object[] aux = new Object[2];
		for (int i = 0; i < musikariak.size(); i++) {
			aux[0] = musikariak.get(i).getIzen_Artistikoa();
			aux[1] = musikariak.get(i).getErreprodukzioak();

			model.addRow(aux);
		}

		btnHurrengoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Aldagaiak.skipSong) {
					Aldagaiak.skipSong = false;
					Funtzioak.skipBaimendu();
					int nextIndex = index + 1;
					if (nextIndex > audioList.size() - 1) {
						nextIndex = 0;
					}
					clip.close();
					dispose();
					FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());

					FuntzioBista.irekiErreprodukzioa(audioList, nextIndex);
				} else {
					JOptionPane.showMessageDialog(null, "Ez dira 10min pasatu", "", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAurrekoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Aldagaiak.skipSong) {
					Aldagaiak.skipSong = false;
					Funtzioak.skipBaimendu();
					int nextIndex = index - 1;
					if (nextIndex < 0) {
						nextIndex = audioList.size() - 1;
					}
					clip.close();
					dispose();
					FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());

					FuntzioBista.irekiErreprodukzioa(audioList, nextIndex);
				} else {
					JOptionPane.showMessageDialog(null, "Ez dira 10min pasatu", "", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}

}
