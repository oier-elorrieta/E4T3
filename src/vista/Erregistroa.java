package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Aldagaiak;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Erregistroa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

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
	 */
	public Erregistroa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, 550, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(280, 22, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(110, 84, 256, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(110, 115, 256, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(110, 177, 256, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(110, 239, 256, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(110, 146, 256, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(110, 22, 86, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(110, 208, 256, 20);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(110, 53, 256, 20);
		contentPane.add(textField_9);
		
		JLabel lblNewLabel = new JLabel("Izena:");
		lblNewLabel.setBounds(25, 25, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea:");
		lblErabiltzailea.setBounds(25, 56, 61, 14);
		contentPane.add(lblErabiltzailea);
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(25, 87, 61, 14);
		contentPane.add(lblPasahitza);
		
		JLabel lblKonfirmatu = new JLabel("Konfirmatu:");
		lblKonfirmatu.setBounds(25, 118, 61, 14);
		contentPane.add(lblKonfirmatu);
		
		JLabel lblJaiodata = new JLabel("Jaio-Data:");
		lblJaiodata.setBounds(25, 149, 61, 14);
		contentPane.add(lblJaiodata);
		
		JLabel lblErregistrodata = new JLabel("Erregistro-Data");
		lblErregistrodata.setBounds(25, 180, 75, 14);
		contentPane.add(lblErregistrodata);
		
		JLabel lblPremiummuga = new JLabel("Premium-Muga:");
		lblPremiummuga.setBounds(25, 211, 75, 14);
		contentPane.add(lblPremiummuga);
		
		JLabel lblHitz = new JLabel("Hizkuntza:");
		lblHitz.setBounds(25, 242, 75, 14);
		contentPane.add(lblHitz);
		
		JLabel lblAbizena = new JLabel("Abizena:");
		lblAbizena.setBounds(224, 25, 46, 14);
		contentPane.add(lblAbizena);
	}
}
