package br.edu.unifacear.model.facade;

import java.util.List;

import br.edu.unifacear.model.bo.AlmoxarifadoBo;
import br.edu.unifacear.model.bo.FiscalItemBo;
import br.edu.unifacear.model.bo.GestorBo;
import br.edu.unifacear.model.bo.ItemBo;
import br.edu.unifacear.model.entity.Almoxarifado;
import br.edu.unifacear.model.entity.FiscalItem;
import br.edu.unifacear.model.entity.Gestor;
import br.edu.unifacear.model.entity.Item;

public class GestaoFacade {

	private ItemBo itemBo;
	private FiscalItemBo fiscoItemBo;
	private AlmoxarifadoBo almoxarifadoBo;
	private GestorBo gestorBo;

	public GestaoFacade() {
		this.fiscoItemBo = new FiscalItemBo();
		this.itemBo = new ItemBo();
		this.almoxarifadoBo = new AlmoxarifadoBo();
		this.gestorBo = new GestorBo();
	}

	public void salvarItem(Item i) throws Exception {
		this.itemBo.salvar(i);
	}

	public List<Item> listarItens() throws Exception {
		return itemBo.listar("");
	}

	public String editarItem(Item i) throws Exception {
		return this.itemBo.alterar(i);
	}

	public String salvarAlmoxarifado(Almoxarifado a) throws Exception {
		return this.almoxarifadoBo.salvar(a);
	}

	public String salvarGestor(Gestor g) throws Exception {
		return this.gestorBo.salvar(g);
	}
}
