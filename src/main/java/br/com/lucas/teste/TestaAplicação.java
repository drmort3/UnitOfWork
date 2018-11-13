package br.com.lucas.teste;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import br.com.lucas.conexao.CRUD;
import br.com.lucas.conexao.ConexaoBD;
import br.com.lucas.conexao.UnitOfWork;
import br.com.lucas.entidade.Produto;
import br.com.lucas.validacoes.ValidadorProduto;

public class TestaAplicação {

	public static void main(String[] args) {

		UnitOfWork unitOfWork = new UnitOfWork();

		Produto produto = new Produto("Camiseta", 80, 15.00, LocalDate.now().plusDays(-1));
		Produto produto1 = new Produto("Camiseta masculina regata algodão", 10, 15.00, LocalDate.now().plusDays(-50));
		Produto produto2 = new Produto("Camiseta feminina", 80, 15.00, LocalDate.now().plusDays(-100));
		
		

		ValidadorProduto validadorProduto = new ValidadorProduto(produto);
		ValidadorProduto validadorProduto1 = new ValidadorProduto(produto1);
		ValidadorProduto validadorProduto2 = new ValidadorProduto(produto2);

		validadorProduto.validar();
		validadorProduto1.validar();
		validadorProduto2.validar();
		
		

		ValidaInsert(unitOfWork, produto, validadorProduto);
		
		ValidaInsert(unitOfWork, produto1, validadorProduto1);
		
		ValidaInsert(unitOfWork, produto2, validadorProduto2);

		

	}

	
	
	private static void ValidaInsert(UnitOfWork unitOfWork, Produto produto, ValidadorProduto validadorProduto) {
		if (validadorProduto.StatusValidador() == true) {

			unitOfWork.transaction();

			unitOfWork.getCrud()
					.insert("insert into produto (descricao, valorVenda, valorCusto, dataCompra)" + " values ('"
							+ produto.getDescricao() + "', " + produto.getValorVenda() + "," + produto.getValorCusto()
							+ "," + "'" + produto.getDataCompra() + "');");

			if (unitOfWork.getCrud().getError() == true) {
				
				unitOfWork.rollback();
				
			} else {
				
				unitOfWork.commit();
				
				System.out.println("Produto inserido com sucesso!! " + produto.toString());
				
			}

		}
	}

}
