package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.bo.PaisBo;
import br.edu.unifacear.model.entity.Pais;

@ManagedBean(name = "paisBean")
@SessionScoped
public class PaisController {

	private Pais pais;
	private List<Pais> origem;
	
	public String salvar() {
		PaisBo pb = new PaisBo();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			pb.salvar(pais);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Origem salva com sucesso!", "SUCESSO"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar origem", e.getMessage()));
		}

		
		return "Sucesso!";
	}

	public void listarOrigem() {
		PaisBo pb = new PaisBo();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			for (Pais p : pb.listar("")) {
				this.origem.add(p);
			}
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao listar origem", "ERROR"));
			e.printStackTrace();
		}

	}
	
	public PaisController() {
		this.pais = new Pais();
		this.origem = new ArrayList<Pais>();
		listarOrigem();
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	public List<Pais> getOrigem() {
		return origem;
	}

	public void setOrigem(List<Pais> origem) {
		this.origem = origem;
	}

}
