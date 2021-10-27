package br.com.mirante.orcamentosis.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mirante.orcamentosis.repositorio.OrcamentoRepository;
import br.com.mirante.orcamentosis.model.Orcamento;
@Service
public class ListarOrcamentoServico {
	
	@Autowired
	private OrcamentoRepository repositorio;
	
	public List<Orcamento> listarOrcamentos(){
		return repositorio.listar();
	}
}
