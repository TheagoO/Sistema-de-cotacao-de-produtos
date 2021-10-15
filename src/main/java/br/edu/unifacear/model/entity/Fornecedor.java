package br.edu.unifacear.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "EMPRESA")
	private String empresa;
	
	@Column(name = "CNPJ")
	private String cnpj;
	
	@Column(name = "EMAIL")
	private String email;	
	
	@OneToMany
	private List<Contato> contato = new ArrayList<>();
	
	@OneToMany
	private List<Endereco> endereco = new ArrayList<>();
	
	public Fornecedor() {
		this.contato = new ArrayList<>();
		this.endereco = new ArrayList<>();
	}
	
	public Fornecedor(int id, String nome, String empresa, String cnpj, String email, List<Contato> contato, List<Endereco> endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.empresa = empresa;
		this.cnpj = cnpj;
		this.email = email;
		this.contato = contato;
		this.endereco = endereco;
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

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Contato getContato(int i) {
		return contato.get(i);
	}

	public void setContato(Contato contato) {
		this.contato.add(contato);
	}

	public Endereco getEndereco(int i) {
		return endereco.get(i);
	}

	public void setEndereco(Endereco endereco) {
		this.endereco.add(endereco);
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", nome=" + nome + ", empresa=" + empresa + ", cnpj=" + cnpj + ", email="
				+ email + ", contato=" + contato + ", endereco=" + endereco + "]";
	}


}
