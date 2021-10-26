package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.bo.PaisBo;
import br.edu.unifacear.model.entity.Pais;

public class PaisController {
	
	public String salvar(Pais pais) {
		PaisBo pb = new PaisBo();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			pb.salvar(pais);
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar origem", "ERROR"));
			e.printStackTrace();
		}
		
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Origem salva com sucesso!", "SUCESSO"));
		return "Sucesso!";
	}
	
	public List<Pais> listarPais() {
		PaisBo pb = new PaisBo();
		FacesContext fc = FacesContext.getCurrentInstance();
		List<Pais> lista = new ArrayList<Pais>();
		
		try {
			
			for(Pais p : pb.listar("")) {
				lista.add(p);
			}
			
		}catch(Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao listar origem", "ERROR"));
			e.printStackTrace();
		}
		
		
		return lista;
		
	}
	
}
