package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.entity.Endereco;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "enderecoBean")
@SessionScoped
public class EnderecoController {

	private Endereco endereco;
	private Endereco selecionado;
	private List<Endereco> lista;

	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			facade.salvarEndereco(endereco);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Endereço salvo!"));

		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Erro ao salvar endereço!"));
			e.printStackTrace();
		}

	}

	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.removeAll(lista);
		try {
			this.lista = facade.listarEndereco("");
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar endereço"));
			e.printStackTrace();
		}

	}

	public void editar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Endereço editado!"));
			listar();
			this.endereco = new Endereco();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar endereço"));
			e.printStackTrace();
		}
	}

	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirEndereco(this.selecionado);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Endereço deletado"));
			listar();
			this.selecionado = new Endereco();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir endereço"));
			e.printStackTrace();
		}
	}

	public EnderecoController() {
		this.endereco = new Endereco();
		this.selecionado = new Endereco();
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

	public Endereco getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Endereco selecionado) {
		this.selecionado = selecionado;
	}

}
