package vista.interfaseak;

import javax.swing.*;

import java.awt.BorderLayout;

public class Header extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public static JPanel header() {
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout(0, 0));
		
		
		JButton btnPerfil = new JButton((String) null);
		panel_1.add(btnPerfil, BorderLayout.EAST);
		
		JButton btnAtzera = new JButton("Atzera");
		panel_1.add(btnAtzera, BorderLayout.WEST);
		
		return panel_1;
	}
	


}
