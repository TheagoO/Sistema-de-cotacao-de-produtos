package br.edu.unifacear.model.entity;

import java.util.Objects;

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
	
	@ManyToOne
	private Estado estado;
	
	public Cidade() {
		
	}
	
	public Cidade(int id, String nome, int codigo, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.estado = estado;
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
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", codigo=" + codigo + ", estado=" + estado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, estado, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		return codigo == other.codigo && Objects.equals(estado, other.estado) && id == other.id
				&& Objects.equals(nome, other.nome);
	}
	
	

}
