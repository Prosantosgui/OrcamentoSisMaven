package br.com.mirante.orcamentosis.repositorio;

import java.util.List;

import br.com.mirante.orcamentosis.model.Orcamento;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrcamentoRepositoryJpa implements OrcamentoRepository{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public int obterMaiorId() {
		// TODO Auto-generated method stub
		return (Integer)entityManager.createQuery("select max(o.id) from Orcamento o").getSingleResult();
	}

	@Override
	public void salvar(Orcamento orcamento) {
		entityManager.merge(orcamento);
	}

	@Override
	public List<Orcamento> listar() {
		return entityManager.createQuery("from Orcamento", Orcamento.class).getResultList();
	}

	@Override
	public Orcamento recuperar(int id) {
		return entityManager.find(Orcamento.class, id);
	}
	
	@Override
	public void excluir(Integer id) {
		entityManager.createQuery("delete from Orcamento o where o.id = :id ")
		.setParameter("id", id)
		.executeUpdate();
	}
}
