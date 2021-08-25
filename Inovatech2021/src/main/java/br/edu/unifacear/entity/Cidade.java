package br.edu.unifacear.entity;

import java.util.Arrays;

public class Cidade {
	private int id;
	private String nome;
	private int codigo;
	private Endereco[] endereco;
	
	public Cidade() {
		
	}
	
	public Cidade(int id, String nome, int codigo, Endereco[] endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Endereco[] getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco[] endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", codigo=" + codigo + ", endereco=" + Arrays.toString(endereco)
				+ "]";
	}
	
	
	
}
