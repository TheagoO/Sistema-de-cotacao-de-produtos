package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.unifacear.model.entity.Almoxarifado;
import br.edu.unifacear.model.entity.Cotacao;
import br.edu.unifacear.model.entity.Fornecedor;
import br.edu.unifacear.model.entity.CotacaoFornecedorPreco;
import br.edu.unifacear.model.entity.Gestor;
import br.edu.unifacear.model.entity.RequisicaoItem;
import br.edu.unifacear.model.entity.OrdemCompra;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "ordemCompraBean")
@ApplicationScoped
public class OrdemCompraController {

	private OrdemCompra ordemCompra;
	private OrdemCompra ordemSelecionada;
	private List<OrdemCompra> listaPedidos;

	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.salvarOrdemCompra(ordemCompra);
			this.ordemCompra = new OrdemCompra();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Pedido salvo!"));

		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao salvar ordemCompra"));
			e.printStackTrace();
		}

	}

	public void listar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.listaPedidos.removeAll(listaPedidos);

		try {
			this.listaPedidos = facade.listarOrdemCompra();

		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar ordemCompras"));
			e.printStackTrace();
		}
	}

	public void editar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			String retorno = facade.editarOrdemCompra(ordemCompra);
			if (retorno.contains("Dados em branco") || retorno.contains("Código inválido")) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "Preencha os campos!"));
			} else {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Pedido editado!"));
				listar();
			}
			this.ordemCompra = new OrdemCompra();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar ordemCompra"));
			e.printStackTrace();
		}
	}

	public void editarCotacao(int i) {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			this.listaCotacao.remove(i);
			this.listaCotacao.add(i, novaCotacao);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Cotacão editada!"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao editar cotação!"));
			e.printStackTrace();
		}

	}

	public void excluir() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			facade.excluirOrdemCompra(this.ordemSelecionada);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Pedido deletado"));
			this.ordemSelecionada = new OrdemCompra();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao excluir produto"));
			e.printStackTrace();
		}
	}

	public void addItem() {

	}

	public void addFornecedor() {

	}
	
	public OrdemCompraController() {
		this.ordemCompra = new OrdemCompra();
		this.ordemSelecionada = new OrdemCompra();
		this.listaPedidos = new ArrayList<OrdemCompra>();
		listar();
	}

	public OrdemCompra getOrdemCompra() {
		return ordemCompra;
	}

	public void setOrdemCompra(OrdemCompra ordemCompra) {
		this.ordemCompra = ordemCompra;
	}

	public OrdemCompra getOrdemSelecionada() {
		return ordemSelecionada;
	}

	public void setOrdemSelecionada(OrdemCompra ordemSelecionada) {
		this.ordemSelecionada = ordemSelecionada;
	}

	public List<OrdemCompra> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<OrdemCompra> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

}
