package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConexaoDao;
import model.ModeloConcedente;

public class DaoTelaConcedente {

	// CRUD
	// PESQUISA
	public void create(ModeloConcedente ps) {

		Connection con = ConexaoDao.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"INSERT INTO ModeloConcedente (razaosocial, cnpjconc, telefoneconc, nomerepreconc, cargorepreconc, cepconc, enderecoconc, bairroconc, estadoconc) VALUES(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, ps.getRazaosocial());
			stmt.setString(2, ps.getCnpjconc());
			stmt.setString(3, ps.getTelefoneconc());
			stmt.setString(4, ps.getNomerepreconc());
			stmt.setString(5, ps.getCargorepreconc());
			stmt.setString(6, ps.getCepconc());
			stmt.setString(7, ps.getEnderecoconc());
			stmt.setString(8, ps.getBairroconc());
			stmt.setString(9, ps.getEstadoconc());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha no Salvamento");

		} finally {
			ConexaoDao.closeConnection(con, stmt);
		}
	}

	// LER DO BANCO
	public List<ModeloConcedente> read(String cnpjconc) {

		Connection con = ConexaoDao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<ModeloConcedente> apd = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT * FROM ModeloConcedente LIKE cnpjconc = ?");
			stmt.setString(1, cnpjconc);

			rs = stmt.executeQuery();

			while (rs.next()) {

				ModeloConcedente pd = new ModeloConcedente();

				pd.setRazaosocial(rs.getString("razaosocial"));
				pd.setCnpjconc(rs.getString("cnpjconc"));
				pd.setTelefoneconc(rs.getString("telefoneconc"));
				pd.setNomerepreconc(rs.getString("nomerepreconc"));
				pd.setCargorepreconc(rs.getString("cargorepreconc"));
				pd.setCepconc(rs.getString("cepconc"));
				pd.setEnderecoconc(rs.getString("enderecoconc"));
				pd.setBairroconc(rs.getString("bairroconc"));
				pd.setEstadoconc(rs.getString("estadoconc"));

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
	public void update(ModeloConcedente ps) {

		Connection con = ConexaoDao.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"UPDATE ModeloConcedente Set razaosocial = ?, cnpjconc = ?, telefoneconc = ?, nomerepreconc = ?, cargorepreconc = ?, cepconc = ?, enderecoconc = ?, bairroconc = ?, estadoconc = ?");
			stmt.setString(1, ps.getRazaosocial());
			stmt.setString(2, ps.getCnpjconc());
			stmt.setString(3, ps.getTelefoneconc());
			stmt.setString(4, ps.getNomerepreconc());
			stmt.setString(5, ps.getCargorepreconc());
			stmt.setString(6, ps.getCepconc());
			stmt.setString(7, ps.getEnderecoconc());
			stmt.setString(8, ps.getBairroconc());
			stmt.setString(9, ps.getEstadoconc());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha ao atualizar");

		} finally {
			ConexaoDao.closeConnection(con, stmt);
		}
	}

	// REMOVER DO BANCO
	public void remove(ModeloConcedente ps) {

		Connection con = ConexaoDao.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM ModeloConcedente WHERE cnpjconc = ?");
			stmt.setString(1, ps.getCnpjconc());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Excluido com Sucesso");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha ao Excluir");

		} finally {
			ConexaoDao.closeConnection(con, stmt);
		}
	}
}
