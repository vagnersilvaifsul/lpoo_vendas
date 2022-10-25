package model;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private Long id;
	private String formaPagamento;
	private String estado;
	private LocalDate dataCriacao;
	private LocalDate dataModificacao;
	private Double totalPedido;
	private Boolean situacao;
	private Cliente cliente;
	private List<Item> itens = new ArrayList<>();
	
	public Pedido() {
		super();
	}

	public Pedido(Long id, String formaPagamento, String estado, LocalDate dataCriacao, LocalDate dataModificacao,
			Double totalPedido, Boolean situacao, Cliente cliente, List<Item> itens) {
		super();
		this.id = id;
		this.formaPagamento = formaPagamento;
		this.estado = estado;
		this.dataCriacao = dataCriacao;
		this.dataModificacao = dataModificacao;
		this.totalPedido = totalPedido;
		this.situacao = situacao;
		this.cliente = cliente;
		this.itens = itens;
	}

	public Pedido(Long id, String formaPagamento, String estado, LocalDate dataCriacao, LocalDate dataModificacao,
			Double totalPedido, Boolean situacao, Cliente cliente) {
		super();
		this.id = id;
		this.formaPagamento = formaPagamento;
		this.estado = estado;
		this.dataCriacao = dataCriacao;
		this.dataModificacao = dataModificacao;
		this.totalPedido = totalPedido;
		this.situacao = situacao;
		this.cliente = cliente;
	}
	
	public Pedido(List<Item> itens) {
		super();
		this.itens = itens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(LocalDate dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	public Double getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(Double totalPedido) {
		this.totalPedido = totalPedido;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "\n*******  Pedido Número = " + id + " ******" +
				"\nForma de Pagamento= " + formaPagamento + 
				"\nEstado= " + estado + 
				"\nData da criação= " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataCriacao) +
				"\nData da modificacao= " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataModificacao) +
				"\nTotal do Pedido= " + NumberFormat.getCurrencyInstance().format(totalPedido) + 
				"\nsituacao= " + situacao + 
				"\nCliente=" + cliente + 
				"\nItens=" + itens + "\n";
	}
	
}
