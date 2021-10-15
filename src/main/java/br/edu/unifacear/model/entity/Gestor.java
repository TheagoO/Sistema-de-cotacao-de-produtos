package br.edu.unifacear.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Gestor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "CPF")
	private String cpf;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "SENHA")
	private String senha;
	
	@OneToMany
	private List<PedidoCompra> pedido = new ArrayList<>();
	
	@OneToMany
	private List<PedidoCotacao> cotacao = new ArrayList<>();
	
	public Gestor() {
		this.pedido = new ArrayList<>();
		this.cotacao = new ArrayList<>();
	}
	

	public Gestor(int id, String nome, String cpf, String email, String senha, List<PedidoCompra> pedido,
			List<PedidoCotacao> cotacao) {
		super();
		this.pedido = new ArrayList<>();
		this.cotacao = new ArrayList<>();
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


	public PedidoCompra getPedido(int i) {
		return pedido.get(i);
	}


	public void setPedido(PedidoCompra pedido) {
		this.pedido.add(pedido);
	}


	public PedidoCotacao getCotacao(int i) {
		return cotacao.get(i);
	}


	public void setCotacao(PedidoCotacao cotacao) {
		this.cotacao.add(cotacao);
	}


	@Override
	public String toString() {
		return "Gestor [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha
				+ ", pedido=" + pedido + ", cotacao=" + cotacao + "]";
	}

}
