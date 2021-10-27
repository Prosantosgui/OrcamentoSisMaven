package br.com.mirante.orcamentosis.repositorio;

import java.util.List;

import br.com.mirante.orcamentosis.model.ItemOrcamento;

public interface ItemRepository {

	void excluir(Integer codigoItem);

	void salvar(List<ItemOrcamento> itens);

	void excluirItens(Integer idOrcamento);
	
}
