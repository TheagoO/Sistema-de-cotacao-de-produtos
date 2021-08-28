package br.edu.unifacear.entity;

import java.util.ArrayList;
import java.util.List;

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
	
	@OneToMany
	private List<Cidade> cidade = new ArrayList<>();
	
	public Estado() {
		this.cidade = new ArrayList<>();
	}
	
	public Estado(int id, String nome, int codigo, List<Cidade> cidade) {
		super();
		this.cidade = new ArrayList<>();
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

	public Cidade getCidade(int i) {
		return cidade.get(i);
	}

	public void setCidade(Cidade cidade) {
		this.cidade.add(cidade);
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", codigo=" + codigo + ", cidade=" + cidade + "]";
	}

	
	
	
	
}
