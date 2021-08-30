package br.edu.unifacear.entity;

import javax.persistence.*;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "LOGRADOURO")
	private String logradouro;
	
	@Column(name = "NUMERO")
	private int numero;
	
	@Column(name = "COMPLEMENTO")
	private String complemento;
	
	@Column(name = "CEP")
	private String cep;
	
	@ManyToOne
	private Cidade cidade;
	
	public Endereco() {
		
	}
	
	public Endereco(int id, String logradouro, int numero, String complemento, String cep, Cidade cidade) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.cidade = cidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento="
				+ complemento + ", cep=" + cep + ", cidade=" + cidade + "]";
	}
	
}
