package br.edu.unifacear.model.facade;

import java.util.List;

import br.edu.unifacear.model.bo.FiscalItemBo;
import br.edu.unifacear.model.bo.ItemBo;
import br.edu.unifacear.model.entity.FiscalItem;
import br.edu.unifacear.model.entity.Item;

public class GestaoFacade {
	
	private ItemBo itemBo;
	private FiscalItemBo fiscoItemBo;
	
	public GestaoFacade() {
		this.fiscoItemBo = new FiscalItemBo();
		this.itemBo = new ItemBo();
	}
	
	public void salvarItem(Item i) throws Exception {
		this.itemBo.salvar(i);
	}
	
	public List<Item> listarItens() throws Exception {
		try {
			return itemBo.listar("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
