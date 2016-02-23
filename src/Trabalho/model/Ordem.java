package Trabalho.model;


import java.util.Collection;
import java.util.Date;

public abstract class Ordem implements Entidade {

	private String descricao;
	private String data;
	private String problema;
	private String modelo;
	private Double valor;
	private String prazoEntrega;
	private Status status;
	private Cliente cliente;
	
	

	
	

	

	public Ordem() {
		super();
	}

	public Ordem(String descricao, String data, String problema, String modelo,
			Double valor, String prazoEntrega) {
		super();
		this.descricao = descricao;
		this.data = data;
		this.problema = problema;
		this.modelo = modelo;
		this.valor = valor;
		this.prazoEntrega = prazoEntrega;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getValor() {
		return valor = valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(String prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}
