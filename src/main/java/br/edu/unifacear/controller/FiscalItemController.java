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
	private List<FiscalItem> ncm;

	public void listarNcm() {
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			FiscalItemBo fib = new FiscalItemBo();

			for (FiscalItem f : fib.listar("")) {
				ncm.add(f);
			}

		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao listar NCM", "ERROR"));
			e.printStackTrace();
		}

	}

	public FiscalItemController() {
		this.fisco = new FiscalItem();
		this.ncm = new ArrayList<FiscalItem>();
		listarNcm();
	}

	public FiscalItem getFisco() {
		return fisco;
	}

	public void setFisco(FiscalItem fisco) {
		this.fisco = fisco;
	}

	public List<FiscalItem> getNcm() {
		return ncm;
	}

	public void setNcm(List<FiscalItem> ncm) {
		this.ncm = ncm;
	}

}
