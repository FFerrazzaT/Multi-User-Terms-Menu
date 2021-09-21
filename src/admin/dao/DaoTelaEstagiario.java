package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConexaoDao;
import model.ModeloEstagio;

public class DaoTelaEstagiario {

	// CRUD

	// PESQUISA
	public void create(ModeloEstagio ps) {

		Connection con = ConexaoDao.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"INSERT INTO ModeloEstagio (cpf, nome, sexo, telefonecelular, telefonecasa, cep, endereco, bairro, cidade, curso, dataingresso) VALUES(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, ps.getCpf());
			stmt.setString(2, ps.getNome());
			stmt.setString(3, ps.getSexo());
			stmt.setString(4, ps.getTelefonecelular());
			stmt.setString(5, ps.getTelefonecasa());
			stmt.setString(6, ps.getCep());
			stmt.setString(7, ps.getBairro());
			stmt.setString(8, ps.getCidade());
			stmt.setString(9, ps.getCurso());
			stmt.setString(10, ps.getDataingresso());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha no Salvamento");

		} finally {
			ConexaoDao.closeConnection(con, stmt);
		}
	}

	// LER DO BANCO
	public List<ModeloEstagio> read(String cpf) {

		Connection con = ConexaoDao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<ModeloEstagio> apd = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT * FROM ModeloEstagio LIKE cpf = ?");
			stmt.setString(1, cpf);
			rs = stmt.executeQuery();

			while (rs.next()) {

				ModeloEstagio pd = new ModeloEstagio();

				pd.setCpf(rs.getString("cpf"));
				pd.setNome(rs.getString("nome"));
				pd.setSexo(rs.getString("sexo"));
				pd.setTelefonecelular(rs.getString("telefonecelular"));
				pd.setTelefonecasa(rs.getString("telefonecasa"));
				pd.setCep(rs.getString("cep"));
				pd.setEndereco(rs.getString("endereco"));
				pd.setBairro(rs.getString("bairro"));
				pd.setCidade(rs.getString("cidade"));
				pd.setCurso(rs.getString("curso"));
				pd.setDataingresso(rs.getString("dataingresso"));

				apd.add(pd);
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Leitura falhou");

		} finally {
			ConexaoDao.closeConnection(con, stmt, rs);
		}

		return apd;
	}

	// UPDTATE BANCO
	public void update(ModeloEstagio ps) {

		Connection con = ConexaoDao.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"UPDATE ModeloEstagio Set cpf = ?, nome = ?, sexo = ?, telefonecelular = ?, telefonecasa = ?, cep = ?, endereco = ?, bairro = ?, cidade = ?, curso = ?, dataingresso = ?");
			stmt.setString(1, ps.getCpf());
			stmt.setString(2, ps.getNome());
			stmt.setString(3, ps.getSexo());
			stmt.setString(4, ps.getTelefonecelular());
			stmt.setString(5, ps.getTelefonecasa());
			stmt.setString(6, ps.getCep());
			stmt.setString(7, ps.getBairro());
			stmt.setString(8, ps.getCidade());
			stmt.setString(9, ps.getCurso());
			stmt.setString(10, ps.getDataingresso());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha ao atualizar");

		} finally {
			ConexaoDao.closeConnection(con, stmt);
		}
	}

	// REMOVER DO BANCO
	public void remove(ModeloEstagio ps) {

		Connection con = ConexaoDao.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM ModeloEstagio WHERE cpf = ?");
			stmt.setString(1, ps.getCpf());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Excluido com Sucesso");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha ao Excluir");

		} finally {
			ConexaoDao.closeConnection(con, stmt);
		}
	}
}
