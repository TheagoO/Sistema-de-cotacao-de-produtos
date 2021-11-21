package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Cotacao;
import br.edu.unifacear.model.entity.Requisicao;
import br.edu.unifacear.model.entity.Cotacao;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "cotacaoBean")
@ApplicationScoped
public class CotacaoController {
	
	private Cotacao cotacao;
	private Cotacao selecionado;
	private List<Cotacao> lista;
	
	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {

			facade.salvarCotacao(cotacao);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Cotacão salva!"));
			this.cotacao = new Cotacao();
			listar();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Erro ao salvar cotação!"));
			e.printStackTrace();
		}

	}
	
	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.removeAll(lista);
		try {
			this.lista = facade.listarCotacao(0);
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar cotação"));
			e.printStackTrace();
		}

	}
	
	public void editar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			String retorno = facade.editarCotacao(cotacao);
			if(retorno.contains("Nome em branco") || retorno.contains("E-mail em branco")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Preencha os campos!"));
			}else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Cotação editada!"));
				listar();
			}
			this.cotacao = new Cotacao();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar cotação"));
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirCotacao(this.selecionado);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Cotação deletada"));
			listar();
			this.selecionado = new Cotacao();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir cotação"));
			e.printStackTrace();
		}
	}
	
	public void lancaCotacao(Cotacao c) {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.salvarCotacao(c);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Cotação lançada!"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao lançar cotação"));
			e.printStackTrace();
		}
	}
		
	public void onRowEdit(RowEditEvent<Cotacao> event) {
		Cotacao novo = new Cotacao();

		for (Cotacao a : this.lista) {
			if (a.getId() == event.getObject().getId()) {
				novo = a;
			}
		}

		if (event.getObject() != null) {
			try {
				this.cotacao = novo;
				editar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void onRowCancel(RowEditEvent<Cotacao> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Edição cancelada!"));
	}
	
	
	public CotacaoController() {
		this.cotacao = new Cotacao();
		this.lista = new ArrayList<Cotacao>();
		this.selecionado = new Cotacao();
		listar();
	}
	
	public Cotacao getCotacao() {
		return cotacao;
	}
	public void setCotacao(Cotacao cotacao) {
		this.cotacao = cotacao;
	}
	public List<Cotacao> getLista() {
		return lista;
	}
	public void setLista(List<Cotacao> lista) {
		this.lista = lista;
	}
	public Cotacao getSelecionado() {
		return selecionado;
	}
	public void setSelecionado(Cotacao selecionado) {
		this.selecionado = selecionado;
	}
	
	
	
}
