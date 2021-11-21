package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.entity.NotaFiscalItem;
import br.edu.unifacear.model.entity.OrdemCompra;
import br.edu.unifacear.model.entity.Requisicao;
import br.edu.unifacear.model.entity.RequisicaoItem;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "notaFiscalItemBean")
@ApplicationScoped
public class NotaFiscalItemController {
	
	private NotaFiscalItem fiscalItem;
	private List<NotaFiscalItem> lista;
	private OrdemCompra ordem;
	
	
	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			facade.salvarNotaFiscalItem(fiscalItem);
			this.fiscalItem = new NotaFiscalItem();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Fiscal item salvo!"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao salvar fiscal item"));
			e.printStackTrace();
		}

	}
	
	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.removeAll(lista);
		try {
			this.lista = facade.listarNotaFiscalItem(0);
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar fiscal item"));
			e.printStackTrace();
		}

	}
	
	public NotaFiscalItemController() {
		this.fiscalItem = new NotaFiscalItem();
		this.lista = new ArrayList<NotaFiscalItem>();
		this.ordem = new OrdemCompra();
		listar();
	}

	public NotaFiscalItem getFiscalItem() {
		return fiscalItem;
	}

	public void setFiscalItem(NotaFiscalItem fiscalItem) {
		this.fiscalItem = fiscalItem;
	}


	public List<NotaFiscalItem> getLista() {
		return lista;
	}


	public void setLista(List<NotaFiscalItem> lista) {
		this.lista = lista;
	}

	public OrdemCompra getOrdem() {
		return ordem;
	}

	public void setOrdem(OrdemCompra ordem) {
		this.ordem = ordem;
	}

}
