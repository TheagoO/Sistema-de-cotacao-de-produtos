package br.edu.unifacear.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Fornecedor implements Serializable {
	
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
	
	@Column(name = "CONTATO")
	private String contato;
	
	@Column(name = "ENDERECO")
	@OneToOne
	private Endereco endereco;
	
	public Fornecedor() {
		this.id = 0;
		this.endereco = new Endereco();
	}
	
	public Fornecedor(int id, String nome, String empresa, String cnpj, String email, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.empresa = empresa;
		this.cnpj = cnpj;
		this.email = email;
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
		
	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", nome=" + nome + ", empresa=" + empresa + ", cnpj=" + cnpj + ", email="
				+ email + ", contato=" + contato + ", endereco=" + endereco + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, contato, email, empresa, endereco, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(contato, other.contato)
				&& Objects.equals(email, other.email) && Objects.equals(empresa, other.empresa)
				&& Objects.equals(endereco, other.endereco) && id == other.id && Objects.equals(nome, other.nome);
	}

}
