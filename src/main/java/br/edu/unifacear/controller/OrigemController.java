package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.bo.OrigemBo;
import br.edu.unifacear.model.entity.Origem;

@ManagedBean(name = "origemBean")
@SessionScoped
public class OrigemController {

	private Origem origem;
	private List<Origem> lista;
	
	public String salvar() {
		OrigemBo ob = new OrigemBo();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			ob.salvar(origem);
			this.origem = new Origem();
			listar();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Origem salva com sucesso!", "SUCESSO"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar origem", "ERRO"));
		}

		
		return "Sucesso!";
	}

	public void listar() {
		OrigemBo ob = new OrigemBo();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.removeAll(lista);
		try {
			for (Origem p : ob.listar("")) {
				this.lista.add(p);
			}
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao listar origem", "ERRO"));
			e.printStackTrace();
		}

	}
	
	public OrigemController() {
		this.origem = new Origem();
		this.lista = new ArrayList<Origem>();
		listar();
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}
	
	public List<Origem> getLista() {
		return lista;
	}

	public void setLista(List<Origem> origem) {
		this.lista = origem;
	}

}
