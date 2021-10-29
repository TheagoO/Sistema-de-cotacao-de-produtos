package br.edu.unifacear.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.bo.AlmoxarifadoBo;
import br.edu.unifacear.model.entity.Almoxarifado;
import br.edu.unifacear.model.entity.Gestor;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "colaboradorBean")
@ApplicationScoped
public class ColaboradorController {

	private Almoxarifado almoxarifado;
	private Gestor gestor;
	private String senha;


	public String salvarAlmoxarifado() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {

			if (almoxarifado.getSenha().equals(senha)) {
				String retorno = facade.salvarAlmoxarifado(almoxarifado);
				if(retorno.contains("E-mail já cadastrado")) {
					fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "E-mail já cadastrado!"));
				}else {
					fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Colaborador salvo!"));
				}
				this.almoxarifado = new Almoxarifado();
			} else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Senha inválida!"));
			}

		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Erro ao salvar colaborador!"));
			e.printStackTrace();
		}

		return "sucesso";
	}

	public String salvarGestor() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			if (gestor.getSenha().equals(senha)) {
				String retorno = facade.salvarGestor(gestor);
				if(retorno.contains("E-mail já cadastrado")) {
					fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "E-mail já cadastrado!"));
				}else {
					fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Colaborador salvo!"));
				}
				this.gestor = new Gestor();
			} else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Senha inválida!"));
			}
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Erro ao salvar colaborador!"));
			e.printStackTrace();
		}

		return "sucesso";
	}
	
	
	
	
	public ColaboradorController() {
		this.almoxarifado = new Almoxarifado();
		this.gestor = new Gestor();
	}

	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}

	public Gestor getGestor() {
		return gestor;
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
