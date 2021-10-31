package br.com.mirante.orcamentosis.servico;

import br.com.mirante.orcamentosis.repositorio.ItemOrcamentoRepositoryJpa;
import br.com.mirante.orcamentosis.repositorio.OrcamentoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.mirante.orcamentosis.model.ItemOrcamento;
import br.com.mirante.orcamentosis.model.Orcamento;

@Service
public class DetalharOrcamentoServico {
	
	@Autowired
	private OrcamentoRepository repositorio;
	
	@Autowired
	private ItemOrcamentoRepositoryJpa itensRepositorio;
	
	public Orcamento recuperarOrcamento(int id) {
		// TODO Auto-generated method stub
		return repositorio.recuperar(id);
	}

	public List<ItemOrcamento> recuperarItens(Integer idOrcamento) {
		return itensRepositorio.listarPorIdOrcamento(idOrcamento);
	}

}
