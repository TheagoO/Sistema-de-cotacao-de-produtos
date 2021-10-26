package br.edu.unifacear.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.edu.unifacear.controller.FiscalItemController;
import br.edu.unifacear.controller.ItemController;
import br.edu.unifacear.model.entity.FiscalItem;
import br.edu.unifacear.model.entity.Item;

@ManagedBean(name = "itemBean")
@ViewScoped
public class ItemBean {
	
	private FiscalItemController fiscalController;
	private Item item;
	
	public ItemBean() {
		this.item = new Item();
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public List<FiscalItem> getNcm() throws Exception{
		fiscalController = new FiscalItemController();
		return fiscalController.getListaNcm();
	}
	
	public String salvarItem() throws Exception{
		ItemController ic = new ItemController();	
		return ic.salvar(item);
	}
	
}
