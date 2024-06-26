package vista.interfaseak;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.Aldagaiak;

import java.awt.*;
import java.awt.event.*;

// Bezeroaren menua bistaratzeko klasea
public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// Frame-a sortzeko konstruktorea
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel1 = Header.header();
		contentPane.add(panel1, BorderLayout.NORTH);
		panel1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitulua = new JLabel("Menu");
		lblTitulua.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulua.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel1.add(lblTitulua, BorderLayout.CENTER);
		
		// Erdiko panela
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		// Menua
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 20));

		// Musika deskubritzeko botoia
		JButton btnDeskubritu = new JButton("Musika deskubritu");
		btnDeskubritu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnDeskubritu);

		// Podcast deskubritzeko botoia
		JButton btnPodcastDeskubritu = new JButton("Podcast dekubritu");
		btnPodcastDeskubritu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnPodcastDeskubritu);

		// Nire PlayList-ak bistaratzeko botoia
		JButton btnPlayList = new JButton("Nire PlayList-ak");
		btnPlayList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnPlayList);
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
	}

}
