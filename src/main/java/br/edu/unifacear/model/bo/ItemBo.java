package br.edu.unifacear.model.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.unifacear.model.dao.ItemDao;
import br.edu.unifacear.model.entity.Item;

public class ItemBo {

	public String salvar(Item item) throws Exception {
		validarDadosItem(item);
		ItemDao itemDao = new ItemDao();
		try {
			return itemDao.salvar(item);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String alterar(Item item) throws Exception {
		
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new ItemDao().alterar(item);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String deletar(Item item) throws Exception {
		
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
		
		
		
		if(item.getCodigo() < 13) {
			throw new Exception("Código inválido");
		}
		
	}

}
