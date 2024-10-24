package backend.develoment.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "nota_fiscal_compra")
@SequenceGenerator(name = "seq_nota_fiscal_compra", sequenceName = "seq_nota_fiscal_compra", allocationSize = 1, initialValue = 1)
public class NotaFiscalCompra implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nota_fiscal_compra")
	private Long id;

	private String numeroNota;
	private String serieNota;
	private String descricaoObs;
	private BigDecimal valorTotal;
	private BigDecimal valorDesconto;
	private BigDecimal valorIcms;

	@Temporal(TemporalType.DATE)
	private Date dataCompra;

	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "conta_pagar_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "conta_pagar_fk"))
	private ContaPagar contaPagar;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(String numeroNota) {
		this.numeroNota = numeroNota;
	}

	public String getSerieNota() {
		return serieNota;
	}

	public void setSerieNota(String serieNota) {
		this.serieNota = serieNota;
	}

	public String getDescricaoObs() {
		return descricaoObs;
	}

	public void setDescricaoObs(String descricaoObs) {
		this.descricaoObs = descricaoObs;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorIcms() {
		return valorIcms;
	}

	public void setValorIcms(BigDecimal valorIcms) {
		this.valorIcms = valorIcms;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public ContaPagar getContaPagar() {
		return contaPagar;
	}

	public void setContaPagar(ContaPagar contaPagar) {
		this.contaPagar = contaPagar;
	}

	// hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaFiscalCompra other = (NotaFiscalCompra) obj;
		return Objects.equals(id, other.id);
	}
}

/*
 * Resumo das Funções:
 * 
 * Classe NotaFiscalCompra: Representa uma nota fiscal de compra, contendo
 * informações sobre o número da nota, série, descrição, valores, e dados da
 * compra.
 * 
 * Atributos principais: id: Identificador único da nota fiscal, gerado
 * automaticamente. numeroNota: Número da nota fiscal. serieNota: Série da nota
 * fiscal. descricaoObs: Observações ou descrições adicionais sobre a nota.
 * valorTotal: Valor total da nota fiscal. valorDesconto: Valor do desconto
 * aplicado na nota. valorIcms: Valor do ICMS (Imposto sobre Circulação de
 * Mercadorias e Serviços). dataCompra: Data em que a compra foi realizada.
 * 
 * Relacionamento com Pessoa: A nota fiscal está associada a uma entidade
 * Pessoa, indicando quem foi o responsável pela compra.
 * 
 * Relacionamento com ContaPagar: Está também associada a uma entidade
 * ContaPagar, indicando qual conta deve ser paga relacionada a essa nota
 * fiscal.
 * 
 * Anotações de mapeamento JPA:
 * 
 * @Entity: Define a classe como uma entidade JPA.
 * 
 * @Table: Define a tabela no banco de dados como "nota_fiscal_compra".
 * 
 * @SequenceGenerator: Define uma sequência para gerar os valores de id.
 * 
 * @ManyToOne: Define um relacionamento de muitos para um com as entidades
 * Pessoa e ContaPagar.
 * 
 * @JoinColumn: Mapeia as chaves estrangeiras que referenciam Pessoa e
 * ContaPagar.
 * 
 * Getters e Setters: Funções responsáveis por acessar e modificar os valores
 * dos atributos da classe.
 * 
 * Métodos hashCode e equals: Usados para comparar objetos da classe
 * NotaFiscalCompra, baseando-se no valor do atributo id.
 * 
 * Este código modela uma nota fiscal de compra e a associa tanto a uma pessoa
 * quanto a uma conta a pagar no sistema, integrando dados financeiros e de
 * controle de compras.
 */