package br.edu.unifacear.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.entity.NotaFiscalItem;
import br.edu.unifacear.model.entity.Requisicao;
import br.edu.unifacear.model.entity.RequisicaoItem;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "notaItemBean")
@ApplicationScoped
public class NotaFiscalItemController {
	
	private NotaFiscalItem nfItem;
	private Requisicao ordem;
	
	
	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			facade.salvarNotaFiscalItem(nfItem);
			this.nfItem = new NotaFiscalItem();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Ordem de compra enviada!"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao enviar ordem de compra"));
			e.printStackTrace();
		}

	}
	
	
	public NotaFiscalItemController() {
		this.nfItem = new NotaFiscalItem();
		this.ordem = new Requisicao();
	}

	public NotaFiscalItem getNfItem() {
		return nfItem;
	}

	public void setNfItem(NotaFiscalItem nfItem) {
		this.nfItem = nfItem;
	}

	public Requisicao getOrdem() {
		return ordem;
	}

	public void setOrdem(Requisicao ordem) {
		this.ordem = ordem;
	}
	
	
	
}
