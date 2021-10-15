package br.edu.unifacear.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.unifacear.entity.Endereco;
import br.edu.unifacear.dao.EnderecoDao;

public class EnderecoBo {
	
	public String salvar(Endereco endereco) 
			throws Exception {
		validarDadosEndereco(endereco);
		EnderecoDao enderecoDao = new EnderecoDao();
		try {
			return enderecoDao.salvar(endereco);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Endereco endereco) 
			throws Exception {
		validarDadosEndereco(endereco);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new EnderecoDao().alterar(endereco);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Endereco endereco) 
			throws Exception {
		validarDadosEndereco(endereco);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new EnderecoDao().deletar(endereco);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Endereco> listar(String paramNome) throws Exception {
		try {
			return new EnderecoDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	


	private void validarDadosEndereco(Endereco endereco) throws Exception {
//		if (endereco.getId() < 0) {
//			throw new Exception("Id do endereco n�o pode ser negativo!");
//		}
		if (endereco.getCidade().equals("")) {
			throw new Exception("Nome do endereco n�o pode ficar em branco!");
		}
	}	
	
}