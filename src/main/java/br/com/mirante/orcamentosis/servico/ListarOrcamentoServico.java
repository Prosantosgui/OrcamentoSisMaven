package br.com.mirante.orcamentosis.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mirante.orcamentosis.repositorio.ItemOrcamentoRepositoryJpa;
import br.com.mirante.orcamentosis.repositorio.OrcamentoRepository;
import br.com.mirante.orcamentosis.model.ItemOrcamento;
import br.com.mirante.orcamentosis.model.Orcamento;
@Service
public class ListarOrcamentoServico {
	
	@Autowired
	private OrcamentoRepository repositorio;
	
	@Autowired
	private ItemOrcamentoRepositoryJpa itensRepositorio;
	
	public List<Orcamento> listarOrcamentos(){
		
		List<Orcamento> orcamentos = repositorio.listar();
		return orcamentos.stream().map(this::atribuirValorTotal).toList();
		// para cada orcamento calcular o valor total calculado
		// chamar o set desse atributo
	}
	
	private Orcamento atribuirValorTotal(Orcamento orcamento) {
		orcamento.setValorTotalCalculado(calcularValorTotalOrcamento(orcamento));
		return orcamento;
	}
	
	private Float calcularValorTotalOrcamento(Orcamento orcamento) {
		List<ItemOrcamento> itens = itensRepositorio.listarPorIdOrcamento(orcamento.getId());
		Float valorTotalOrcamento = 0F;
		
		for (ItemOrcamento itemOrcamento : itens) {
			valorTotalOrcamento += itemOrcamento.getValorTotalCalculado();
		}
		
		return valorTotalOrcamento;
	}
}
