package br.com.mirante.orcamentosis.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Orcamento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7190373383500571611L;
	private String descricao;
	@Column(name = "MES")
	private int Periodo;
	@Id
	private int id;
	private int ano;
	@Column(name = "VALOR_TOTAL_INFORMADO")
	private float valorTotal;
	

	public String getDescricao() {
		return descricao;
	}
	
	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getPeriodo() {
		return Periodo;
	}
	public void setPeriodo(int periodo) {
		Periodo = periodo;
	}
	public int getAno() {
		return ano;
	}
	
	public Orcamento(String descricao, int periodo,int ano, float valorTotal) 
	{
		super();
		this.descricao = descricao;
		this.Periodo = periodo;
		this.ano = ano;
		this.valorTotal = valorTotal;
	}
	protected Orcamento() {}

	public int getId() {

		return id;
	}

	public void setId(int id) {
		this.id = id;
		// TODO Auto-generated method stub
		
	}
}
