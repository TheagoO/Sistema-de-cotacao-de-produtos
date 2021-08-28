package br.edu.unifacear.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "CODIGO")
	private int codigo;
	
	@OneToMany
	private List<Endereco> endereco = new ArrayList<>();
	
	public Cidade() {
		this.endereco = new ArrayList<>();
	}
	
	public Cidade(int id, String nome, int codigo, List<Endereco> endereco) {
		super();
		this.endereco = new ArrayList<>();
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

	public Endereco getEndereco(int i) {
		return endereco.get(i);
	}

	public void setEndereco(Endereco endereco) {
		this.endereco.add(endereco);
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", codigo=" + codigo + ", endereco=" + endereco
				+ "]";
	}
	
	
	
}
