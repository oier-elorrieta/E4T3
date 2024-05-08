package vista.bezeroa;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import control.funtzioak.FuntzioBista;
import control.funtzioak.Funtzioak;
import control.funtzioak.FuntzioakFitxategia;
import model.Aldagaiak;
import model.dao.*;
import model.objektuak.*;

import javax.swing.table.DefaultTableModel;;

public class Erreprodukzioa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel model;
	private boolean entzuten = true;
	JLabel lblIrudia = new JLabel("");
	/* audio variables */
	String filepath = "";
	Clip clip = null;
	AudioInputStream aui = null;
	File file = null;

	MusikariaDao musikariadao = new MusikariaDao();
	GustokoaDao gustokoadao = new GustokoaDao();
	ErreprodukzioaDao erreprodukzioadao = new ErreprodukzioaDao();
	ArrayList<Musikaria> musikariak = new ArrayList<Musikaria>();
	ImageIcon icon = null;

	private JButton btnAurrekoa = new JButton("⏮");
	private JButton btnHurrengoa = new JButton("⏭");
	private JPanel panelBotoiak = new JPanel();
	private String[] abiadura = { "x0.5", "x1", "x1.5", "x2" };
	private int abiaduraKont = 1;
//	private JProgressBar progressBar;
	private int entzundaAux = 0;
	private JLabel lblTimer;
	private int entzunda;
	private String userType = Aldagaiak.erabiltzailea.getClass().getSimpleName();
	private String time = "0:00";
	private String maxTime = "";
	
	private Timer timer;
	private TimerTask task;
	

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
		filepath = "\\\\10.5.6.220\\music\\" + audioList.get(index).getIzena() + ".wav";
		file = new File(filepath);
		aui = AudioSystem.getAudioInputStream(file.getAbsoluteFile());
		clip = AudioSystem.getClip();
		clip.open(aui);
		clip.start();
		
		maxTime = Funtzioak.longToString(clip.getMicrosecondLength());
		long tiempo = clip.getMicrosecondLength();
		tiempo = tiempo / 1000;
		
		timer = new Timer();

		task = new TimerTask() {
			public void run() {
				int nextIndex = index + 1;
				if (nextIndex > audioList.size() - 1) {
					nextIndex = 0;
				}
				if (Aldagaiak.iragarkia) {
					Aldagaiak.iragarkia = false;
				}else {
					Aldagaiak.iragarkia = true;
				}
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiErreprodukzioa(audioList, nextIndex);
				dispose();
			}
		};
		
		timer.schedule(task, tiempo);

		// Erabiltzailearen izena bistaratzeko botoia
		JButton btnPerfil = new JButton(Aldagaiak.erabiltzailea.getErabiltzaileIzena());
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clip.close();
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
				clip.close();
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

		JButton btnMenu = new JButton("≡");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Playlist", "Konpartitu" };
				int opcion = JOptionPane.showOptionDialog(null, "Zer egin nahi duzu", "", JOptionPane.DEFAULT_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (opcion == 0) {
					FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
					FuntzioBista.irekiMenuErreprodukzioa(audioList,index);
				} else if(opcion == 1) {
					try {
						FuntzioakFitxategia.audioKompartitu(audioList.get(index));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Fitxategia sortuta", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		panelBotoiak.add(btnMenu);

		panelBotoiak.add(btnAurrekoa);
		JButton btnStartStop = new JButton("⏸");

		panelBotoiak.add(btnStartStop);
		panelBotoiak.add(btnHurrengoa);
		btnStartStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!entzuten) {
					if(clip.getFramePosition() == 0) {
						try {
							erreprodukzioadao.erreprodukzioaGehitu(audioList.get(index));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					clip.start();
					long tiempo = clip.getMicrosecondLength() - clip.getMicrosecondPosition();
					tiempo = tiempo / 1000;
					timer = new Timer();

					task = new TimerTask() {
						public void run() {
							int nextIndex = index + 1;
							if (nextIndex > audioList.size() - 1) {
								nextIndex = 0;
							}
							if (Aldagaiak.iragarkia) {
								Aldagaiak.iragarkia = false;
							}else {
								Aldagaiak.iragarkia = true;
							}
							FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
							FuntzioBista.irekiErreprodukzioa(audioList, nextIndex);
							dispose();
						}
					};
					
					timer.schedule(task, tiempo);
					
					btnStartStop.setText("⏸");
					entzuten = true;
				
				} else {
					clip.stop();
					task.cancel();
					btnStartStop.setText("▶");
					time = Funtzioak.longToString(clip.getMicrosecondPosition());
					lblTimer.setText(time + "<----->" + maxTime);
					entzuten = false;
					entzunda = entzundaAux;
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
					if (abiaduraKont < abiadura.length - 1) {
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
		textPaneInformazioa.setText(
				"Izena: " + audioList.get(index).getIzena() + "\r\nIraupena: " + Funtzioak.secondsToString(audioList.get(index).getIraupena()));
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

		lblTimer = new JLabel(time + "<----->" + maxTime);
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		panelProgress.add(lblTimer, BorderLayout.CENTER);
		
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
				if (Aldagaiak.iragarkia && Aldagaiak.skipSong && userType.equals("Free")) {
					clip.close();
					Aldagaiak.skipSong = false;
					Funtzioak.skipBaimendu();
					Aldagaiak.iragarkia = false;
					int nextIndex = index + 1;
					if (nextIndex > audioList.size() - 1) {
						nextIndex = 0;
					}
					FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
					FuntzioBista.irekiIragarkia(audioList, index);
					dispose();
				} else {

					if (Aldagaiak.skipSong) {
			
						if(userType.equals("Free")) {
							Aldagaiak.iragarkia = true;
							Aldagaiak.skipSong = false;
							Funtzioak.skipBaimendu();
						}
						
						int nextIndex = index + 1;
						if (nextIndex > audioList.size() - 1) {
							nextIndex = 0;
						}
						clip.close();
						FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
						FuntzioBista.irekiErreprodukzioa(audioList, nextIndex);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Ez dira 10min pasatu", "", JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});
		btnAurrekoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Aldagaiak.iragarkia && Aldagaiak.skipSong && userType.equals("Free")) {
					clip.close();
					Aldagaiak.skipSong = false;
					Funtzioak.skipBaimendu();
					Aldagaiak.iragarkia = false;
					int nextIndex = index - 1;
					if (nextIndex < 0) {
						nextIndex = audioList.size() - 1;
					}
					FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
					FuntzioBista.irekiIragarkia(audioList, index);
					dispose();
				} else {
					if (Aldagaiak.skipSong) {
						
						if(userType.equals("Free")) {
							Aldagaiak.iragarkia = true;
							Aldagaiak.skipSong = false;
							Funtzioak.skipBaimendu();
						}
			
						int nextIndex = index - 1;
						if (nextIndex < 0) {
							nextIndex = audioList.size() - 1;
						}
						clip.close();
						FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
						FuntzioBista.irekiErreprodukzioa(audioList, nextIndex);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Ez dira 10min pasatu", "", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}

}
