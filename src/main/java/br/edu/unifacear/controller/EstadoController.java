package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.edu.unifacear.model.entity.Estado;

@ManagedBean(name = "estadoBean")
@ApplicationScoped
public class EstadoController {
	
	private Estado estado;
	private List<Estado> lista;
	
	public EstadoController() {
		this.estado = new Estado();
		this.lista = new ArrayList<Estado>();
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getLista() {
		return lista;
	}

	public void setLista(List<Estado> lista) {
		this.lista = lista;
	}
	
	
}
