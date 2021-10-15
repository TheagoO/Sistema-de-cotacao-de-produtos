package br.edu.unifacear.model.entity;

import javax.persistence.*;

@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "CODIGO")
	private int codigo;
		
	public Estado() {
	}
	
	public Estado(int id, String nome, int codigo) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
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


	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", codigo=" + codigo + "]";
	}

	
	
	
	
}
