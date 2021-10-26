package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.edu.unifacear.model.bo.FiscalItemBo;
import br.edu.unifacear.model.entity.FiscalItem;

public class FiscalItemController {
		
	public List<FiscalItem> getListaNcm() {
		FacesContext fc = FacesContext.getCurrentInstance();
		List<FiscalItem> lista = new ArrayList<FiscalItem>();
		
		try {
			FiscalItemBo fib = new FiscalItemBo();
			List<FiscalItem> fi = fib.listar("");
			
			if(!fi.isEmpty()) {
				for(FiscalItem f : fi) {
					lista.add(f);
				}
			}

		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao listar NCM", "ERROR"));
			e.printStackTrace();
		}
		
		return lista;
	}
	
}
