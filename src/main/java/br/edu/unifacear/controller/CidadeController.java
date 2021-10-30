package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.entity.Cidade;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "cidadeBean")
@ApplicationScoped
public class CidadeController {
	
	private Cidade cidade;
	private List<Cidade> lista;
	
	
	public String salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			facade.salvarCidade(cidade);
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar cidade", "ERROR"));
			e.printStackTrace();
		}
		
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cidade salva com sucesso!", "SUCESSO"));
		return "Sucesso!";
	}
	
	
	
	public CidadeController() {
		this.cidade = new Cidade();
		this.lista = new ArrayList<Cidade>();
		
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public List<Cidade> getLista() {
		return lista;
	}

	public void setLista(List<Cidade> lista) {
		this.lista = lista;
	}
}
