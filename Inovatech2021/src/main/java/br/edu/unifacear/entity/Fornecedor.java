package br.edu.unifacear.entity;

import java.util.Arrays;

public class Fornecedor {
	
	private int id;
	private String nome;
	private String empresa;
	private String cnpj;
	private String email;	
	
	private Contato[] contato;
	
	public Fornecedor() {
		
	}
	
	public Fornecedor(int id, String nome, String empresa, String cnpj, String email, Contato[] contato) {
		super();
		this.id = id;
		this.nome = nome;
		this.empresa = empresa;
		this.cnpj = cnpj;
		this.email = email;
		this.contato = contato;
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

	public Contato[] getContato() {
		return contato;
	}

	public void setContato(Contato[] contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", nome=" + nome + ", empresa=" + empresa + ", cnpj=" + cnpj + ", email="
				+ email + ", contato=" + Arrays.toString(contato) + "]";
	}
	
	
	
}
