package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.internal.build.AllowSysOut;

import br.edu.unifacear.model.entity.Fornecedor;
import br.edu.unifacear.model.entity.Gestor;
import br.edu.unifacear.model.entity.OrdemCompra;
import br.edu.unifacear.model.entity.OrdemCompraItem;
import br.edu.unifacear.model.entity.RequisicaoItem;
import br.edu.unifacear.model.facade.GestaoFacade;

@ManagedBean(name = "ordemCompraBean")
@ApplicationScoped
public class OrdemCompraController {

	private OrdemCompra ordemCompra;
	private OrdemCompra ordemSelecionada;
	private List<OrdemCompra> lista;
	private List<OrdemCompra> aprovados;
	private List<OrdemCompraItem> produtos;
	private List<OrdemCompra> pedido;
	private static int i;

	public void salvar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			facade.salvarOrdemCompra(ordemCompra, 2);
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
		this.lista.removeAll(lista);

		try {
			List<OrdemCompra> list = facade.listarOrdemCompra("");
			
			for(OrdemCompra oc : list) {
				if(oc.getFase().getId() == 2) {
					this.lista.add(oc);
				}
			}
			
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Lista atualizada!"));
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

	public void negar() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			this.ordemSelecionada.getFase().setStatus(6);
			facade.editarOrdemCompra(ordemSelecionada);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Ordem de compra negada!"));
			this.ordemSelecionada = new OrdemCompra();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao negar ordem de compra"));
			e.printStackTrace();
		}
	}

	public void listarAprovados() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		this.aprovados.removeAll(aprovados);
		try {
			this.aprovados = facade.listarOrdemCompra("Aprovados");
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Lista atualizada!"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar aprovados"));
			e.printStackTrace();
		}

	}

	

	public void adicionarPedido(List<String> ri, Fornecedor f, Gestor g) {
		FacesContext fc = FacesContext.getCurrentInstance();
		OrdemCompra oc = new OrdemCompra();
		GestaoFacade facade = new GestaoFacade();

		
		if (f.getId() == 0) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Selecione um fornecedor"));
		} else if (ri.isEmpty()) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Selecione um produto"));
		} else {
			Fornecedor forn = new Fornecedor();
			try {
				forn = facade.pegarFornecedor(String.valueOf(f.getId()));
			} catch (Exception e1) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao pegar fornecedor"));
				e1.printStackTrace();
			}

			try {
				i++;
				oc = facade.novoPedido(ri, i);
			} catch (Exception e) {
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao adicionar solicitação"));
				e.printStackTrace();
			}
			oc.setFornecedor(forn);
			oc.setSolicitante(g);
			
			this.pedido.add(oc);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Solicitação adicionada ao pedido "+i));
		}

	}

	public void removerPedido(OrdemCompra oc) {
		FacesContext fc = FacesContext.getCurrentInstance();
		this.pedido.remove(oc);
		this.i--;
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Pedido removido!"));
	}

	public void addProdutos(int oci) {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			this.produtos = new ArrayList<OrdemCompraItem>();
			for (OrdemCompra oc : this.pedido) {
				if (oci == oc.getId()) {
					this.produtos = oc.getOrdemCompraItem();
					break;
				}
			}

		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao listar produtos"));
			e.printStackTrace();
		}
	}

	public void solicitarCotacao() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			facade.solicitarCotacao(this.pedido);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Ordem de cotaçao enviada"));
			listar();
			this.pedido.clear();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao solicitar compra"));
			e.printStackTrace();
		}
	}

	public void solicitarCompra() {
		GestaoFacade facade = new GestaoFacade();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			facade.solicitarCompra(this.pedido);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Ordem de compra enviada"));
			listar();
			this.pedido.clear();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao solicitar compra"));
			e.printStackTrace();
		}
	}
		
	public OrdemCompraController() {
		this.ordemCompra = new OrdemCompra();
		this.ordemSelecionada = new OrdemCompra();
		this.lista = new ArrayList<OrdemCompra>();
		this.aprovados = new ArrayList<OrdemCompra>();
		this.pedido = new ArrayList<OrdemCompra>();
		i = 0;
		listar();
		listarAprovados();
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

	public List<OrdemCompra> getLista() {
		return lista;
	}

	public void setLista(List<OrdemCompra> lista) {
		this.lista = lista;
	}

	public List<OrdemCompra> getAprovados() {
		return aprovados;
	}

	public void setAprovados(List<OrdemCompra> aprovados) {
		this.aprovados = aprovados;
	}

	public List<OrdemCompra> getPedido() {
		return pedido;
	}

	public void setPedido(List<OrdemCompra> pedido) {
		this.pedido = pedido;
	}

	public List<OrdemCompraItem> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<OrdemCompraItem> produtos) {
		this.produtos = produtos;
	}

}
