package br.com.lucas.conexao;

import java.sql.SQLException;

public class UnitOfWork {

	CRUD crud = new CRUD();
	
	
	public void transaction() {
		
		try {
			crud.getStatement().executeQuery("Start transaction");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void commit() {
		
		try {
			crud.getStatement().executeQuery("Commit");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void rollback() {
		
		try {
			crud.getStatement().executeQuery("rollback");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public CRUD getCrud() {
		return crud;
	}


	
	
	
	
}
