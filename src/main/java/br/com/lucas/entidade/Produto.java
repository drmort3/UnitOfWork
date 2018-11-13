package br.com.lucas.entidade;


import java.time.LocalDate;

public class Produto {

	//create table produto (id int not null auto increment, descricao varchar(50) not null, valorVenda double, valorCusto double, dataCompra DATE, PRIMARY KEY ( id ) )
	
	
	private String descricao;
	
	private double valorVenda;
	
	private double valorCusto;
	
	private LocalDate dataCompra;

	public Produto(String descricao, double valorVenda, double valorCusto, LocalDate dataCompra) {
		this.descricao = descricao;
		this.valorVenda = valorVenda;
		this.valorCusto = valorCusto;
		this.dataCompra = dataCompra;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValorCusto() {
		return valorCusto;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}	
	
	public double getValorVenda() {
		return valorVenda;
	}

	@Override
	public String toString() {
		return "Produto [descricao=" + descricao + ", valorVenda=" + valorVenda + ", valorCusto=" + valorCusto
				+ ", dataCompra=" + dataCompra + "]";
	}
	
}
