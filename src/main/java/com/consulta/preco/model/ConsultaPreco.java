package com.consulta.preco.model;

public class ConsultaPreco {
		
	private String codigoBarras;
	private String descricaoProduto;
	private Double preco;
	private String descricaoEstabelecimento;
	private String embalagem;

	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getDescricaoEstabelecimento() {
		return descricaoEstabelecimento;
	}
	public void setDescricaoEstabelecimento(String descricaoEstabelecimento) {
		this.descricaoEstabelecimento = descricaoEstabelecimento;
	}
	public String getEmbalagem() {
		return embalagem;
	}
	public void setEmbalagem(String embalagem) {
		this.embalagem = embalagem;
	}
	
	

}
