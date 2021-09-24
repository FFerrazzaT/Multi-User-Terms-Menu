package data.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import data.connection.ConexaoDao;

public class CentralAcess {

	public void createSql() {	
		
		Connection con = ConexaoDao.getConnection();
		Statement stmt = null;
		String sql = null;
		
		try {
			
			stmt = con.createStatement();	
			sql = "CREATE DATABASE ADMIN";
	        stmt.executeUpdate(sql);
	        System.out.println("Database created successfully...");   	  

	        stmt = con.createStatement();
			sql = "DROP SCHEMA IF EXISTS CentralAcess; CREATE SCHEMA CentralAcess; USE CentralAcess;";
	        stmt.executeUpdate(sql);
	        System.out.println("Schema created successfully...");   	  

	        stmt = con.createStatement();
			sql = "create table CODES (Id int, User varchar(30), Pass varchar(30)";
	        stmt.executeUpdate(sql);
	        System.out.println("Table created successfully...");
			
	        stmt.close();
	        
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha na criação da tabela");

		} finally {
			ConexaoDao.closeConnection(con);
		}
	}
}
