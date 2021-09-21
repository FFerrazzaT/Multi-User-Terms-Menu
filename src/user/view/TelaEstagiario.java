package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
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
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import net.miginfocom.swing.MigLayout;


@SuppressWarnings({ "serial" })
public class TelaEstagiario extends JPanel {
	private JTextField fieldEndereco;
	private JTextField fieldCurso;
	private JTextField fieldNomeEstagiario;
	private JTextField fieldCidade;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaEstagiario() {
		setBackground(new Color(255, 204, 204));
		setLayout(new MigLayout("", "[::183px][364][185][185,grow]", "[::5][35][::10][30][30][30][30][30][30][30][30][30][30][40][40]"));
		setBounds(100, 100, 850, 500);

		JLabel lblTituloCurso = new JLabel("Estagi\u00E1rio");
		lblTituloCurso.setIcon(new ImageIcon(TelaEstagiario.class.getResource("/icons/User group.png")));
		lblTituloCurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloCurso.setBackground(Color.WHITE);
		add(lblTituloCurso, "cell 0 1");

		JSeparator separator_1 = new JSeparator();
		separator_1.setLocation(new Point(0, 1));
		separator_1.setForeground(Color.DARK_GRAY);
		add(separator_1, "cell 0 2 4 1,growx");

		JLabel labelNomeEstagiario = new JLabel("Nome:");
		labelNomeEstagiario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelNomeEstagiario, "cell 0 3,alignx right");

		fieldNomeEstagiario = new JTextField();
		add(fieldNomeEstagiario, "flowx,cell 1 3,growx");
		fieldNomeEstagiario.setColumns(10);

