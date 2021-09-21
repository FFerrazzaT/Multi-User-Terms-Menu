package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import net.miginfocom.swing.MigLayout;


@SuppressWarnings({ "serial" })
public class TelaConcedente extends JPanel {
	private JTextField fieldRazaoSocial;
	private JTextField fieldNomeRepre;
	private JTextField fieldCargoRepre;
	private JTextField fieldEndereco;
	private JTextField FieldBairro;
	private JTextField fieldCidade;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaConcedente() {
		setBackground(new Color(176, 224, 230));
		setLayout(new MigLayout("", "[::180,left][250][150][150,grow,right]", "[::5][35][10][30][30][30][30][30][30][30][30][30][][40]"));
		setBounds(100, 100, 750, 500);

		JLabel lblTituloConcedente = new JLabel("Concedente");
		lblTituloConcedente.setBackground(Color.WHITE);
		lblTituloConcedente.setIcon(new ImageIcon(TelaConcedente.class.getResource("/icons/Company.png")));
		lblTituloConcedente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblTituloConcedente, "cell 0 1 4 1");

		JSeparator separator_1 = new JSeparator();
		separator_1.setLocation(new Point(0, 1));
		separator_1.setForeground(Color.DARK_GRAY);
		add(separator_1, "cell 0 2 4 1,growx");

