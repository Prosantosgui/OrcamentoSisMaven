package br.com.mirante.orcamentosis.servico;

import br.com.mirante.orcamentosis.repositorio.OrcamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mirante.orcamentosis.model.Orcamento;

@Service
public class DetalharOrcamentoServico {
	
	@Autowired
	private OrcamentoRepository repositorio;
	
	public Orcamento recuperarOrcamento(int id) {
		// TODO Auto-generated method stub
		return repositorio.recuperar(id);
	}

}
