package br.com.mirante.orcamentosis.repositorio;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mirante.orcamentosis.model.ItemOrcamento;

@Repository
public class ItemRepositoryJpa implements ItemRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void excluir(Integer codigoItem) {
		var itemRecuperado = entityManager.find(ItemOrcamento.class, codigoItem);
		
		if(itemRecuperado != null) {
			entityManager.getTransaction().begin();;
			entityManager.remove(itemRecuperado);
			entityManager.getTransaction().commit();;
		}
		
	}
	
	@Override
	public void salvar(List<ItemOrcamento> itens) {
		itens.forEach(entityManager::persist);
	}

	@Override
	public void excluirItens(Integer idOrcamento) {
		entityManager.createQuery("delete from ItemOrcamento i where i.orcamento.id = :idOrcamento")
		.setParameter("idOrcamento", idOrcamento)
		.executeUpdate();
	}
	

}
