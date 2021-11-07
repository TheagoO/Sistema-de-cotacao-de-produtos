package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.edu.unifacear.model.entity.Cotacao;

@ManagedBean(name = "cotacaoBean")
@ApplicationScoped
public class CotacaoController {
	
	private Cotacao cotacao;
	private Cotacao selecionado;
	private List<Cotacao> lista;
		
	public CotacaoController() {
		this.cotacao = new Cotacao();
		this.lista = new ArrayList<Cotacao>();
		this.selecionado = new Cotacao();
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
