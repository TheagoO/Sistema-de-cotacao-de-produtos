package br.edu.unifacear.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.bo.CidadeBo;
import br.edu.unifacear.model.entity.Cidade;

public class CidadeController {
	
	private Cidade cidade;
	
	public CidadeController() {
		this.cidade = new Cidade();
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public String salvar() {
		CidadeBo cb = new CidadeBo();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			cb.salvar(cidade);
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar cidade", "ERROR"));
			e.printStackTrace();
		}
		
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cidade salva com sucesso!", "SUCESSO"));
		return "Sucesso!";
	}
}
