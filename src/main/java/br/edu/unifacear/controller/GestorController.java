package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Gestor;
import br.edu.unifacear.model.entity.Item;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "gestorBean")
@SessionScoped
public class GestorController {
	
	private Gestor gestor;
	private String senha;
	private List<Gestor> lista;
	
	public String salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			if (gestor.getSenha().equals(senha)) {
				String retorno = facade.salvarGestor(gestor);
				if(retorno.contains("E-mail já cadastrado")) {
					fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "E-mail já cadastrado!"));
				}else {
					fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Colaborador salvo!"));
				}
				this.gestor = new Gestor();
			} else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Senha inválida!"));
			}
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Erro ao salvar colaborador!"));
			e.printStackTrace();
		}

		return "sucesso";
	}
	
	public void listar(){
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.removeAll(lista);
		try {
			for (Gestor g : facade.listarGestor()) {
				this.lista.add(g);
			}
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar colaboradores"));
			e.printStackTrace();
		}

	}
	
	public void editar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			String retorno = facade.editarGestor(this.gestor);
			if(retorno.contains("Dados em branco")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Preencha os campos!"));
			}else {
				listar();
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Colaborador editado!"));
			}
			this.gestor = new Gestor();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar colaborador"));
			e.printStackTrace();
		}
	}
	
	public void onRowEdit(RowEditEvent<Gestor> event) {
		Gestor novo = new Gestor();

		for (Gestor g : this.lista) {
			if (g.getId() == event.getObject().getId()) {
				novo = g;
			}
		}

		if (event.getObject() != null) {
			try {
				this.gestor = novo;
				editar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void onRowCancel(RowEditEvent<Gestor> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Edição cancelada!"));
	}
	
	public GestorController() {
		this.gestor = new Gestor();
		this.lista = new ArrayList<Gestor>();
		listar();
	}

	public Gestor getGestor() {
		return gestor;
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Gestor> getLista() {
		return lista;
	}

	public void setLista(List<Gestor> lista) {
		this.lista = lista;
	}
	
}
