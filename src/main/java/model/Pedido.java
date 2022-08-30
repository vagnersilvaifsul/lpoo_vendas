package model;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Pedido {
	private Long id;
	private String formaPagamento;
	private String estado;
	private Calendar dataCriacao;
	private Calendar dataModificacao;
	private Double totalPedido;
	private Boolean situacao;
	private Cliente cliente;
	private List<Item> itens = new ArrayList<>();
	
	public Pedido() {
		super();
	}

	public Pedido(Long id, String formaPagamento, String estado, Calendar dataCriacao, Calendar dataModificacao,
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

	public Pedido(Long id, String formaPagamento, String estado, Calendar dataCriacao, Calendar dataModificacao,
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

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Calendar getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Calendar dataModificacao) {
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
				"\nData da criação= " + calendarToString(dataCriacao) + 
				"\nData da modificacao= " + calendarToString(dataModificacao) + 
				"\nTotal do Pedido= " + NumberFormat.getCurrencyInstance().format(totalPedido) + 
				"\nsituacao= " + situacao + 
				"\nCliente=" + cliente + 
				"\nItens=" + itens + "\n";
	}
	
	//métodos utilitários para conversão de Calendar para String formatada
	private static String calendarToString(Calendar data) {
		if(data != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			return sdf.format(data.getTime());
		}
		return "00/00/0000";
	}
	
}
