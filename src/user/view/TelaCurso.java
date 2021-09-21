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
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import net.miginfocom.swing.MigLayout;


@SuppressWarnings({ "serial" })
public class TelaCurso extends JPanel {
	private JTextField fieldCodigo;
	private JTextField FieldNomeCurso;
	private JTextField fieldRepreUni;
	private JTextField fieldRepreCord;
	private JTextField FieldNomeUniversidade;
	private JTextField fieldCargoRepresentante;
	private JTextField fieldBairro;
	private JTextField FIeldendereco;
	private JTextField fieldCargoRepreUni;
	private JTextField fieldCidade;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaCurso()
	{
		setBackground(new Color(152, 251, 152));
		setLayout(new MigLayout("", "[::183.00][364.00][185.00,grow][150,grow]", "[::5][35][10][30][30][30][30][30][30][30][30][30][30][40]"));
		setBounds(100, 100, 850, 500);

		JLabel lblTituloCurso = new JLabel("Curso");
		lblTituloCurso.setIcon(new ImageIcon(TelaCurso.class.getResource("/icons/Notes.png")));
		lblTituloCurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloCurso.setBackground(Color.WHITE);
		add(lblTituloCurso, "cell 0 1 4 1,growx");

		JSeparator separator_1 = new JSeparator();
		separator_1.setLocation(new Point(0, 1));
		separator_1.setForeground(Color.DARK_GRAY);
		add(separator_1, "cell 0 2 4 1,growx");

		JLabel labelNomeUniversidade = new JLabel("Nome da Universidade:");
		labelNomeUniversidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelNomeUniversidade, "flowx,cell 0 3,alignx right");

		FieldNomeUniversidade = new JTextField();
		add(FieldNomeUniversidade, "cell 1 3,growx");
		FieldNomeUniversidade.setColumns(10);

