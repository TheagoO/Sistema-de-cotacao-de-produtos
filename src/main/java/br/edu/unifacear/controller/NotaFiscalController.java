package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.entity.NotaFiscal;
import br.edu.unifacear.model.entity.OrdemCompra;
import br.edu.unifacear.model.entity.OrdemCompraItem;
import br.edu.unifacear.model.entity.Requisicao;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "notaFiscalBean")
@ApplicationScoped
public class NotaFiscalController {
	
	private NotaFiscal notaFiscal;
	private List<NotaFiscal> notas;
	
	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			facade.salvarNotaFiscal(notaFiscal);
			this.notaFiscal = new NotaFiscal();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Ordem de compra enviada!"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao enviar ordem de compra"));
			e.printStackTrace();
		}

	}
	
	public void notasr() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.notas.removeAll(notas);
		try {
			this.notas = facade.listarNotaFiscal(0);
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Não foi encontrado registro de notas fiscal"));
			e.printStackTrace();
		}

	}
	
	public void lancarNotaFiscal(OrdemCompra oc) {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			facade.lancarNota(oc, this.notaFiscal);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Nota fiscal lançada!"));
			notaLancada(oc);
			this.notaFiscal = new NotaFiscal();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao lançar nota fiscal"));
			e.printStackTrace();
		}

	}
	
	public String notaLancada(OrdemCompra oc) {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		oc.getFase().setId(4);
		try {
			facade.editarOrdemCompra(oc);
			return "Lancado";
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao alterar ordem de compra"));
			e.printStackTrace();
		}
		return null;
	}
	
	public NotaFiscalController() {
		this.notaFiscal = new NotaFiscal();
		this.notas = new ArrayList<NotaFiscal>();
	}
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public List<NotaFiscal> getNotas() {
		return notas;
	}
	public void setNotas(List<NotaFiscal> notas) {
		this.notas = notas;
	}
	
	
	
}
