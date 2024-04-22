package vista;

import java.awt.Event;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import control.funtzioak.FuntzioBista;
import control.funtzioak.Funtzioak;
import model.*;
import model.db.*;
import model.objektuak.Bezero;
import model.objektuak.Free;
import model.objektuak.Hizkuntza;
import model.objektuak.Premium;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.time.LocalDate;
>>>>>>> 5d43cbc3a64db8493869ab66972fa8fbb71948f9
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Erregistroa extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldAbizena;
	private JTextField textField_6;
	private JTextField textFieldIzena;
	private JTextField textField_8;
	private JTextField textFieldErabiltzailea;
	private JPasswordField passwordFieldPasahitza;
	private JPasswordField passwordFieldKonfirmatu;
	private boolean prime = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Erregistroa frame = new Erregistroa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Erregistroa() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, 550, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldAbizena = new JTextField();
		textFieldAbizena.setBounds(343, 63, 86, 20);
		contentPane.add(textFieldAbizena);
		textFieldAbizena.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(173, 187, 256, 20);
		contentPane.add(textField_6);
		
		textFieldIzena = new JTextField();
		textFieldIzena.setColumns(10);
		textFieldIzena.setBounds(173, 63, 86, 20);
		contentPane.add(textFieldIzena);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(173, 218, 256, 20);
		contentPane.add(textField_8);
		
		textFieldErabiltzailea = new JTextField();
		textFieldErabiltzailea.setColumns(10);
		textFieldErabiltzailea.setBounds(173, 94, 256, 20);
		contentPane.add(textFieldErabiltzailea);
		
		JLabel lblNewLabel = new JLabel("Izena:");
		lblNewLabel.setBounds(88, 66, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea:");
		lblErabiltzailea.setBounds(88, 97, 61, 14);
		contentPane.add(lblErabiltzailea);
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(88, 128, 61, 14);
		contentPane.add(lblPasahitza);
		
		JLabel lblKonfirmatu = new JLabel("Konfirmatu:");
		lblKonfirmatu.setBounds(88, 159, 61, 14);
		contentPane.add(lblKonfirmatu);
		
		JLabel lblJaiodata = new JLabel("Jaio-Data:");
		lblJaiodata.setBounds(88, 190, 61, 14);
		contentPane.add(lblJaiodata);
		
		JLabel lblPremiummuga = new JLabel("Premium-Muga:");
		lblPremiummuga.setBounds(88, 221, 75, 14);
		contentPane.add(lblPremiummuga);
		
		JLabel lblHitz = new JLabel("Hizkuntza:");
		lblHitz.setBounds(88, 246, 75, 14);
		contentPane.add(lblHitz);
		
		JLabel lblAbizena = new JLabel("Abizena:");
		lblAbizena.setBounds(287, 66, 46, 14);
		contentPane.add(lblAbizena);
		
		passwordFieldPasahitza = new JPasswordField();
		passwordFieldPasahitza.setBounds(173, 125, 256, 20);
		contentPane.add(passwordFieldPasahitza);
		
		passwordFieldKonfirmatu = new JPasswordField();
		passwordFieldKonfirmatu.setBounds(173, 156, 256, 20);
		contentPane.add(passwordFieldKonfirmatu);
		


		JComboBox comboBoxHizkuntza = new JComboBox();
        comboBoxHizkuntza.setModel(new DefaultComboBoxModel(new String[] {"ES", "EU", "EN", "FR", "DE", "CA", "GA", "AR"}));
        comboBoxHizkuntza.setBounds(173, 249, 256, 22);
        contentPane.add(comboBoxHizkuntza);

		contentPane.add(comboBoxHizkuntza);
		
		JButton btnGordeAldaketa = new JButton("Gorde aldaketa");
		btnGordeAldaketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String izena = textFieldIzena.getText();
				String abizena = textFieldAbizena.getText();
				String hizkuntza = (String) comboBoxHizkuntza.getSelectedItem();
		
				String erabiltzailea = textFieldErabiltzailea.getText();
				String pasahitza = passwordFieldPasahitza.getText();
				String konfirmazioa = passwordFieldKonfirmatu.getText();
				Date noizData = new Date();
				if (pasahitza.equals(konfirmazioa)) {
					pasahitza = Funtzioak.enkriptatzailea(pasahitza);
					Bezero bezeroa;
					if (prime) {
						bezeroa = new Premium(izena, abizena, hizkuntza, erabiltzailea, pasahitza, noizData, noizData, noizData);
					} else {
						bezeroa = new Free(izena, abizena, hizkuntza, erabiltzailea, pasahitza, noizData, noizData);
					}
					try {
						DB_funtzioak.erregistratuErabiltzailea(bezeroa);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnGordeAldaketa.setBounds(25, 309, 120, 41);
		contentPane.add(btnGordeAldaketa);
		
		JButton btnPrime = new JButton("Erosi Premium");
		btnPrime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prime = true;
			}
		});
		btnPrime.setBounds(388, 309, 120, 41);
		contentPane.add(btnPrime);
		
		JLabel lblTitulua = new JLabel("Erregistro");
		lblTitulua.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulua.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulua.setBounds(199, 11, 129, 41);
		contentPane.add(lblTitulua);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiLogin();
				dispose();
			}
		});
		btnAtzera.setBounds(10, 11, 89, 23);
		contentPane.add(btnAtzera);
		
	
		 });
		
	}
}



