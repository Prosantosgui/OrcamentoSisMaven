package br.com.mirante.orcamentosis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_ORCAMENTO")
public class ItemOrcamento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1935242373059802326L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String origem;
	private String codigo;
	@Column(name = "DESCRICAO")
	private String descricaoItem;
	
	@Column(name = "VALOR_UNITARIO")
	private float valorUnitario;
	@Column(name = "UNIDADE")
	private String unidadeMedida;
	private float quantidade;
	@Column(name = "VALOR_TOTAL_INFORMADO")
	private float valorTotalInformado;
	
	@ManyToOne
	@JoinColumn(name = "ID_ORCAMENTO")
	private Orcamento orcamento;
	
	public ItemOrcamento(Integer id,String origem, String codigo, String descricaoItem, float valorUnitario, String unidadeMedida,
			float quantidade, float valorTotalInformado) {

		this(origem,codigo,descricaoItem,valorUnitario,unidadeMedida,quantidade,valorTotalInformado);
		this.id = id;
		
	}
	
	public ItemOrcamento(String origem, String codigo, String descricaoItem, float valorUnitario, String unidadeMedida,
			float quantidade, float valorTotalInformado) {

		super();
		this.origem = origem;
		this.codigo = codigo;
		this.descricaoItem = descricaoItem;
		this.valorUnitario = valorUnitario;
		this.unidadeMedida = unidadeMedida;
		this.quantidade = quantidade;
		this.valorTotalInformado = valorTotalInformado;
	}
	
	protected ItemOrcamento() {
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public String getOrigem() {
		return origem;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public float getValorUnitario() {
		return valorUnitario;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public float getValorTotalInformado() {
		return valorTotalInformado;
	}

	public boolean possuiInconsistencia() {
		return valorUnitario * quantidade != valorTotalInformado;
	}

	public Orcamento getOrcamento() {
		return this.orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		// TODO Auto-generated method stub
		this.orcamento = orcamento;
	}

}