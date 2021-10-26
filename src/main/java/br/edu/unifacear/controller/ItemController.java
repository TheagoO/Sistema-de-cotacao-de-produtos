package br.edu.unifacear.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.unifacear.model.bo.FiscalItemBo;
import br.edu.unifacear.model.bo.ItemBo;
import br.edu.unifacear.model.entity.FiscalItem;
import br.edu.unifacear.model.entity.Item;
import br.edu.unifacear.model.entity.Pais;

@ManagedBean(name = "BeanItem")
@ApplicationScoped
public class ItemController {
		
	public String salvar(Item item) {
		ItemBo ib = new ItemBo();
		FacesContext fc = FacesContext.getCurrentInstance();
	
		try {
			ib.salvar(item);
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar item", "ERROR"));
			e.printStackTrace();
		}
		
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item salvo com sucesso!", "SUCESSO"));
		return "Sucesso!";
	}
	
}
