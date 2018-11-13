package br.com.lucas.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {

	ResultSet resultSet;

	public Statement criaConexao() throws SQLException {

		// com.mysql.jdbc.Driver

		String conexao = "jdbc:mysql://localhost:3306/" + "careca?useTimezone=true&serverTimezone=UTC";

		Connection con = DriverManager.getConnection(conexao, "root", "padrao");

		Statement statement = con.createStatement();

		return statement;

	}

}
