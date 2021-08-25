package br.edu.unifacear.entity;

import java.util.Arrays;

public class Estado {
	
	private int id;
	private String nome;
	private int codigo;
	private Cidade[] cidade;
	
	public Estado() {
		
	}
	
	public Estado(int id, String nome, int codigo, Cidade[] cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.cidade = cidade;
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

	public Cidade[] getCidade() {
		return cidade;
	}

	public void setCidade(Cidade[] cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", codigo=" + codigo + ", cidade=" + Arrays.toString(cidade)
				+ "]";
	}
	
	
	
}
