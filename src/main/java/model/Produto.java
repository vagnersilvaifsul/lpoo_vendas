package model;

import java.text.NumberFormat;

public class Produto {
	private Long id;
	private String nome;
	private String descricao;
	private Double valor;
	private Integer estoque;
	private Boolean situacao;
	
	public Produto() {
		super();
	}

	public Produto(Long id, String nome, String descricao, Double valor, Integer estoque, Boolean situacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.estoque = estoque;
		this.situacao = situacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "\nProduto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", valor=" +  NumberFormat.getCurrencyInstance().format(valor) + ", estoque="
				+ estoque + ", situacao=" + situacao + "]";
	}
	
}
