package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.CotacaoDao;
import br.edu.unifacear.model.entity.Cotacao;

public class CotacaoBo {
	
	public String salvar(Cotacao cotacao) 
			throws Exception {
		validarDadosCotacao(cotacao);
		CotacaoDao cotacaoDao = new CotacaoDao();
		try {
			return cotacaoDao.salvar(cotacao);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Cotacao cotacao) 
			throws Exception {
		validarDadosCotacao(cotacao);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new CotacaoDao().alterar(cotacao);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Cotacao cotacao) 
			throws Exception {
		validarDadosCotacao(cotacao);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new CotacaoDao().deletar(cotacao);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Cotacao> listar(String paramNome) throws Exception {
		try {
			return new CotacaoDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	


	private void validarDadosCotacao(Cotacao cotacao) throws Exception {
		if (cotacao.getItem().getItem().getNome().equals("")) {
			throw new Exception("Nome da cotação não pode ficar em branco!");
		}
	}	
	
}
