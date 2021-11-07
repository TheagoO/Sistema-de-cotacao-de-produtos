package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.ItemDao;
import br.edu.unifacear.model.entity.Produto;

public class ItemBo {

	public String salvar(Produto item) throws Exception {
		validarDadosItem(item, "salvar");
		ItemDao itemDao = new ItemDao();
		try {
			return itemDao.salvar(item);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String alterar(Produto item) throws Exception {
		validarDadosItem(item, "editar");
		try {
			return new ItemDao().alterar(item);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String deletar(Produto item) throws Exception {
		
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new ItemDao().deletar(item);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Produto> listar(String paramNome) throws Exception {
		try {
			return new ItemDao().listar(paramNome);
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
