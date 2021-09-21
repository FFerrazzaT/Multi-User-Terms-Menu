package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConexaoDao;
import model.ModeloCurso;

public class DaoTelaCurso {

	// CRUD
	// PESQUISA
	public void create(ModeloCurso ps) {

		Connection con = ConexaoDao.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"INSERT INTO ModeloCurso (id, nomecurso, telefonecord, representantecord, cargoreprecord, universidade, cnpjuni, cepuni, enderecouni, bairrouni, cidadeuni, estadouni, telefoneuni, repreuni, cargorepreuni) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, ps.getId());
			stmt.setString(2, ps.getTelefonecord());
			stmt.setString(3, ps.getRepresentantecord());
			stmt.setString(3, ps.getCargoreprecord());
			stmt.setString(4, ps.getUniversidade());
			stmt.setString(5, ps.getCnpjuni());
			stmt.setString(6, ps.getCepuni());
			stmt.setString(7, ps.getEnderecouni());
			stmt.setString(8, ps.getBairrouni());
			stmt.setString(9, ps.getCidadeuni());
			stmt.setString(10, ps.getEstadouni());
			stmt.setString(11, ps.getTelefoneuni());
			stmt.setString(12, ps.getRepreuni());
			stmt.setString(13, ps.getCargorepreuni());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha no Salvamento");

		} finally {
			ConexaoDao.closeConnection(con, stmt);
		}
	}

	// LER DO BANCO
	public List<ModeloCurso> read(int id) {

		Connection con = ConexaoDao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<ModeloCurso> apd = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT * FROM ModeloCurso Like id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {

				ModeloCurso pd = new ModeloCurso();

				pd.setId(rs.getInt("id"));
				pd.setNomecurso(rs.getString("nomecurso"));
				pd.setTelefonecord(rs.getString("telefonecord"));
				pd.setRepresentantecord(rs.getString("representantecord"));
				pd.setCargoreprecord(rs.getString("cargoreprecord"));
				pd.setUniversidade(rs.getString("universidade"));
				pd.setCnpjuni(rs.getString("cnpjuni"));
				pd.setCepuni(rs.getString("cepuni"));
				pd.setEnderecouni(rs.getString("enderecouni"));
				pd.setBairrouni(rs.getString("bairrouni"));
				pd.setBairrouni(rs.getString("cidadeuni"));
				pd.setEstadouni(rs.getString("estadouni"));
				pd.setTelefoneuni(rs.getString("telefoneuni"));
				pd.setRepreuni(rs.getString("repreuni"));
				pd.setCargorepreuni(rs.getString("cargorepreuni"));

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
	public void update(ModeloCurso ps) {

		Connection con = ConexaoDao.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"UPDATE ModeloCurso Set id = ?, nomecurso = ?, telefonecord = ?, representantecord = ?, cargoreprecord = ?, universidade = ?, cnpjuni = ?, cepuni = ?, enderecouni = ?, bairrouni = ?, cidadeuni = ?, estadouni = ?, telefoneuni = ?, repreuni = ?, cargorepreuni = ?");
			stmt.setInt(1, ps.getId());
			stmt.setString(2, ps.getTelefonecord());
			stmt.setString(3, ps.getRepresentantecord());
			stmt.setString(3, ps.getCargoreprecord());
			stmt.setString(4, ps.getUniversidade());
			stmt.setString(5, ps.getCnpjuni());
			stmt.setString(6, ps.getCepuni());
			stmt.setString(7, ps.getEnderecouni());
			stmt.setString(8, ps.getBairrouni());
			stmt.setString(9, ps.getCidadeuni());
			stmt.setString(10, ps.getEstadouni());
			stmt.setString(11, ps.getTelefoneuni());
			stmt.setString(12, ps.getRepreuni());
			stmt.setString(13, ps.getCargorepreuni());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha ao atualizar");

		} finally {
			ConexaoDao.closeConnection(con, stmt);
		}
	}

	// REMOVER DO BANCO
	public void remove(ModeloCurso ps) {

		Connection con = ConexaoDao.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM ModeloCurso WHERE id = ?");
			stmt.setInt(1, ps.getId());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Excluido com Sucesso");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha ao Excluir");

		} finally {
			ConexaoDao.closeConnection(con, stmt);
		}
	}
}
