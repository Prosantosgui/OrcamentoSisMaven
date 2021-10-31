package br.com.mirante.orcamentosis.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Orcamento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7190373383500571611L;
	private String descricao;
	@Column(name = "MES")
	private Integer Periodo;
	@Id
	private Integer id;
	private Integer ano;
	@Column(name = "VALOR_TOTAL_INFORMADO")
	private Float valorTotal;
	
	@Transient
	private Float valorTotalCalculado;

	public String getDescricao() {
		return descricao;
	}
	
	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getPeriodo() {
		return Periodo;
	}
	public void setPeriodo(Integer periodo) {
		Periodo = periodo;
	}
	public Integer getAno() {
		return ano;
	}
	
	public Orcamento(String descricao, Integer periodo,Integer ano, float valorTotal) 
	{
		super();
		this.descricao = descricao;
		this.Periodo = periodo;
		this.ano = ano;
		this.valorTotal = valorTotal;
	}
	protected Orcamento() {}

	public Integer getId() {

		return id;
	}

	public void setId(int id) {
		this.id = id;
		// TODO Auto-generated method stub
		
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
		
	}

	public void setAno(Integer ano) {
		this.ano = ano;
		
	}
	
	public Float getValorTotalCalculado() {
		return valorTotalCalculado;
	}
	
	public void setValorTotalCalculado(Float valorTotalCalculado) {
		this.valorTotalCalculado = valorTotalCalculado;
	}
	public Float getDiferencaCalculo() {

		return valorTotalCalculado - valorTotal;
		}
}
