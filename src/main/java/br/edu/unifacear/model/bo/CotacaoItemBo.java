package br.edu.unifacear.model.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.unifacear.model.dao.CotacaoItemDao;
import br.edu.unifacear.model.entity.CotacaoItem;

public class CotacaoItemBo {
	
	public String salvar(CotacaoItem cotacaoItem) 
			throws Exception {
		validarDadosCotacaoItem(cotacaoItem);
		CotacaoItemDao cotacaoItemDao = new CotacaoItemDao();
		try {
			return cotacaoItemDao.salvar(cotacaoItem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(CotacaoItem cotacaoItem) 
			throws Exception {
		validarDadosCotacaoItem(cotacaoItem);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new CotacaoItemDao().alterar(cotacaoItem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(CotacaoItem cotacaoItem) 
			throws Exception {
		validarDadosCotacaoItem(cotacaoItem);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new CotacaoItemDao().deletar(cotacaoItem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<CotacaoItem> listar(String paramNome) throws Exception {
		try {
			return new CotacaoItemDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	


	private void validarDadosCotacaoItem(CotacaoItem cotacaoItem) throws Exception {
//		if (cotacaoItem.getId() < 0) {
//			throw new Exception("Id do cotacaoItem não pode ser negativo!");
//		}
		if (cotacaoItem.getDisponibilidade().equals("")) {
			throw new Exception("Nome do cotacaoItem não pode ficar em branco!");
		}
	}	
	
}
