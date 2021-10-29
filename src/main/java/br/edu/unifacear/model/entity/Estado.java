package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Estado implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "CODIGO")
	private int codigo;
		
	public Estado() {
		this.id = 0;
	}
	
	public Estado(int id, String nome, int codigo) {
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

	@Override
	public int hashCode() {
		return Objects.hash(codigo, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		return codigo == other.codigo && id == other.id && Objects.equals(nome, other.nome);
	}

}
