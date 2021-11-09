package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Cidade;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "cidadeBean")
@SessionScoped
public class CidadeController {
	
	private Cidade cidade;
	private Cidade selecionado;
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
	
	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.removeAll(lista);
		try {
			for (Cidade c : facade.listarCidade("")) {
				this.lista.add(c);
			}
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar cidades"));
			e.printStackTrace();
		}
	}
	
	public void editar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			String retorno = facade.editarCidade(cidade);
			if(retorno.contains("Nome em branco")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Preencha os campos!"));
			}else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Cidade editada!"));
				listar();
			}
			this.cidade = new Cidade();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar cidade"));
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirCidade(this.selecionado);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Cidade deletada!"));
			listar();
			this.selecionado = new Cidade();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir cidade"));
			e.printStackTrace();
		}
	}
	
	public void onRowEdit(RowEditEvent<Cidade> event) {
		Cidade novo = new Cidade();

		for (Cidade a : this.lista) {
			if (a.getId() == event.getObject().getId()) {
				novo = a;
			}
		}

		if (event.getObject() != null) {
			try {
				this.cidade = novo;
				editar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void onRowCancel(RowEditEvent<Cidade> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Edição cancelada!"));
	}
	
	public CidadeController() {
		this.cidade = new Cidade();
		this.lista = new ArrayList<Cidade>();
		this.selecionado = new Cidade();
		listar();		
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

	public Cidade getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Cidade selecionado) {
		this.selecionado = selecionado;
	}
	
	
}
