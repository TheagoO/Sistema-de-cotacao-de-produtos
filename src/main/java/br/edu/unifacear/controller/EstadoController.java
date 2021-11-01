package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.entity.Estado;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "estadoBean")
@SessionScoped
public class EstadoController {
	
	private Estado estado;
	private List<Estado> lista;
	
	public String salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			facade.salvarEstado(estado);
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar estado", "ERROR"));
			e.printStackTrace();
		}
		
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Estado salva com sucesso!", "SUCESSO"));
		return "Sucesso!";
	}
	
	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.removeAll(lista);
		
		try {
			for (Estado e : facade.listarEstado()) {
				this.lista.add(e);
			}
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar estados"));
			e.printStackTrace();
		}
	}
	
	public EstadoController() {
		this.estado = new Estado();
		this.lista = new ArrayList<Estado>();
		listar();
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
