package br.edu.unifacear.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.bo.AlmoxarifadoBo;
import br.edu.unifacear.model.entity.Almoxarifado;

@ManagedBean(name = "BeanAlmoxarifado")
@ApplicationScoped
public class AlmoxarifadoController {
	
	private Almoxarifado almoxarifado;
	
	public AlmoxarifadoController() {
		this.almoxarifado = new Almoxarifado();
	}

	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}
	
	public String salvar() {
		AlmoxarifadoBo ab = new AlmoxarifadoBo();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			ab.salvar(almoxarifado);
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar colaborador!", "ERROR"));
			e.printStackTrace();
		}
		
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Colaborador salvo com sucesso!", "SUCESSO"));
		
		return "sucesso";
	}

}
