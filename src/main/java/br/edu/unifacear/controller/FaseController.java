package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.entity.Almoxarifado;
import br.edu.unifacear.model.entity.Fase;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "faseBean")
@ApplicationScoped
public class FaseController {
	
	private Fase fase;
	private Fase selecionado;
	private List<Fase> lista;
	
	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.removeAll(lista);
		try {
			this.lista = facade.listarFase(0);
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar Status"));
			e.printStackTrace();
		}

	}
	
	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {

			facade.salvarFase(fase);
			this.fase = new Fase();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Status salvo!"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Erro ao salvar colaborador!"));
			e.printStackTrace();
		}

	}
	
	public FaseController() {
		this.fase = new Fase();
		this.selecionado = new Fase();
		this.lista = new ArrayList<Fase>();
		listar();
	}
	public Fase getFase() {
		return fase;
	}
	public void setFase(Fase fase) {
		this.fase = fase;
	}
	public Fase getSelecionado() {
		return selecionado;
	}
	public void setSelecionado(Fase selecionado) {
		this.selecionado = selecionado;
	}
	public List<Fase> getLista() {
		return lista;
	}
	public void setLista(List<Fase> lista) {
		this.lista = lista;
	}
	
	
	
}
