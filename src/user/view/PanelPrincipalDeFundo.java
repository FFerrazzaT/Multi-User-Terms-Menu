package view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelPrincipalDeFundo extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelPrincipalDeFundo() {
		setBackground(Color.BLACK);
		setLayout(new CardLayout(0, 0));

	}

}
