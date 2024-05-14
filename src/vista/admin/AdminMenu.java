package vista.admin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import control.funtzioak.FuntzioBista;
import model.Aldagaiak;

import java.awt.*;
import java.awt.event.*;

// Bezeroaren menua bistaratzeko klasea
public class AdminMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// Frame-a sortzeko konstruktorea
	public AdminMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminMenu.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// Goiko panela
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		// Titulua
		JLabel lblTitulua = new JLabel("Kudeaketa menua");
		lblTitulua.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulua.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel_1.add(lblTitulua);

		// Erabiltzailearen izena bistaratzeko botoia

		// Atzera botoia
		JButton btnAtzera = new JButton("Log out");
		btnAtzera.setSize(325, 20);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiLogin();
				dispose();
			}
		});
		panel_1.add(btnAtzera, BorderLayout.WEST);

		// Erdiko panela
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		// Menua
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 20));

		// Musika deskubritzeko botoia
		JButton btnMusKudeatu  = new JButton("Musika kudeatu");
		


		// Podcast deskubritzeko botoia
		JButton btnPodKudeatu = new JButton("Podcast kudeatu");
		
		

		// Nire PlayList-ak bistaratzeko botoia
		JButton btnEstatistikak = new JButton("Estatistikak");
		
		
		panel_2.add(panel);

		// Espazio hutsak menuaren inguruan
		JLabel lblSeparatzaileTOP = new JLabel(" ");
		panel_2.add(lblSeparatzaileTOP, BorderLayout.NORTH);

		JLabel lblSeparatzaileWest = new JLabel("    ");
		panel_2.add(lblSeparatzaileWest, BorderLayout.WEST);

		JLabel lblSeparatzaileEast = new JLabel("    ");
		panel_2.add(lblSeparatzaileEast, BorderLayout.EAST);

		JLabel lblSeparatzaileSouth = new JLabel(" ");
		panel_2.add(lblSeparatzaileSouth, BorderLayout.SOUTH);
		
		btnMusKudeatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiMusikaKudeatu();
				dispose();
			}
		});
		
		btnPodKudeatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiPodcastKudeatu();
				dispose();
			}
		});
		
		btnEstatistikak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiNireEstatistikak();
				dispose();
			}
		});
		
		panel.add(btnMusKudeatu);
		panel.add(btnPodKudeatu);
		panel.add(btnEstatistikak);
	}

}
