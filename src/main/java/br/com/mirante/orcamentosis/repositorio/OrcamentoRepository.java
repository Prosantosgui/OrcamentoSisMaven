package br.com.mirante.orcamentosis.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.mirante.orcamentosis.model.Orcamento;

@Repository
public interface OrcamentoRepository {
	int obterMaiorId();
	void salvar(Orcamento orcamento);
	List<Orcamento> listar();
	public Orcamento recuperar(int id);
	void excluir(Integer id);
}
