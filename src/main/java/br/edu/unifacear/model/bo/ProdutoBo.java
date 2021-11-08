package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.ProdutoDao;
import br.edu.unifacear.model.entity.Produto;

public class ProdutoBo {

	public String salvar(Produto item) throws Exception {
		validarDadosItem(item, "salvar");
		ProdutoDao itemDao = new ProdutoDao();
		try {
			return itemDao.salvar(item);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String alterar(Produto item) throws Exception {
		validarDadosItem(item, "editar");
		try {
			return new ProdutoDao().alterar(item);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String deletar(Produto item) throws Exception {
		
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new ProdutoDao().deletar(item);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Produto> listar(String paramNome) throws Exception {
		try {
			return new ProdutoDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	private void validarDadosItem(Produto i, String s) throws Exception {
		if(s.contains("salvar")) {
			if(i.getCodigo() < 13 || i.getCodigo() == 0) {
				throw new Exception("Código inválido");
			}
		}else {
			if(i.getCodigo() < 13) {
				throw new Exception("Código inválido");
			}
			if(i.getNome() == "" || i.getNome() == null) {
				throw new Exception("Dados em branco");
			}
			if(i.getMarca() == "" || i.getMarca() == null) {
				throw new Exception("Dados em branco");
			}
		}
		
		
		
	}

}
