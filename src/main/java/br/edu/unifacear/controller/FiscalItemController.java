package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.bo.FiscalItemBo;
import br.edu.unifacear.model.entity.FiscalItem;

@ManagedBean(name = "fiscalItemBean")
@SessionScoped
public class FiscalItemController {

	private FiscalItem fisco;
	private List<FiscalItem> lista;

	public void listar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		this.lista.removeAll(lista);
		try {
			FiscalItemBo fib = new FiscalItemBo();

			for (FiscalItem f : fib.listar("")) {
				lista.add(f);
			}

		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foram encontrados nenhum registro de NCM", "ERROR"));
			e.printStackTrace();
		}

	}

	public FiscalItemController() {
		this.fisco = new FiscalItem();
		this.lista = new ArrayList<FiscalItem>();
		listar();
	}

	public FiscalItem getFisco() {
		return fisco;
	}

	public void setFisco(FiscalItem fisco) {
		this.fisco = fisco;
	}

	public List<FiscalItem> getLista() {
		return lista;
	}

	public void setLista(List<FiscalItem> lista) {
		this.lista = lista;
	}

}
