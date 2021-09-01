package br.edu.unifacear.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.unifacear.entity.Item;
import br.edu.unifacear.dao.ItemDao;

public class ItemBo {
	
	public String salvar(Item item) 
			throws Exception {
		validarDadosItem(item);
		ItemDao itemDao = new ItemDao();
		try {
			return itemDao.salvar(item);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Item item) 
			throws Exception {
		validarDadosItem(item);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new ItemDao().alterar(item);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Item item) 
			throws Exception {
		validarDadosItem(item);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new ItemDao().deletar(item);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Item> listar(String paramNome) throws Exception {
		try {
			return new ItemDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	

	private void validarDadosItem(Item item) throws Exception {
//		if (item.getId() < 0) {
//			throw new Exception("Id do item não pode ser negativo!");
//		}
		if (item.getNome().equals("")) {
			throw new Exception("Nome do item não pode ficar em branco!");
		}
	}	
	
}
