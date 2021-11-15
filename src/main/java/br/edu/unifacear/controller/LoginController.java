package br.edu.unifacear.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.entity.Almoxarifado;
import br.edu.unifacear.model.entity.Gestor;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginController {
	
	private Almoxarifado almoxarifado;
	private Gestor gestor;
	private String selecionado;
	private String email;
	private String senha;
	
	public String validarLogin() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		if(this.selecionado != null) {
			if(this.selecionado.contains("almoxarifado")) {	
				this.almoxarifado.setEmail(email);
				this.almoxarifado.setSenha(senha);
				try {
					if(!facade.listarAlmoxarifado(email).isEmpty()) {
						List<Almoxarifado> almox = facade.listarAlmoxarifado(email);
						for(Almoxarifado a : almox) {
							if(a.getSenha().contains(senha)) {
								fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Login efetuado"));
								this.almoxarifado = a;
								return "Almoxarifado";
							}
						}
						fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Dados inválidos"));
					}else {
						fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Dados inválidos"));
					}
				} catch (Exception e) {
					fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao validar colaborador"));
					e.printStackTrace();
				}
			}else {
				this.gestor.setEmail(email);
				this.gestor.setSenha(senha);
				try {
					if(!facade.listarGestor(email).isEmpty()) {
						List<Gestor> gest = facade.listarGestor(email);
						for(Gestor g : gest) {
							if(g.getSenha().contains(senha)) {
								fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Login efetuado"));
								this.gestor = g;
								return "Gestor";
							}
						}
						fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Dados inválidos"));
					}else {
						fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Dados inválidos"));
					}
				} catch (Exception e) {
					fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao validar colaborador"));
					e.printStackTrace();
				}
			}
		}else {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Selecione um tipo de colaborador"));
		}
		return null;
	}
	
	public String validarAdmin() {
		FacesContext fc = FacesContext.getCurrentInstance();
		
		if(this.email.contains("admin") && this.senha.contains("admin")) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Login efetuado"));
			return "Admin";
		}else {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Dados inválidos"));
		}
		return null;
	}
	
	public LoginController() {
		this.almoxarifado = new Almoxarifado();
		this.gestor = new Gestor();
		this.email = "";
		this.senha = "";
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
	public String getSelecionado() {
		return selecionado;
	}
	public void setSelecionado(String selecionado) {
		this.selecionado = selecionado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
		
}
