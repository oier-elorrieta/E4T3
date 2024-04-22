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

import java.util.ArrayList;

import java.time.LocalDate;

import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JTextPane;

/**
 * Erregistroaren ikuspegia erakusten duen klasea.
 */
public class Erregistroa extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldAbizena;
	private JTextField textFieldJaioData;
	private JTextField textFieldIzena;
	private JTextField textFieldErabiltzailea;
	private JPasswordField passwordFieldPasahitza;
	private JPasswordField passwordFieldKonfirmatu;
	private boolean prime = false;

	/**
	 * Aplikazioa abiarazten duen metodoa.
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
	 * Framea sortzen duen metodoa.
	 * 
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

		textFieldJaioData = new JTextField();
		textFieldJaioData.setColumns(10);
		textFieldJaioData.setBounds(173, 187, 256, 20);
		contentPane.add(textFieldJaioData);

		textFieldIzena = new JTextField();
		textFieldIzena.setColumns(10);
		textFieldIzena.setBounds(173, 63, 86, 20);
		contentPane.add(textFieldIzena);

		textFieldErabiltzailea = new JTextField();
		textFieldErabiltzailea.setColumns(10);
		textFieldErabiltzailea.setBounds(173, 94, 256, 20);
		contentPane.add(textFieldErabiltzailea);

		// Izenaren label
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(72, 66, 46, 14);
		contentPane.add(lblIzena);

		// Erabiltzailearen label
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea:");
		lblErabiltzailea.setBounds(72, 97, 61, 14);
		contentPane.add(lblErabiltzailea);

		// Pasahitzaren label
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(72, 128, 61, 14);
		contentPane.add(lblPasahitza);

		// Konfirmatzeko label
		JLabel lblKonfirmatu = new JLabel("Konfirmatu:");
		lblKonfirmatu.setBounds(72, 159, 61, 14);
		contentPane.add(lblKonfirmatu);

		// JaioData label
		JLabel lblJaiodata = new JLabel("Jaio-Data:");
		lblJaiodata.setBounds(72, 190, 61, 14);
		contentPane.add(lblJaiodata);

		// Premium label
		JLabel lblPremiummuga = new JLabel("Premium");
		lblPremiummuga.setBounds(72, 214, 75, 14);
		contentPane.add(lblPremiummuga);

		// Hizkuntza label
		JLabel lblHitz = new JLabel("Hizkuntza:");
		lblHitz.setBounds(72, 253, 75, 14);
		contentPane.add(lblHitz);

		// Abizena label
		JLabel lblAbizena = new JLabel("Abizena:");
		lblAbizena.setBounds(269, 66, 46, 14);
		contentPane.add(lblAbizena);

		passwordFieldPasahitza = new JPasswordField();
		passwordFieldPasahitza.setBounds(173, 125, 256, 20);
		contentPane.add(passwordFieldPasahitza);

		passwordFieldKonfirmatu = new JPasswordField();
		passwordFieldKonfirmatu.setBounds(173, 156, 256, 20);
		contentPane.add(passwordFieldKonfirmatu);

		JComboBox comboBoxHizkuntza = new JComboBox();
		comboBoxHizkuntza.setModel(new DefaultComboBoxModel(new String[] { "ES", "EU", "EN", "FR", "DE", "CA", "GA", "AR" }));
		comboBoxHizkuntza.setBounds(173, 249, 256, 22);
		contentPane.add(comboBoxHizkuntza);

		contentPane.add(comboBoxHizkuntza);

		/**
		 * Aldaketak gordetzeko botoia. Sakatzen denean erabiltzaile hori datubasean
		 * gordetzen da.
		 */
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
						bezeroa = new Premium(izena, abizena, hizkuntza, erabiltzailea, pasahitza, noizData, noizData,
								noizData);
					} else {
						bezeroa = new Free(izena, abizena, hizkuntza, erabiltzailea, pasahitza, noizData, noizData);
					}
					try {
						DB_funtzioak.erregistratuErabiltzailea(bezeroa);
					} catch (SQLException e1) {
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

		// Erregistro label
		JLabel lblTitulua = new JLabel("Erregistro");
		lblTitulua.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulua.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulua.setBounds(199, 11, 129, 41);
		contentPane.add(lblTitulua);

		// Atzera botoia. Aurreko pantailara joaten da.
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

		JTextPane textPanePremium = new JTextPane();
		textPanePremium.setEditable(false);
		textPanePremium.setBounds(173, 215, 256, 20);
		contentPane.add(textPanePremium);

		// Muga label
		JLabel lblMuga = new JLabel("Muga");
		lblMuga.setBounds(74, 227, 75, 14);
		contentPane.add(lblMuga);

	}
}