		JLabel labelTelefoneCordenacao = new JLabel("Telefone da Cordena\u00E7\u00E3o:");
		labelTelefoneCordenacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelTelefoneCordenacao, "cell 2 3,alignx trailing");

		JFormattedTextField formattedTelefoneCoord = new JFormattedTextField();
		add(formattedTelefoneCoord, "cell 3 3,growx");

		JLabel labelNomeCurso = new JLabel("Nome do Curso:");
		labelNomeCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelNomeCurso, "cell 0 4,alignx right");

		FieldNomeCurso = new JTextField();
		add(FieldNomeCurso, "cell 1 4,growx,aligny center");
		FieldNomeCurso.setColumns(10);

		JLabel labelCodigo = new JLabel("C\u00F3digo:");
		labelCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCodigo, "cell 2 4,alignx right");

		fieldCodigo = new JTextField();
		add(fieldCodigo, "cell 3 4");
		fieldCodigo.setColumns(10);

		JLabel labelCargoCordenacao = new JLabel("Cargo da Cordena\u00E7\u00E3o:");
		labelCargoCordenacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCargoCordenacao, "cell 0 5,alignx right");

		JTextField fieldCargoCordenacao = new JTextField();
		add(fieldCargoCordenacao, "flowx,cell 1 5");
		fieldCargoCordenacao.setColumns(20);

		JFormattedTextField formattedCNPJCurso = new JFormattedTextField();
		add(formattedCNPJCurso, "cell 2 5,growx");

		//mascara
		MaskFormatter mascaraCNPJ = null;
		try {
			mascaraCNPJ = new MaskFormatter("##.###.###/0001-##.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mascaraCNPJ.install(formattedCNPJCurso);
		/////////

		JLabel labelRepresentanteCord = new JLabel("Nome Rep. (Coord):");
		labelRepresentanteCord.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelRepresentanteCord, "cell 0 6,alignx right");

		fieldRepreCord = new JTextField();
		add(fieldRepreCord, "cell 1 6,growx");
		fieldRepreCord.setColumns(10);

		JLabel labelGeralUniversidade = new JLabel("Telefone geral Universidade:");
		labelGeralUniversidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelGeralUniversidade, "cell 2 6,alignx trailing");

		JFormattedTextField formattedTelefoneGUni = new JFormattedTextField();
		add(formattedTelefoneGUni, "cell 3 6,growx");

		//mascara
		MaskFormatter mascaraTelefone = null;
		try {
			mascaraTelefone = new MaskFormatter("(##) 9####-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mascaraTelefone.install(formattedTelefoneGUni);
		mascaraTelefone.install(formattedTelefoneCoord);
		/////////

		JLabel lblRepresentanteUniversidade = new JLabel("Nome Rep. (Univ):");
		lblRepresentanteUniversidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblRepresentanteUniversidade, "cell 0 7,alignx trailing");

		fieldRepreUni = new JTextField();
		add(fieldRepreUni, "cell 1 7,growx");
		fieldRepreUni.setColumns(10);

		JLabel lblCargoRepresentante = new JLabel("Cargo do Rep. (Coord):");
		lblCargoRepresentante.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblCargoRepresentante, "cell 0 8,alignx right,aligny center");

		fieldCargoRepresentante = new JTextField();
		add(fieldCargoRepresentante, "flowx,cell 1 8");
		fieldCargoRepresentante.setColumns(20);

		fieldCargoRepreUni = new JTextField();
		add(fieldCargoRepreUni, "cell 2 8,growx");
		fieldCargoRepreUni.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblEndereco, "flowx,cell 0 9,alignx right");

		FIeldendereco = new JTextField();
		add(FIeldendereco, "flowx,cell 1 9 2 1,growx");
		FIeldendereco.setColumns(10);

		JButton buttonLimparTela = new JButton("Limpar Tela");
		buttonLimparTela.setIcon(new ImageIcon(TelaCurso.class.getResource("/icons/37263_monitor_erase_icon.png")));
		buttonLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(buttonLimparTela, "cell 3 9,alignx center");

		JLabel labelEstado = new JLabel("Estado:");
		labelEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelEstado, "cell 0 10,alignx right");

		JComboBox comboEstado = new JComboBox();
		comboEstado.setModel(new DefaultComboBoxModel(new String[] {"-", "Acre (AC)", "Alagoas (AL)", "Amap\u00E1 (AP)", "Amazonas (AM)", "Bahia (BH)", "Cear\u00E1 (CE)", "Distrito Federal (DF)", "Esp\u00EDrito Santo (ES) ", "Goi\u00E1s (GO)", "Maranh\u00E3o (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Par\u00E1 (PA)", "Para\u00EDba (PB)", "Paran\u00E1 (PR)", "Pernambuco (PE)", "Piau\u00ED (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rond\u00F4nia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "S\u00E3o Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
		comboEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboEstado.setAlignmentX(1.0f);
		add(comboEstado, "flowx,cell 1 10,alignx left");

		fieldCidade = new JTextField();
		fieldCidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(fieldCidade, "cell 2 10,growx");
		fieldCidade.setColumns(20);

		JLabel labelBairro = new JLabel("Bairro:");
		labelBairro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelBairro, "cell 0 11,alignx trailing");

		fieldBairro = new JTextField();
		add(fieldBairro, "flowx,cell 1 11,growx");
		fieldBairro.setColumns(10);

		JLabel labelCep = new JLabel("CEP:");
		labelCep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCep, "flowx,cell 2 11,alignx right,aligny center");

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setPreferredSize(new Dimension(0, 0));
		horizontalStrut.setVisible(false);
		horizontalStrut.setMinimumSize(new Dimension(60, 0));
		add(horizontalStrut, "cell 1 10");

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setVisible(false);
		horizontalStrut_1.setPreferredSize(new Dimension(0, 0));
		horizontalStrut_1.setMinimumSize(new Dimension(60, 0));
		add(horizontalStrut_1, "cell 1 10");

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setVisible(false);
		horizontalStrut_2.setPreferredSize(new Dimension(0, 0));
		horizontalStrut_2.setMinimumSize(new Dimension(60, 0));
		add(horizontalStrut_2, "cell 1 10");

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setVisible(false);
		horizontalStrut_3.setPreferredSize(new Dimension(0, 0));
		horizontalStrut_3.setMinimumSize(new Dimension(60, 0));
		add(horizontalStrut_3, "cell 1 10");

		Component horizontalStrut_4_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4_4.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_4, "cell 1 10");

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4, "cell 1 10");

		JLabel labelCidade = new JLabel("Cidade:");
		labelCidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCidade, "cell 1 10,alignx right,aligny center");

		Component horizontalStrut_4_1 = Box.createHorizontalStrut(20);
		horizontalStrut_4_1.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_1, "cell 1 8");

		Component horizontalStrut_4_2 = Box.createHorizontalStrut(20);
		horizontalStrut_4_2.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_2, "cell 1 8");

		Component horizontalStrut_4_3 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3, "cell 1 8");

		JLabel labelCargoRepresentandoUni = new JLabel("Cargo do Rep. (Univ):");
		labelCargoRepresentandoUni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCargoRepresentandoUni, "cell 1 8,alignx right");

		Component horizontalStrut_4_3_1 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_1.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_1, "cell 1 5");

		Component horizontalStrut_4_3_2 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_2.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_2, "cell 1 5");

		Component horizontalStrut_4_3_3 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_3.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_3, "cell 1 5");

		Component horizontalStrut_4_3_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_4.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_4, "cell 1 5");

		Component horizontalStrut_4_3_5 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_5.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_5, "cell 1 5");

		Component horizontalStrut_4_3_7 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_7.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_7, "cell 1 5");

		Component horizontalStrut_4_3_6 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_6.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_6, "cell 1 5");

		JLabel labelCnpj = new JLabel("CNPJ:");
		labelCnpj.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCnpj, "cell 1 5,alignx right,aligny center");

		JLabel lblNewLabel_1 = new JLabel("Opera\u00E7\u00F5es");
		lblNewLabel_1.setIcon(new ImageIcon(TelaCurso.class.getResource("/icons/Database.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBackground(Color.WHITE);
		add(lblNewLabel_1, "cell 0 12 4 1,alignx center");

		JToolBar toolBarOpCRUDCurso = new JToolBar();
		toolBarOpCRUDCurso.setRollover(true);
		toolBarOpCRUDCurso.setFloatable(false);
		toolBarOpCRUDCurso.setEnabled(false);
		toolBarOpCRUDCurso.setBackground(new Color(102, 205, 170));
		add(toolBarOpCRUDCurso, "cell 0 13 4 1,grow");

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalStrut_3.setBackground(new Color(135, 206, 250));
		toolBarOpCRUDCurso.add(verticalStrut_3);

		JButton buttonCriarConcedente = new JButton("  Criar  ");
		buttonCriarConcedente.setIcon(new ImageIcon(TelaCurso.class.getResource("/icons/Create.png")));
		buttonCriarConcedente.setToolTipText("");
		buttonCriarConcedente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		buttonCriarConcedente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		buttonCriarConcedente.setBackground(new Color(220, 220, 220));
		buttonCriarConcedente.setAlignmentX(0.5f);
		toolBarOpCRUDCurso.add(buttonCriarConcedente);

		Component verticalStrut_3_1 = Box.createVerticalStrut(20);
		verticalStrut_3_1.setBackground(new Color(135, 206, 250));
		toolBarOpCRUDCurso.add(verticalStrut_3_1);

		JButton butonLerConcedente = new JButton("  Ler  ");
		butonLerConcedente.setIcon(new ImageIcon(TelaCurso.class.getResource("/icons/List.png")));
		butonLerConcedente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		butonLerConcedente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		butonLerConcedente.setBackground(new Color(220, 220, 220));
		butonLerConcedente.setAlignmentX(0.5f);
		toolBarOpCRUDCurso.add(butonLerConcedente);

		Component verticalStrut_3_2 = Box.createVerticalStrut(20);
		verticalStrut_3_2.setBackground(new Color(135, 206, 250));
		toolBarOpCRUDCurso.add(verticalStrut_3_2);

		JButton buttonFazerUpConcedente = new JButton("  Atualizar  ");
		buttonFazerUpConcedente.setIcon(new ImageIcon(TelaCurso.class.getResource("/icons/Download.png")));
		buttonFazerUpConcedente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		buttonFazerUpConcedente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		buttonFazerUpConcedente.setBackground(new Color(220, 220, 220));
		buttonFazerUpConcedente.setAlignmentX(0.5f);
		toolBarOpCRUDCurso.add(buttonFazerUpConcedente);

		Component verticalStrut_3_3 = Box.createVerticalStrut(20);
		verticalStrut_3_3.setBackground(new Color(135, 206, 250));
		toolBarOpCRUDCurso.add(verticalStrut_3_3);

		JButton buttonRemoverConcedente = new JButton("  Remover  ");
		buttonRemoverConcedente.setIcon(new ImageIcon(TelaCurso.class.getResource("/icons/Remove.png")));
		buttonRemoverConcedente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		buttonRemoverConcedente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		buttonRemoverConcedente.setBackground(new Color(220, 220, 220));
		toolBarOpCRUDCurso.add(buttonRemoverConcedente);

		Component verticalStrut_3_4 = Box.createVerticalStrut(20);
		verticalStrut_3_4.setBackground(new Color(135, 206, 250));
		toolBarOpCRUDCurso.add(verticalStrut_3_4);

		JFormattedTextField formattedCEPCurso = new JFormattedTextField();
		add(formattedCEPCurso, "cell 2 11,growx");

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


	}
}
