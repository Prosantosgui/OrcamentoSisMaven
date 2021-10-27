package br.com.mirante.orcamentosis.servico;

import br.com.mirante.orcamentosis.repositorio.ItemRepository;
import br.com.mirante.orcamentosis.repositorio.OrcamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mirante.orcamentosis.model.ItemOrcamento;
import br.com.mirante.orcamentosis.model.Orcamento;

@Service
public class CadastrarOrcamentoServico {
	
	@Autowired
	private OrcamentoRepository repositorio;
	
	@Autowired
	private ItemRepository itensRepositorio;
	
	@Transactional
	public Orcamento cadastrar(Orcamento orcamento, List<ItemOrcamento> itens) {
		int maiorId = repositorio.obterMaiorId();
		orcamento.setId(maiorId + 1);
		repositorio.salvar(orcamento);
		for (ItemOrcamento itemOrcamento : itens) {
			itemOrcamento.setOrcamento(orcamento);
		}
		//itens.forEach(item -> item.setOrcamento(orcamento)); mesmo codigo q o de cima 
		itensRepositorio.salvar(itens);
		return orcamento;
	}

}
