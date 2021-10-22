package br.edu.unifacear.model.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.unifacear.model.dao.FiscalItemDao;
import br.edu.unifacear.model.entity.FiscalItem;

public class FiscalItemBo {
	
	public String salvar(FiscalItem fiscalItem) 
			throws Exception {
		validarDadosFiscalItem(fiscalItem);
		FiscalItemDao fiscalItemDao = new FiscalItemDao();
		try {
			return fiscalItemDao.salvar(fiscalItem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(FiscalItem fiscalItem) 
			throws Exception {
		validarDadosFiscalItem(fiscalItem);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new FiscalItemDao().alterar(fiscalItem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(FiscalItem fiscalItem) 
			throws Exception {
		validarDadosFiscalItem(fiscalItem);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new FiscalItemDao().deletar(fiscalItem);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<FiscalItem> listar(String paramNome) throws Exception {
		try {
			return new FiscalItemDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	

	private void validarDadosFiscalItem(FiscalItem fiscalItem) throws Exception {
//		if (fiscalItem.getId() < 0) {
//			throw new Exception("Id do fiscalItem não pode ser negativo!");
//		}
		if (fiscalItem.getNcm().equals("")) {
			throw new Exception("Nome do fiscal Item não pode ficar em branco!");
		}
	}	
	
}
