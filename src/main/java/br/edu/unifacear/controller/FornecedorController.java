package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Endereco;
import br.edu.unifacear.model.entity.Fornecedor;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "fornecedorBean")
@SessionScoped
public class FornecedorController {

	private Fornecedor fornecedor;
	private Fornecedor selecionado;
	private List<Fornecedor> lista;
	private Endereco endereco;

	public String salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {

			String retorno = facade.salvarFornecedor(fornecedor, endereco);
			if (retorno.contains("CNPJ j� cadastrado")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "CNPJ j� cadastrado!"));
			} else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Colaborador salvo!"));
			}

			this.endereco = new Endereco();
			this.fornecedor = new Fornecedor();

		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Erro ao salvar colaborador!"));
			e.printStackTrace();
		}

		return "sucesso";
	}

	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.clear();
		try {
			this.lista = facade.listarFornecedor("");
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar colaboradores"));
			e.printStackTrace();
		}

	}

	public void editar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			String retorno = facade.editarFornecedor(fornecedor);
			if (retorno.contains("Dados em branco")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Preencha os campos!"));
			} else {
				listar();
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Colaborador editado!"));
			}
			this.fornecedor = new Fornecedor();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar colaborador"));
			e.printStackTrace();
		}
	}

	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirFornecedor(this.selecionado);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Colaborador deletado"));
			listar();
			this.selecionado = new Fornecedor();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir colaborador"));
			e.printStackTrace();
		}
	}

	public void onRowEdit(RowEditEvent<Fornecedor> event) {
		Fornecedor novo = new Fornecedor();

		for (Fornecedor f : this.lista) {
			if (f.getId() == event.getObject().getId()) {
				novo = f;
			}
		}

		if (event.getObject() != null) {
			try {
				this.fornecedor = novo;
				editar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void onRowCancel(RowEditEvent<Fornecedor> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Edi��o cancelada!"));
	}

	public FornecedorController() {
		this.fornecedor = new Fornecedor();
		this.lista = new ArrayList<Fornecedor>();
		this.selecionado = new Fornecedor();
		this.endereco = new Endereco();
		listar();
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getLista() {
		return lista;
	}

	public void setLista(List<Fornecedor> lista) {
		this.lista = lista;
	}

	public Fornecedor getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Fornecedor selecionado) {
		this.selecionado = selecionado;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