		JLabel labelSexo = new JLabel("Sexo:");
		labelSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelSexo, "flowx,cell 2 3,alignx trailing,aligny center");

		JFormattedTextField formattedCPFEstagiario = new JFormattedTextField();
		add(formattedCPFEstagiario, "cell 3 3,growx");

		//mascara
		MaskFormatter mascaraCPF = null;
			try {
				mascaraCPF = new MaskFormatter("###.###.###-##");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mascaraCPF.install(formattedCPFEstagiario);
		/////////

		JLabel labelDataNasc = new JLabel("Data de Nascimento:");
		labelDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelDataNasc, "cell 0 4,alignx right,aligny center");

		fieldCurso = new JTextField();
		add(fieldCurso, "cell 2 4 2 1,growx");
		fieldCurso.setColumns(10);

		JLabel labelCelular = new JLabel("Telefone Celular:");
		labelCelular.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCelular, "cell 0 5,alignx right,aligny center");

		JFormattedTextField formattedTelefoneCasa = new JFormattedTextField();
		add(formattedTelefoneCasa, "flowx,cell 2 5,growx");

		Component horizontalStrut_4_3_5_1_1_7 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_5_1_1_7.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_5_1_1_7, "cell 2 5");

		JLabel labelEstado = new JLabel("Estado:");
		labelEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelEstado, "cell 2 5,alignx trailing");

		JComboBox comboEstado = new JComboBox();
		comboEstado.setModel(new DefaultComboBoxModel(new String[] {"-", "Acre (AC)", "Alagoas (AL)", "Amap\u00E1 (AP)", "Amazonas (AM)", "Bahia (BH)", "Cear\u00E1 (CE)", "Distrito Federal (DF)", "Esp\u00EDrito Santo (ES) ", "Goi\u00E1s (GO)", "Maranh\u00E3o (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Par\u00E1 (PA)", "Para\u00EDba (PB)", "Paran\u00E1 (PR)", "Pernambuco (PE)", "Piau\u00ED (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rond\u00F4nia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "S\u00E3o Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
		comboEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboEstado.setAlignmentX(1.0f);
		add(comboEstado, "cell 3 5,growx");

		JLabel labelEndreco = new JLabel("Endere\u00E7o:");
		labelEndreco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelEndreco, "flowx,cell 0 6,alignx right,aligny center");

		fieldEndereco = new JTextField();
		add(fieldEndereco, "cell 1 6,growx");
		fieldEndereco.setColumns(10);

		JLabel labelCep = new JLabel("CEP:");
		labelCep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCep, "cell 2 6,alignx trailing,aligny center");

		JFormattedTextField formattedCEPCurso = new JFormattedTextField();
		add(formattedCEPCurso, "cell 3 6,growx");

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
		add(labelBairro, "cell 0 7,alignx right,aligny center");

		JTextField fieldBairro = new JTextField();
		add(fieldBairro, "flowx,cell 1 7,growx");
		fieldBairro.setColumns(10);

		JLabel labelCidade = new JLabel("Cidade:");
		labelCidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCidade, "cell 2 7,alignx trailing,aligny center");

		JFormattedTextField formattedTelefoneCelular = new JFormattedTextField();
		add(formattedTelefoneCelular, "flowx,cell 1 5,growx");

		Component horizontalStrut_4_3_5_1_1_2 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_5_1_1_2.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_5_1_1_2, "cell 1 5");

		Component horizontalStrut_4_3_5_1_1_3 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_5_1_1_3.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_5_1_1_3, "cell 1 5");

		Component horizontalStrut_4_3_5_1_1_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_5_1_1_4.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_5_1_1_4, "cell 1 5");

		Component horizontalStrut_4_3_5_1_1_5 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_5_1_1_5.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_5_1_1_5, "cell 1 5");

		JLabel labelTelfoneCasa = new JLabel("Telefone de Casa:");
		labelTelfoneCasa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelTelfoneCasa, "cell 1 5,alignx right,aligny center");

		fieldCidade = new JTextField();
		fieldCidade.setColumns(10);
		add(fieldCidade, "cell 3 7,growx");

		JButton buttonLimparTela = new JButton("Limpar Tela");
		buttonLimparTela.setIcon(new ImageIcon(TelaEstagiario.class.getResource("/icons/37263_monitor_erase_icon.png")));
		buttonLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(buttonLimparTela, "cell 0 9 4 1,alignx center");

		JLabel laberOperacoes = new JLabel("Opera\u00E7\u00F5es");
		laberOperacoes.setIcon(new ImageIcon(TelaEstagiario.class.getResource("/icons/Database.png")));
		laberOperacoes.setHorizontalAlignment(SwingConstants.CENTER);
		laberOperacoes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		laberOperacoes.setBackground(Color.WHITE);
		add(laberOperacoes, "cell 0 12 4 1,grow");

		JComboBox comboSexo = new JComboBox();
		comboSexo.setModel(new DefaultComboBoxModel(new String[] {"-", "Masculino", "Feminino"}));
		comboSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboSexo.setAlignmentX(1.0f);
		add(comboSexo, "cell 2 3");

		Component horizontalStrut_4_3_5_1 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_5_1.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_5_1, "cell 2 3");

		Component horizontalStrut_4_3_5 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_5.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_5, "cell 2 3");

		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCPF, "cell 2 3,alignx left,aligny center");

		JFormattedTextField formattedDataNasc = new JFormattedTextField();
		add(formattedDataNasc, "flowx,cell 1 4,growx");

		JLabel labelDataIngreso = new JLabel("Data de Ingresso:");
		labelDataIngreso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelDataIngreso, "cell 1 4,alignx left,aligny center");

		JFormattedTextField formattedDataIngresso = new JFormattedTextField();
		add(formattedDataIngresso, "cell 1 4,growx");

		JLabel labelCurso = new JLabel("Curso:");
		labelCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCurso, "cell 1 4,alignx right,aligny center");

		JToolBar toolBarOpCRUDEstagiario = new JToolBar();
		toolBarOpCRUDEstagiario.setRollover(true);
		toolBarOpCRUDEstagiario.setFloatable(false);
		toolBarOpCRUDEstagiario.setEnabled(false);
		toolBarOpCRUDEstagiario.setBackground(new Color(255, 153, 153));
		add(toolBarOpCRUDEstagiario, "cell 0 13 4 1,grow");

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalStrut_3.setBackground(new Color(135, 206, 250));
		toolBarOpCRUDEstagiario.add(verticalStrut_3);

		JButton buttonCriarEstagiario = new JButton("  Criar  ");
		buttonCriarEstagiario.setIcon(new ImageIcon(TelaEstagiario.class.getResource("/icons/Create.png")));
		buttonCriarEstagiario.setToolTipText("");
		buttonCriarEstagiario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		buttonCriarEstagiario.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		buttonCriarEstagiario.setBackground(new Color(220, 220, 220));
		buttonCriarEstagiario.setAlignmentX(0.5f);
		toolBarOpCRUDEstagiario.add(buttonCriarEstagiario);

		Component verticalStrut_3_1 = Box.createVerticalStrut(20);
		verticalStrut_3_1.setBackground(new Color(135, 206, 250));
		toolBarOpCRUDEstagiario.add(verticalStrut_3_1);

		JButton butonLerEstagiario = new JButton("  Ler  ");
		butonLerEstagiario.setIcon(new ImageIcon(TelaEstagiario.class.getResource("/icons/List.png")));
		butonLerEstagiario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		butonLerEstagiario.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		butonLerEstagiario.setBackground(new Color(220, 220, 220));
		butonLerEstagiario.setAlignmentX(0.5f);
		toolBarOpCRUDEstagiario.add(butonLerEstagiario);

		Component verticalStrut_3_2 = Box.createVerticalStrut(20);
		verticalStrut_3_2.setBackground(new Color(135, 206, 250));
		toolBarOpCRUDEstagiario.add(verticalStrut_3_2);

		JButton buttonFazerUpEstagiario = new JButton("  Atualizar  ");
		buttonFazerUpEstagiario.setIcon(new ImageIcon(TelaEstagiario.class.getResource("/icons/Download.png")));
		buttonFazerUpEstagiario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		buttonFazerUpEstagiario.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		buttonFazerUpEstagiario.setBackground(new Color(220, 220, 220));
		buttonFazerUpEstagiario.setAlignmentX(0.5f);
		toolBarOpCRUDEstagiario.add(buttonFazerUpEstagiario);

		Component verticalStrut_3_3 = Box.createVerticalStrut(20);
		verticalStrut_3_3.setBackground(new Color(135, 206, 250));
		toolBarOpCRUDEstagiario.add(verticalStrut_3_3);

		JButton buttonRemoverEstagiario = new JButton("  Remover  ");
		buttonRemoverEstagiario.setIcon(new ImageIcon(TelaEstagiario.class.getResource("/icons/Remove.png")));
		buttonRemoverEstagiario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		buttonRemoverEstagiario.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		buttonRemoverEstagiario.setBackground(new Color(220, 220, 220));
		toolBarOpCRUDEstagiario.add(buttonRemoverEstagiario);

		Component verticalStrut_3_4 = Box.createVerticalStrut(20);
		verticalStrut_3_4.setBackground(new Color(135, 206, 250));
		toolBarOpCRUDEstagiario.add(verticalStrut_3_4);

		//mascara
		MaskFormatter mascaraTelefone = null;
			try {
				mascaraTelefone = new MaskFormatter("(##) 9####-####");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		mascaraTelefone.install(formattedTelefoneCelular);
		mascaraTelefone.install(formattedTelefoneCasa);
		/////////

		//mascara
		MaskFormatter mascaraData = null;
			try {
				mascaraData = new MaskFormatter("(##/##/####)");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		mascaraData.install(formattedDataIngresso);
		mascaraData.install(formattedDataNasc);
		/////////
	}

}
