package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.entity.NotaFiscal;
import br.edu.unifacear.model.entity.Requisicao;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "notaFiscalBean")
@ApplicationScoped
public class NotaFiscalController {
	
	private NotaFiscal notaFiscal;
	private List<NotaFiscal> notas;
	
	private Requisicao itemNf;
	
	
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
