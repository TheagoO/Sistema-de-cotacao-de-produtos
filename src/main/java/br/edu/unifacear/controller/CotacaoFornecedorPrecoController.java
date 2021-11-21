package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Cotacao;
import br.edu.unifacear.model.entity.CotacaoFornecedorPreco;
import br.edu.unifacear.model.entity.CotacaoItem;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "cotacaoFornecedorPrecoBean")
@ApplicationScoped
public class CotacaoFornecedorPrecoController {
	
	private CotacaoFornecedorPreco cotacaoPreco;
	private CotacaoFornecedorPreco selecionado;
	private List<CotacaoFornecedorPreco> lista;
	private List<CotacaoFornecedorPreco> listCotacao;
	private int cotacao;
	
	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.removeAll(lista);
		try {
			this.lista = facade.listarCotacaoFornecedorPreco("");
			
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar cotação"));
			e.printStackTrace();
		}

	}
	
	public void listarCotacaoFornecedor() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		List<CotacaoFornecedorPreco> novaLista = new ArrayList<CotacaoFornecedorPreco>();
		List<CotacaoItem> ci = new ArrayList<CotacaoItem>();
		
		
		
		try {
			ci = facade.listarItensCotacao(this.cotacao);
			CotacaoItem id = ci.get(0);
			
			this.listCotacao = facade.listarCotacaoFornecedor(id.getId());
			
			for(CotacaoFornecedorPreco cfp : this.listCotacao) {
				for(CotacaoItem cotacao : ci) {
					if(cfp.getCotacaoItem().getId() == cotacao.getId()) {
						cfp.setCotacaoItem(cotacao);
						novaLista.add(cfp);
					}
				}
			}
			
			this.listCotacao = novaLista;
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "DEU BOA"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void onRowEdit(RowEditEvent<CotacaoFornecedorPreco> event) {
		CotacaoFornecedorPreco novo = new CotacaoFornecedorPreco();

		for (CotacaoFornecedorPreco a : this.lista) {
			if (a.getId() == event.getObject().getId()) {
				novo = a;
			}
		}

		if (event.getObject() != null) {
			try {
				this.cotacaoPreco = novo;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void onRowCancel(RowEditEvent<CotacaoFornecedorPreco> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Edição cancelada!"));
	}
	
	
	public CotacaoFornecedorPrecoController() {
		this.selecionado = new CotacaoFornecedorPreco();
		this.selecionado = new CotacaoFornecedorPreco();
		this.lista = new ArrayList<CotacaoFornecedorPreco>();
		this.listCotacao = new ArrayList<CotacaoFornecedorPreco>();
		listar();
	}
	public CotacaoFornecedorPreco getCotacaoPreco() {
		return cotacaoPreco;
	}
	public void setCotacaoPreco(CotacaoFornecedorPreco cotacaoPreco) {
		this.cotacaoPreco = cotacaoPreco;
	}
	public CotacaoFornecedorPreco getSelecionado() {
		return selecionado;
	}
	public void setSelecionado(CotacaoFornecedorPreco selecionado) {
		this.selecionado = selecionado;
	}
	public List<CotacaoFornecedorPreco> getLista() {
		return lista;
	}
	public void setLista(List<CotacaoFornecedorPreco> lista) {
		this.lista = lista;
	}
	
	public int getCotacao() {
		return cotacao;
	}

	public void setCotacao(int cotacao) {
		this.cotacao = cotacao;
	}

	public List<CotacaoFornecedorPreco> getListCotacao() {
		return listCotacao;
	}

	public void setListCotacao(List<CotacaoFornecedorPreco> listCotacao) {
		this.listCotacao = listCotacao;
	}
	
	
	
	
}
