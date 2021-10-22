package br.edu.unifacear.model.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.unifacear.model.dao.AlmoxarifadoDao;
import br.edu.unifacear.model.entity.Almoxarifado;

public class AlmoxarifadoBo {
	
	public String salvar(Almoxarifado almoxarifado) 
			throws Exception {
		validarDadosAlmoxarifado(almoxarifado);
		AlmoxarifadoDao grupoDao = new AlmoxarifadoDao();
		try {
			return grupoDao.salvar(almoxarifado);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Almoxarifado almoxarifado) 
			throws Exception {
		validarDadosAlmoxarifado(almoxarifado);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new AlmoxarifadoDao().alterar(almoxarifado);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Almoxarifado almoxarifado) 
			throws Exception {
		validarDadosAlmoxarifado(almoxarifado);
		// exemplo chamando a DAO com a instancia direta do obj
		try {
			return new AlmoxarifadoDao().deletar(almoxarifado);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Almoxarifado> listar(String paramNome) throws Exception {
		try {
			return new AlmoxarifadoDao().listar(paramNome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}		
	
	

	private void validarDadosAlmoxarifado(Almoxarifado almoxarifado) throws Exception {

		if (almoxarifado.getNome().equals("")) {
			throw new Exception("Nome do Almoxarifado não pode ficar em branco!");
		}
	}	
	
}
