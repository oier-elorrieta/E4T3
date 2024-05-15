package vista.admin;


import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Aldagaiak;
import model.objektuak.Album;
import model.objektuak.Audio;
import model.objektuak.Musikaria;
import vista.bezeroa.playlist.NirePlaylist;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class EditAbestia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public EditAbestia(Audio audio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(NirePlaylist.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelKontenidoa = new JPanel();
		contentPane.add(panelKontenidoa, BorderLayout.CENTER);
		panelKontenidoa.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelLabel = new JPanel();
		panelKontenidoa.add(panelLabel);
		panelLabel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblIzena = new JLabel("Izena:  ");
		lblIzena.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabel.add(lblIzena);
		
		JLabel lblNewLabel_1 = new JLabel("Iraupena:  ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Deskribapena:  ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabel.add(lblNewLabel_2);
		
		JPanel panelTextField = new JPanel();
		panelKontenidoa.add(panelTextField);
		
		textField = new JTextField();
		panelTextField.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		panelTextField.add(textField_2);
		textField_2.setColumns(10);
		
		textField_1 = new JTextField();
		panelTextField.add(textField_1);
		textField_1.setColumns(10);
		
		
	}
}

