package br.edu.unifacear.entity;

import java.util.Arrays;

public class Gestor {
	
	private int id;
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	
	private PedidoCompra[] pedido;
	private PedidoCotacao[] cotacao;
	
	public Gestor() {
		
	}
	
	public Gestor(int id, String nome, String cpf, String email, String senha, PedidoCompra[] pedido,
			PedidoCotacao[] cotacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.pedido = pedido;
		this.cotacao = cotacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public PedidoCompra[] getPedido() {
		return pedido;
	}

	public void setPedido(PedidoCompra[] pedido) {
		this.pedido = pedido;
	}

	public PedidoCotacao[] getCotacao() {
		return cotacao;
	}

	public void setCotacao(PedidoCotacao[] cotacao) {
		this.cotacao = cotacao;
	}

	@Override
	public String toString() {
		return "Gestor [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha
				+ ", pedido=" + Arrays.toString(pedido) + ", cotacao=" + Arrays.toString(cotacao) + "]";
	}
	
	
}
