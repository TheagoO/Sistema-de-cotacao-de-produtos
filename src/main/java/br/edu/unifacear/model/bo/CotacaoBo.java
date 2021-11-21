package br.edu.unifacear.model.bo;

import java.util.List;
import java.util.Random;

import br.edu.unifacear.model.dao.CotacaoDao;
import br.edu.unifacear.model.entity.Cotacao;

public class CotacaoBo {
	
	public int salvar(Cotacao cotacao) 
			throws Exception {
		CotacaoDao cotacaoDao = new CotacaoDao();
		Random r = new Random();
		int cod =  r.nextInt(99999);
		try {
			cotacao.setCodigo(cod);
			cotacaoDao.salvar(cotacao);
			return cod;
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
	
	public List<Cotacao> listar(long paramNome) throws Exception {
		try {
			return new CotacaoDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	


	private void validarDadosCotacao(Cotacao cotacao) throws Exception {
		
	}	
	
}
