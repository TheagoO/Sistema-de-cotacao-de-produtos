package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.ItemCotacaoDao;
import br.edu.unifacear.model.entity.ItemCotacao;

public class ItemCotacaoBo {
	
	public String salvar(ItemCotacao cotacaoItem) 
			throws Exception {
		validarDadosCotacaoItem(cotacaoItem);
		ItemCotacaoDao cotacaoItemDao = new ItemCotacaoDao();
		try {
			return cotacaoItemDao.salvar(cotacaoItem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(ItemCotacao cotacaoItem) 
			throws Exception {
		validarDadosCotacaoItem(cotacaoItem);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new ItemCotacaoDao().alterar(cotacaoItem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(ItemCotacao cotacaoItem) 
			throws Exception {
		validarDadosCotacaoItem(cotacaoItem);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new ItemCotacaoDao().deletar(cotacaoItem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<ItemCotacao> listar(String paramNome) throws Exception {
		try {
			return new ItemCotacaoDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	


	private void validarDadosCotacaoItem(ItemCotacao cotacaoItem) throws Exception {
//		if (cotacaoItem.getId() < 0) {
//			throw new Exception("Id do cotacaoItem n�o pode ser negativo!");
//		}
		if (cotacaoItem.getDisponibilidade().equals("")) {
			throw new Exception("Nome do cotacaoItem n�o pode ficar em branco!");
		}
	}	
	
}
