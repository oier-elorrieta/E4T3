package vista.bezero;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.funtzioak.FuntzioBista;
import model.Aldagaiak;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class BezeroMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BezeroMenu frame = new BezeroMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BezeroMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitulua = new JLabel("Menu");
		lblTitulua.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulua.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel_1.add(lblTitulua);
		
		JButton btnPerfil = new JButton(Aldagaiak.erabiltzailea.getErabiltzaileIzena());
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiErregistroa();
				dispose();
			}
		});
		btnPerfil.setSize(325, 20);
		panel_1.add(btnPerfil, BorderLayout.EAST);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setSize(325, 20);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiLogin();
				dispose();
			}
		});
		panel_1.add(btnAtzera, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 20));
		
		JButton btnDeskubritu = new JButton("Musika deskubritu");
		btnDeskubritu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnDeskubritu);
		
		JButton btnPodcastDeskubritu = new JButton("Podcast dekubritu");
		btnPodcastDeskubritu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnPodcastDeskubritu);
		
		JButton btnPlayList = new JButton("Nire PlayList-ak");
		btnPlayList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnPlayList);
		panel_2.add(panel);
		
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