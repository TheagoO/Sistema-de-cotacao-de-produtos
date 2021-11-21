package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Fornecedor;
import br.edu.unifacear.model.entity.Gestor;
import br.edu.unifacear.model.entity.RequisicaoItem;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "gestorBean")
@SessionScoped
public class GestorController {
	
	private Gestor gestor;
	private String senha;
	private Gestor gestorSelecionado;
	private List<Gestor> lista;
	private List<String> itens;
	private Fornecedor fornecedor;
	
	public String salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			if (gestor.getSenha().equals(senha)) {
				String retorno = facade.salvarGestor(gestor);
				if(retorno.contains("E-mail já cadastrado")) {
					fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "E-mail já cadastrado!"));
				}else {
					fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Gestor cadastrado!"));
				}
				this.gestor = new Gestor();
			} else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Senha inválida!"));
			}
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Erro ao cadastrar Gestor!"));
			e.printStackTrace();
		}

		return "sucesso";
	}
	
	public void listar(){
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.removeAll(lista);
		try {
			this.lista = facade.listarGestor("");
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Não foram encontrado registro de Gestor cadastrado!"));
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
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Gestor alterado!"));
				listar();
			}
			this.gestor = new Gestor();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao alterar dados do Gestor"));
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirGestor(this.gestorSelecionado);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Gestor excluido"));
			this.gestorSelecionado = new Gestor();
			listar();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Não foi possível excluir o Gestor"));
			e.printStackTrace();
		}
	}
	
	public void addItem(String i) {
		this.itens.add(i);
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
		this.gestorSelecionado = new Gestor();
		this.fornecedor = new Fornecedor();
		this.itens = new ArrayList<String>();
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

	public Gestor getGestorSelecionado() {
		return gestorSelecionado;
	}

	public void setGestorSelecionado(Gestor gestorSelecionado) {
		this.gestorSelecionado = gestorSelecionado;
	}

	public List<String> getItens() {
		return itens;
	}

	public void setItens(List<String> itens) {
		this.itens = itens;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}


}
