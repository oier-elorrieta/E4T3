package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import control.funtzioak.FuntzioBista;
import control.funtzioak.Funtzioak;
import model.*;
import model.db.*;
import model.objektuak.Bezero;
import model.objektuak.Free;
import model.objektuak.Premium;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

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
	 * Create the frame.
	 * @throws SQLException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Erregistroa() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, 550, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldIzena = new JTextField();
		textFieldIzena.setColumns(10);
		textFieldIzena.setBounds(155, 63, 86, 20);
		contentPane.add(textFieldIzena);
		
		textFieldAbizena = new JTextField();
		textFieldAbizena.setBounds(324, 63, 105, 20);
		contentPane.add(textFieldAbizena);
		textFieldAbizena.setColumns(10);
		
		textFieldErabiltzailea = new JTextField();
		textFieldErabiltzailea.setColumns(10);
		textFieldErabiltzailea.setBounds(155, 94, 274, 20);
		contentPane.add(textFieldErabiltzailea);
		
		passwordFieldPasahitza = new JPasswordField();
		passwordFieldPasahitza.setBounds(155, 125, 274, 20);
		contentPane.add(passwordFieldPasahitza);
		
		passwordFieldKonfirmatu = new JPasswordField();
		passwordFieldKonfirmatu.setBounds(155, 156, 274, 20);
		contentPane.add(passwordFieldKonfirmatu);
		
		textFieldJaioData = new JTextField();
		textFieldJaioData.setColumns(10);
		textFieldJaioData.setBounds(155, 187, 274, 20);
		contentPane.add(textFieldJaioData);
		
		
		JLabel lblNewLabel = new JLabel("Izena:");
		lblNewLabel.setBounds(72, 66, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea:");
		lblErabiltzailea.setBounds(72, 97, 61, 14);
		contentPane.add(lblErabiltzailea);
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(72, 128, 61, 14);
		contentPane.add(lblPasahitza);
		
		JLabel lblKonfirmatu = new JLabel("Konfirmatu:");
		lblKonfirmatu.setBounds(72, 159, 61, 14);
		contentPane.add(lblKonfirmatu);
		
		JLabel lblJaiodata = new JLabel("Jaio-Data:");
		lblJaiodata.setBounds(72, 190, 61, 14);
		contentPane.add(lblJaiodata);
		
		JLabel lblPremiummuga = new JLabel("Premium");
		lblPremiummuga.setBounds(72, 214, 75, 14);
		contentPane.add(lblPremiummuga);
		
		JLabel lblHitz = new JLabel("Hizkuntza:");
		lblHitz.setBounds(72, 253, 75, 14);
		contentPane.add(lblHitz);
		
		JLabel lblAbizena = new JLabel("Abizena:");
		lblAbizena.setBounds(251, 66, 46, 14);
		contentPane.add(lblAbizena);
		

		JComboBox comboBoxHizkuntza = new JComboBox();
        comboBoxHizkuntza.setModel(new DefaultComboBoxModel(new String[] {"ES", "EU", "EN", "FR", "DE", "CA", "GA", "AR"}));
        comboBoxHizkuntza.setBounds(155, 249, 274, 22);
        contentPane.add(comboBoxHizkuntza);

		contentPane.add(comboBoxHizkuntza);
		
		JButton btnGordeAldaketa = new JButton("Gorde aldaketa");
		btnGordeAldaketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String izena = textFieldIzena.getText();
				String abizena = textFieldAbizena.getText();
				String hizkuntza = (String) comboBoxHizkuntza.getSelectedItem();
		
				String erabiltzailea = textFieldErabiltzailea.getText();
				@SuppressWarnings("deprecation")
				String pasahitza = passwordFieldPasahitza.getText();
				@SuppressWarnings("deprecation")
				String konfirmazioa = passwordFieldKonfirmatu.getText();
				Date noizData = new Date();
				
				if (izena.equals("") || abizena.equals("") || hizkuntza.equals("") || pasahitza.equals("") || konfirmazioa.equals("") || noizData.equals("")) {
					JOptionPane.showMessageDialog(null, "¡Error! Eremu guztiak beteta egon behar dira.", "", JOptionPane.ERROR_MESSAGE);
				} else {
					if (pasahitza.equals(konfirmazioa)) {
						JOptionPane.showMessageDialog(null, "Dena ondo gorde da!", "", JOptionPane.INFORMATION_MESSAGE);
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
					} else {
						JOptionPane.showMessageDialog(null, "¡Error! Pasahitzek bat etorri behar dute.", "", JOptionPane.ERROR_MESSAGE);
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


		JTextPane textPanePremium = new JTextPane();
		textPanePremium.setEditable(false);
		textPanePremium.setBounds(155, 215, 274, 20);
		contentPane.add(textPanePremium);
		
		JLabel lblMuga = new JLabel("Muga");
		lblMuga.setBounds(74, 227, 75, 14);
		contentPane.add(lblMuga);
		

		
	}
}



