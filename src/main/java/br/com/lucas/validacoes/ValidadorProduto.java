package br.com.lucas.validacoes;

import java.time.LocalDate;

import br.com.lucas.entidade.Produto;

public class ValidadorProduto implements Validador {

	private Produto produto;
	
	private boolean statusValidador = true;

	public ValidadorProduto(Produto produto) {
		this.produto = produto;
	}

	public void validar() {

		if (produto.getDescricao().length() < 10) {	
			statusValidador = false;
			System.out.println("Descrição do produto maior que 10 caracteres");
			//throw new IllegalArgumentException("Descrição do produto maior que 10 caracteres");
		}
		
		if (produto.getDataCompra().isAfter(LocalDate.now())) {
			statusValidador = false;
			System.out.println("Data da Compra inferior a data de hoje");
			//throw new IllegalArgumentException("Data da Compra inferior a data de hoje");
		}
		if (produto.getValorVenda() < produto.getValorCusto()) {
			statusValidador = false;
			System.out.println("Valor da venda não pode ser inferior ao valor do custo");
			//throw new IllegalArgumentException("Valor da venda não pode ser inferior ao valor do custo");
		} 
		
	}

	public boolean StatusValidador() {
		return statusValidador;
	}
	
	
	
	
	
}
