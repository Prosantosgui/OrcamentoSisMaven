package br.com.mirante.orcamentosis.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mirante.orcamentosis.repositorio.ItemOrcamentoRepositoryJpa;
import br.com.mirante.orcamentosis.repositorio.OrcamentoRepository;

@Service
public class ExcluirOrcamentoServico {
	@Autowired
	private OrcamentoRepository repositorio;
	
	@Autowired
	private ItemOrcamentoRepositoryJpa itensRepositorio;
	
	@Transactional
	public void excluir(Integer id) {
		itensRepositorio.deleteByIdOrcamento(id);
		repositorio.excluir(id);
	}
}
