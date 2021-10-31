package br.com.mirante.orcamentosis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import br.com.mirante.orcamentosis.model.ItemOrcamento;
import br.com.mirante.orcamentosis.model.Orcamento;
import br.com.mirante.orcamentosis.servico.AtualizarOrcamentoServico;
import br.com.mirante.orcamentosis.servico.CadastrarOrcamentoServico;
import br.com.mirante.orcamentosis.servico.DetalharOrcamentoServico;
import br.com.mirante.orcamentosis.servico.ExcluirOrcamentoServico;
import br.com.mirante.orcamentosis.servico.ListarOrcamentoServico;

@RestController
public class OrcamentoController {
		
	@Autowired
	private ListarOrcamentoServico servico;
	
	@Autowired
	private DetalharOrcamentoServico detalharServico;
	
	@Autowired
	private CadastrarOrcamentoServico cadastrarServico;
	
	@Autowired
	private ExcluirOrcamentoServico excluirServico;
	
	@Autowired
	private AtualizarOrcamentoServico atualizarServico;
	
	@GetMapping("/orcamentos")
	public List<Orcamento> listarOrcamentos(){
		return servico.listarOrcamentos();
	}
	
	@GetMapping("/orcamentos/{id}")
	public Orcamento recuperarOrcamento(@PathVariable Integer id) {
		return detalharServico.recuperarOrcamento(id);
	}
	
	@PostMapping("/orcamentos")
	public Orcamento cadastrarOrcamento(@RequestBody CadastrarOrcamentoRequest requisicao) {
		return cadastrarServico.cadastrar(requisicao.orcamento, requisicao.itens);	
	}
	
	@DeleteMapping("/orcamentos/{id}")
	public void excluirOrcamento(@PathVariable Integer id){
		excluirServico.excluir(id);
	}
	
	@PutMapping("/orcamentos/{id}")
	public void atualizarOrcamento(@PathVariable Integer id,@RequestBody Orcamento orcamento) {
		atualizarServico.atualizar(id, orcamento);
	}
	
}

class CadastrarOrcamentoRequest{
	public Orcamento getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	public List<ItemOrcamento> getItens() {
		return itens;
	}
	public void setItens(List<ItemOrcamento> itens) {
		this.itens = itens;
	}
	Orcamento orcamento;
	List<ItemOrcamento> itens;
	
}
