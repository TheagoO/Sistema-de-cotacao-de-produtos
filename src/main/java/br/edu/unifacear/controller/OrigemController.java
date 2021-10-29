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
	private List<Origem> origens;
	
	public String salvar() {
		OrigemBo ob = new OrigemBo();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			ob.salvar(origem);
			this.origem = new Origem();
			listarOrigem();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Origem salva com sucesso!", "SUCESSO"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar origem", "ERRO"));
		}

		
		return "Sucesso!";
	}

	public void listarOrigem() {
		OrigemBo ob = new OrigemBo();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.origens.removeAll(origens);
		try {
			for (Origem p : ob.listar("")) {
				this.origens.add(p);
			}
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao listar origem", "ERRO"));
			e.printStackTrace();
		}

	}
	
	public OrigemController() {
		this.origem = new Origem();
		this.origens = new ArrayList<Origem>();
		listarOrigem();
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}
	
	public List<Origem> getOrigens() {
		return origens;
	}

	public void setOrigens(List<Origem> origem) {
		this.origens = origem;
	}

}