		JLabel labelNomeDoRepresentante = new JLabel("Nome do Representante:");
		labelNomeDoRepresentante.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelNomeDoRepresentante, "flowx,cell 0 3,alignx right,aligny center");

		fieldNomeRepre = new JTextField();
		labelNomeDoRepresentante.setLabelFor(fieldNomeRepre);
		add(fieldNomeRepre, "cell 1 3 2 1,growx,aligny center");
		fieldNomeRepre.setColumns(10);

		JLabel labelCnpj = new JLabel("CNPJ: ");
		labelCnpj.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCnpj, "flowx,cell 3 3,alignx left,aligny center");

		JLabel labelCargoDoRepre = new JLabel("Cargo do Representante:");
		labelCargoDoRepre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCargoDoRepre, "cell 0 4,alignx right,aligny center");

		fieldCargoRepre = new JTextField();
		add(fieldCargoRepre, "cell 1 4,growx,aligny center");
		fieldCargoRepre.setColumns(10);

		JLabel labelTelefone = new JLabel("Telefone:");
		labelTelefone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelTelefone, "cell 2 4,alignx trailing,aligny center");

		JFormattedTextField formattedTelefoneConcedente = new JFormattedTextField();
		add(formattedTelefoneConcedente, "cell 3 4,growx");

		//mascara
			MaskFormatter mascaraTelefone = null;
			try {
				mascaraTelefone = new MaskFormatter("(##) 9####-####");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mascaraTelefone.install(formattedTelefoneConcedente);
		/////////

		JLabel labelRazaoSocial = new JLabel("Raz\u00E3o Social:");
		labelRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelRazaoSocial, "cell 0 5,alignx right,aligny center");
		labelRazaoSocial.setLabelFor(fieldRazaoSocial);

		fieldRazaoSocial = new JTextField();
		add(fieldRazaoSocial, "cell 1 5 2 1,growx,aligny center");
		fieldRazaoSocial.setColumns(10);

		JLabel labelEndereco = new JLabel("Endere\u00E7o:");
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelEndereco, "cell 0 7,alignx right,aligny center");

		fieldEndereco = new JTextField();
		labelEndereco.setLabelFor(fieldEndereco);
		add(fieldEndereco, "cell 1 7 2 1,growx");
		fieldEndereco.setColumns(10);

		JLabel labelEstado = new JLabel("Estado:");
		labelEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelEstado, "flowx,cell 3 7,alignx center,aligny center");

		JComboBox comboEstado = new JComboBox();
		comboEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboEstado.setModel(new DefaultComboBoxModel(new String[] {"-", "Acre (AC)", "Alagoas (AL)", "Amap\u00E1 (AP)", "Amazonas (AM)", "Bahia (BH)", "Cear\u00E1 (CE)", "Distrito Federal (DF)", "Esp\u00EDrito Santo (ES) ", "Goi\u00E1s (GO)", "Maranh\u00E3o (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Par\u00E1 (PA)", "Para\u00EDba (PB)", "Paran\u00E1 (PR)", "Pernambuco (PE)", "Piau\u00ED (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rond\u00F4nia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "S\u00E3o Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
		comboEstado.setAlignmentX(1.0f);
		add(comboEstado, "cell 3 7,alignx center,aligny center");

		JLabel labelCidade = new JLabel("Cidade:");
		labelCidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCidade, "cell 0 8,alignx right,growy");

		fieldCidade = new JTextField();
		add(fieldCidade, "cell 1 8,growx");
		fieldCidade.setColumns(10);

		JLabel labelCep = new JLabel("CEP:");
		labelCep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCep, "flowx,cell 2 8,alignx trailing,aligny center");

		JFormattedTextField formattedCEPCurso = new JFormattedTextField();
		add(formattedCEPCurso, "cell 3 8,growx");

		//mascara
		MaskFormatter mascaraCEP = null;
			try {
				mascaraCEP = new MaskFormatter("#####-###");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		mascaraCEP.install(formattedCEPCurso);
		/////////

		JLabel labelBairro = new JLabel("Bairro:");
		labelBairro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelBairro, "cell 0 9,alignx right");

		FieldBairro = new JTextField();
		FieldBairro.setColumns(10);
		add(FieldBairro, "cell 1 9 2 1,growx");

		JButton buttonLimparTela = new JButton("Limpar Tela");
		buttonLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonLimparTela.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonLimparTela.setIcon(new ImageIcon(TelaConcedente.class.getResource("/icons/37263_monitor_erase_icon.png")));
		add(buttonLimparTela, "cell 3 10,alignx center,growy");

		JLabel lblNewLabel_1 = new JLabel("Opera\u00E7\u00F5es");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setIcon(new ImageIcon(TelaConcedente.class.getResource("/icons/Database.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_1, "cell 0 12 4 1,alignx center");

		JToolBar toolBarOpCRUDConcedente = new JToolBar();
		toolBarOpCRUDConcedente.setBackground(new Color(135, 206, 250));
		toolBarOpCRUDConcedente.setRollover(true);
		toolBarOpCRUDConcedente.setEnabled(false);
		toolBarOpCRUDConcedente.setFloatable(false);
		add(toolBarOpCRUDConcedente, "cell 0 13 4 1,grow");

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalStrut_3.setBackground(new Color(135, 206, 250));
		toolBarOpCRUDConcedente.add(verticalStrut_3);

		JButton buttonCriarConcedente = new JButton("  Criar  ");
		buttonCriarConcedente.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonCriarConcedente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		buttonCriarConcedente.setToolTipText("");
		buttonCriarConcedente.setBackground(new Color(220, 220, 220));
		toolBarOpCRUDConcedente.add(buttonCriarConcedente);
		buttonCriarConcedente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		buttonCriarConcedente.setIcon(new ImageIcon(TelaConcedente.class.getResource("/icons/Create.png")));

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		toolBarOpCRUDConcedente.add(verticalStrut_2);

		JButton butonLerConcedente = new JButton("  Ler  ");
		butonLerConcedente.setAlignmentX(Component.CENTER_ALIGNMENT);
		butonLerConcedente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		butonLerConcedente.setBackground(new Color(220, 220, 220));
		toolBarOpCRUDConcedente.add(butonLerConcedente);
		butonLerConcedente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		butonLerConcedente.setIcon(new ImageIcon(TelaConcedente.class.getResource("/icons/List.png")));

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		toolBarOpCRUDConcedente.add(verticalStrut_1);

		JButton buttonFazerUpConcedente = new JButton("  Atualizar  ");
		buttonFazerUpConcedente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		buttonFazerUpConcedente.setBackground(new Color(220, 220, 220));
		buttonFazerUpConcedente.setAlignmentX(Component.CENTER_ALIGNMENT);
		toolBarOpCRUDConcedente.add(buttonFazerUpConcedente);
		buttonFazerUpConcedente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		buttonFazerUpConcedente.setIcon(new ImageIcon(TelaConcedente.class.getResource("/icons/Download.png")));

		Component verticalStrut = Box.createVerticalStrut(20);
		toolBarOpCRUDConcedente.add(verticalStrut);

		JButton buttonRemoverConcedente = new JButton("  Remover  ");
		buttonRemoverConcedente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		buttonRemoverConcedente.setBackground(new Color(220, 220, 220));
		toolBarOpCRUDConcedente.add(buttonRemoverConcedente);
		buttonRemoverConcedente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		buttonRemoverConcedente.setIcon(new ImageIcon(TelaConcedente.class.getResource("/icons/Remove.png")));

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		toolBarOpCRUDConcedente.add(verticalStrut_4);

		JFormattedTextField formattedCNPJConcedente = new JFormattedTextField();
		add(formattedCNPJConcedente, "cell 3 3,growx");

		//mascara
		MaskFormatter mascaraCNPJ = null;
			try {
				mascaraCNPJ = new MaskFormatter("##.###.###/0001-##.");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		mascaraCNPJ.install(formattedCNPJConcedente);
		/////////

		buttonRemoverConcedente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});


	}

}
