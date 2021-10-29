package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class TipoContato implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "NOME")
	private String nome;
	
	public TipoContato() {
		this.id = 0;
	}
	
	public TipoContato(int id, String nome) {
		this.id = id;
		this.nome = nome;
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

	@Override
	public String toString() {
		return "TipoContato [id=" + id + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoContato other = (TipoContato) obj;
		return id == other.id && Objects.equals(nome, other.nome);
	}
	
	
	
}
