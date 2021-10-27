package br.com.mirante.orcamentosis.servico;

import br.com.mirante.orcamentosis.repositorio.ItemRepository;
import br.com.mirante.orcamentosis.repositorio.ItemRepositoryJpa;

public class ServicoExcluirItem {

	private ItemRepository repositorio = new ItemRepositoryJpa();
	
	public void excluirItem(Integer id) {
		// TODO Auto-generated method stub
		repositorio.excluir(id);
	}

}
