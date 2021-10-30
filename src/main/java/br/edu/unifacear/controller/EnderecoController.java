package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.model.entity.Endereco;

public class EnderecoController {
	
	private Endereco endereco;
	private List<Endereco> lista;
	
	
	public EnderecoController() {
		this.endereco = new Endereco();
		this.lista = new ArrayList<Endereco>();
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Endereco> getLista() {
		return lista;
	}
	public void setLista(List<Endereco> lista) {
		this.lista = lista;
	}
	
}
