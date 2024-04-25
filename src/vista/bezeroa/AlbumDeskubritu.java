package vista.bezeroa;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import control.funtzioak.FuntzioBista;
import model.Aldagaiak;
import model.objektuak.Musikaria;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JTextPane;

public class AlbumDeskubritu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	
	/**
	 * Create the frame.
	 */
	public AlbumDeskubritu(Musikaria musikaria) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MusikaDeskubritu.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		

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
				FuntzioBista.irekiMusikaDeskubritu();
				dispose();
			}
		});
		panel.add(btnAtzera, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel(musikaria.getIzen_Artistikoa() + "-aren Albumak");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		panel_2.add(table, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		panel_2.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		panel_2.add(lblNewLabel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_3 = new JLabel("      ");
		panel_2.add(lblNewLabel_3, BorderLayout.WEST);
		
		JLabel lblNewLabel_4 = new JLabel("      ");
		panel_2.add(lblNewLabel_4, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JTextPane textPaneDeskripzioa = new JTextPane();
		textPaneDeskripzioa.setText("Mota: " + musikaria.getEzaugarria() + "\n" + musikaria.getDeskribapena());
		panel_4.add(textPaneDeskripzioa, BorderLayout.CENTER);
		
		JLabel lblNewLabel_5 = new JLabel(" ");
		panel_4.add(lblNewLabel_5, BorderLayout.NORTH);
		
		JLabel lblNewLabel_6 = new JLabel(" ");
		panel_4.add(lblNewLabel_6, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_7 = new JLabel("      ");
		panel_4.add(lblNewLabel_7, BorderLayout.WEST);
		
		JLabel lblNewLabel_8 = new JLabel("      ");
		panel_4.add(lblNewLabel_8, BorderLayout.EAST);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblIrudia = new JLabel("");
		panel_5.add(lblIrudia, BorderLayout.CENTER);
		
		JLabel lblNewLabel_10 = new JLabel(" ");
		panel_5.add(lblNewLabel_10, BorderLayout.NORTH);
		
		JLabel lblNewLabel_11 = new JLabel("      ");
		panel_5.add(lblNewLabel_11, BorderLayout.WEST);
		
		JLabel lblNewLabel_12 = new JLabel(" ");
		panel_5.add(lblNewLabel_12, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_13 = new JLabel("      ");
		panel_5.add(lblNewLabel_13, BorderLayout.EAST);
	}
}
