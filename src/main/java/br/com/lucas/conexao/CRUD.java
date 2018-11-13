package br.com.lucas.conexao;

import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

	private ConexaoBD conexaoBD;
	private Statement statement;
	private boolean error = false;

	public CRUD() {

		this.conexaoBD = new ConexaoBD();
		try {
			this.statement = new ConexaoBD().criaConexao();
		} catch (SQLException e) {
			error = true;
			e.printStackTrace();
		}
	}

	public void insert(String query) {

		try {

			statement.executeUpdate(query);

		} catch (SQLException e) {
			error = true;
			e.printStackTrace();
		}

	}

	public void executeQuery(String query) {

		try {

			statement.executeQuery(query);

		} catch (SQLException e) {
			error = true;
			e.printStackTrace();
		}
	}

	public Statement getStatement() {
		return statement;
	}

	
	public boolean getError() {
		return error;
	}

	
	
	
}
