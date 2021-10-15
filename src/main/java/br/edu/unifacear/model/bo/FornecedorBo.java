package br.edu.unifacear.model.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.unifacear.model.dao.FornecedorDao;
import br.edu.unifacear.model.entity.Fornecedor;

public class FornecedorBo {
	
	public String salvar(Fornecedor fornecedor) 
			throws Exception {
		validarDadosFornecedor(fornecedor);
		FornecedorDao fornecedorDao = new FornecedorDao();
		try {
			return fornecedorDao.salvar(fornecedor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Fornecedor fornecedor) 
			throws Exception {
		validarDadosFornecedor(fornecedor);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new FornecedorDao().alterar(fornecedor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Fornecedor fornecedor) 
			throws Exception {
		validarDadosFornecedor(fornecedor);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new FornecedorDao().deletar(fornecedor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Fornecedor> listar(String paramNome) throws Exception {
		try {
			return new FornecedorDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	

	private void validarDadosFornecedor(Fornecedor fornecedor) throws Exception {
//		if (fornecedor.getId() < 0) {
//			throw new Exception("Id do fornecedor não pode ser negativo!");
//		}
		if (fornecedor.getNome().equals("")) {
			throw new Exception("Nome do fornecedor não pode ficar em branco!");
		}
	}	
	
}
