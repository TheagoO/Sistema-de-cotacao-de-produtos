package teste;

import br.edu.unifacear.model.bo.OrdemCompraBo;
import br.edu.unifacear.model.entity.OrdemCompra;

public class Testes {

	public static void main(String[] args) {
		
		OrdemCompraBo ordemBo = new OrdemCompraBo();
		OrdemCompra oc = new OrdemCompra();
		
		oc.setId(0);
		oc.setCotacao(null);
		oc.getFase().setId(2);
		oc.getSolicitante().setId(1);
		oc.getFornecedor().setId(1);
		
		System.out.println(oc);
		
		try {
			ordemBo.salvar(oc);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
