package vista.bezeroa;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.funtzioak.FuntzioBista;
import model.Aldagaiak;
import model.dao.MusikariaDao;
import model.dao.PodcasterDao;
import model.objektuak.Musikaria;
import model.objektuak.Podcaster;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PodcastDeskubritu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	PodcasterDao podcasterdao = new PodcasterDao();

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PodcastDeskubritu() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PodcastDeskubritu.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		ArrayList<Podcaster> podcasters = new ArrayList<Podcaster>();
	
		
		/* 	ARRAY DE PODCASTERS PARA RELLENAR EL VIEW, NOMBRE Y REPODUCCIONES, STRING, INT */
		podcasters = podcasterdao.getPodcaster();
		
		/* TO DELETE */ System.out.println(podcasters);

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
		panel.add(btnPerfil, BorderLayout.EAST);

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
		panel.add(btnAtzera, BorderLayout.WEST);

		JLabel lblNewLabel = new JLabel("Podcast deskubritu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);

	}

}
