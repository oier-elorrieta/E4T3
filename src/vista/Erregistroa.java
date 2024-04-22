package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import control.funtzioak.FuntzioBista;
import control.funtzioak.Funtzioak;
import model.*;
import model.dao.BezeroDao;
import model.dao.HizkuntzaDao;
import model.objektuak.Hizkuntza;
import model.objektuak.bezero.Bezero;
import model.objektuak.bezero.Free;
import model.objektuak.bezero.Premium;

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
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
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
	
	BezeroDao bezerodao = new BezeroDao();
	HizkuntzaDao hizkuntzadao = new HizkuntzaDao();
	
	/**
	 * Framea sortzen duen metodoa.
	 * 
	 * @throws SQLException
	@SuppressWarnings({ "unchecked", "rawtypes" })*/
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
		lblAbizena.setBounds(251, 66, 46, 14);
		contentPane.add(lblAbizena);
		

		ArrayList<Hizkuntza> hizkuntzak = new ArrayList<Hizkuntza>();
		hizkuntzak = hizkuntzadao.getHizkuntzak();
		
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox<String> comboBoxHizkuntza = new JComboBox();
		
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
		for (int i = 0; i<= hizkuntzak.size()-1; i++) {
			modelo.addElement(hizkuntzak.get(i).getDeskribapena());
		}
        comboBoxHizkuntza.setModel(modelo);
        comboBoxHizkuntza.setSelectedIndex(0);
        comboBoxHizkuntza.setBounds(155, 249, 274, 22);
        contentPane.add(comboBoxHizkuntza);

		contentPane.add(comboBoxHizkuntza);
		
		final ArrayList<Hizkuntza> hizkuntzakFinal = new ArrayList<Hizkuntza>(hizkuntzak);
		

		contentPane.add(comboBoxHizkuntza);

		/**
		 * Aldaketak gordetzeko botoia. Sakatzen denean erabiltzaile hori datubasean
		 * gordetzen da.
		 */

		JButton btnGordeAldaketa = new JButton("Gorde aldaketa");
		btnGordeAldaketa.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {
				String izena = textFieldIzena.getText();
				String abizena = textFieldAbizena.getText();

				int indexHizkuntza = comboBoxHizkuntza.getSelectedIndex();
				String hizkuntza =  hizkuntzakFinal.get(indexHizkuntza).getID_Hizkuntza();

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
							bezerodao.erregistratuErabiltzailea(bezeroa);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
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
				JOptionPane.showMessageDialog(null, "Premium erosi duzu!", "", JOptionPane.INFORMATION_MESSAGE);
				
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
		textPanePremium.setBounds(155, 215, 274, 20);
		contentPane.add(textPanePremium);

		// Muga label
		JLabel lblMuga = new JLabel("Muga");
		lblMuga.setBounds(74, 227, 75, 14);
		contentPane.add(lblMuga);

	}
}
