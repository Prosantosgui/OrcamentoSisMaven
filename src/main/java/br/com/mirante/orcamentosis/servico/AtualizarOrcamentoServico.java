package br.com.mirante.orcamentosis.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mirante.orcamentosis.model.Orcamento;
import br.com.mirante.orcamentosis.repositorio.OrcamentoRepository;

@Service
public class AtualizarOrcamentoServico {
	
	@Autowired
	private OrcamentoRepository repositorio;
	
	@Transactional
	public void atualizar(Integer id, Orcamento orcamento) {
		if(orcamento.getId() != null && !orcamento.getId().equals(id)) {
			throw new RuntimeException("Dado inválidos.");
		}
		
		Orcamento orcamentoSalvo = repositorio.recuperar(id);
		
		if(orcamento.getDescricao() != null) {
			orcamentoSalvo.setDescricao(orcamento.getDescricao());
			
		}
		if(orcamento.getPeriodo() != null) {
			orcamentoSalvo.setPeriodo(orcamento.getPeriodo());
		}
		if(orcamento.getAno() != null) {
			orcamentoSalvo.setAno(orcamento.getAno());
		}
		if(orcamento.getValorTotal() != null) {
			orcamentoSalvo.setPeriodo(orcamento.getPeriodo());
		}
		orcamento.setId(id);
		repositorio.salvar(orcamentoSalvo);
		
	}
	
}
