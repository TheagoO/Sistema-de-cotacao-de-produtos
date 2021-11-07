package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Almoxarifado;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "almoxarifadoBean")
@ApplicationScoped
public class AlmoxarifadoController {
	
	private Almoxarifado almoxarifado;
	private Almoxarifado selecionado;
	private String senha;
	private List<Almoxarifado> lista;
	
	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {

			if (almoxarifado.getSenha().equals(senha)) {
				String retorno = facade.salvarAlmoxarifado(almoxarifado);
				if(retorno.contains("E-mail j� cadastrado")) {
					fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "E-mail j� cadastrado!"));
				}else {
					fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Colaborador salvo!"));
				}
				this.almoxarifado = new Almoxarifado();
			} else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Senha inv�lida!"));
			}

		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Erro ao salvar colaborador!"));
			e.printStackTrace();
		}

	}
	
	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.removeAll(lista);
		try {
			this.lista = facade.listarAlmoxarifado("");
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar colaboradores"));
			e.printStackTrace();
		}

	}
	
	public void editar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			String retorno = facade.editarAlmoxarifado(almoxarifado);
			if(retorno.contains("Nome em branco") || retorno.contains("E-mail em branco")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Preencha os campos!"));
			}else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Colaborador editado!"));
				listar();
			}
			this.almoxarifado = new Almoxarifado();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar colaborador"));
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirAlmoxarifado(this.selecionado);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Colaborador deletado"));
			listar();
			this.selecionado = new Almoxarifado();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir colaborador"));
			e.printStackTrace();
		}
	}
	
	public void onRowEdit(RowEditEvent<Almoxarifado> event) {
		Almoxarifado novo = new Almoxarifado();

		for (Almoxarifado a : this.lista) {
			if (a.getId() == event.getObject().getId()) {
				novo = a;
			}
		}

		if (event.getObject() != null) {
			try {
				this.almoxarifado = novo;
				editar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void onRowCancel(RowEditEvent<Almoxarifado> event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Edi��o cancelada!"));
	}
	
	public AlmoxarifadoController() {
		this.almoxarifado = new Almoxarifado();
		this.lista = new ArrayList<Almoxarifado>();
		this.selecionado = new Almoxarifado();
		listar();
	}

	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}

	public Almoxarifado getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Almoxarifado selecionado) {
		this.selecionado = selecionado;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Almoxarifado> getLista() {
		return lista;
	}

	public void setLista(List<Almoxarifado> lista) {
		this.lista = lista;
	}

	
}
