package dao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import connection.ConexaoDao;
import model.ModeloTermoCompromisso;
import view.TelaTermoCompromisso;
import view.informacao;

@SuppressWarnings("serial")
public class DaoTelaTermoCompromisso extends TelaTermoCompromisso implements ActionListener {

	//private TelaTermoCompromisso jan;
	// private TermoCompromisso tc;
	// private BancoCRUD bcrud;

	public static void informacao() {
		System.out.println("informação!");
		informacao informacao = new informacao();
		informacao.setVisible(true);
	}

	public static void botaoLimparTTC() {
		// TODO Auto-generated method stub
		TelaTermoCompromisso.limparTela();
	}

	public void botaoPesqTTC() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Limpar")) {
			botaoLimparTTC();
		}
		if (e.getActionCommand().equals("Ler")) {
			botaoPesqTTC();
		}

	}

//	LER DO BANCO Aluno
	public void read(String cpf) {

		Connection con = ConexaoDao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("SELECT * FROM ModeloEstagio WHERE cpf = ?");
			stmt.setString(1, cpf);

			rs = stmt.executeQuery();

			while (rs.next()) {

				String cpfaluno = rs.getString("cpf");
				String nomealuno = rs.getString("nome");
				String cidade = rs.getString("cidade");

				stmt.close();
				rs.close();

				stmt = con.prepareStatement("SELECT * FROM ModeloCurso WHERE cidadeuni = ?");
				stmt.setString(1, cidade);
				rs = stmt.executeQuery();

				String nomecurso = rs.getString("nomecurso");
				String representantecord = rs.getString("representantecord");
				String universidade = rs.getString("universidade");
				String representanteuni = rs.getString("repreuni");

				System.out.println("ACHOU " + nomecurso);

				TelaTermoCompromisso.metodoDevolveValor(cpfaluno, nomealuno, nomecurso, representantecord, universidade,
						representanteuni);

				return;
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Cpf não existe", " Alerta ", JOptionPane.ERROR_MESSAGE);

		} finally {
			ConexaoDao.closeConnection(con, stmt, rs);
		}

	}

//		LER DO BANCO Empresa
	@SuppressWarnings("unused")
	public void readc(String cnpjconc) {

		Connection con = ConexaoDao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("SELECT * FROM ModeloConcedente WHERE cnpjconc = ?");
			stmt.setString(1, cnpjconc);
			rs = stmt.executeQuery();

			if (rs.next()) {

				String cnpj = rs.getString("cnpjconc");
				String razao = rs.getString("razaosocial");
				String nome = rs.getString("nomerepreconc");

				return;
			}
		}

		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Cnpj não existe", " Alerta ", JOptionPane.ERROR_MESSAGE);

		} finally {
			ConexaoDao.closeConnection(con, stmt, rs);
		}

	}

//	Criar tabelas
	public void create(ModeloTermoCompromisso ps) {

		Connection con = ConexaoDao.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"INSERT INTO ModeloEstagio(cpf, nome, info, inicio, fim, chdia, chsema, hrinicio, hrfim, bolsa, area, atividade) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");

			stmt.setString(1, ps.getCpfAluno());
			stmt.setString(2, ps.getNomeAluno());
			stmt.setString(3, ps.getInfoComplementar());
			stmt.setString(4, ps.getInicioEstagio());
			stmt.setString(5, ps.getFimEstagio());
			stmt.setString(6, ps.getChDiaria());
			stmt.setString(7, ps.getChSemanal());
			stmt.setString(8, ps.getHrInicio());
			stmt.setString(9, ps.getHrFim());
			stmt.setString(10, ps.getBeneficios());
			stmt.setString(11, ps.getValorBolsa());
			stmt.setString(12, ps.getAreaEstagio());
			stmt.setString(13, ps.getPrincipaisAtv());

			stmt.close();

			stmt = con.prepareStatement(
					"INSERT INTO ModeloCurso(nomecurso, representantecord, universidadeo) VALUES(?,?,?)");

			stmt.setString(1, ps.getNomeCurso());
			stmt.setString(2, ps.getNomeOrientador());
			stmt.setString(3, ps.getNomeUniversidade());

			stmt.close();

			stmt = con.prepareStatement(
					"INSERT INTO ModeloConcedente (cnpjconc, razaosocial, nomerepreconc) VALUES(?,?,?)");

			stmt.setString(1, ps.getConcedenteCnpj());
			stmt.setString(2, ps.getRazaoSocial());
			stmt.setString(3, ps.getNomeRepresentanteConc());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Acesso criado com sucesso", " Info ", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Não foi possivel salvar", " Alerta ", JOptionPane.ERROR_MESSAGE);

		} finally {
			ConexaoDao.closeConnection(con, stmt);
		}
	}

}
