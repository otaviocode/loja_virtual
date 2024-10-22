package backend.develoment.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

import backend.develoment.enums.StatusContaReceber;
import backend.develoment.enums.TipoEndereco;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "conta_receber")
@SequenceGenerator(name = "seq_conta_receber", sequenceName = "seq_conta_receber", allocationSize = 1, initialValue = 1)
public class ContaReceber implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conta_receber")
	private Long id;

	private String descricao;

	@Enumerated(EnumType.STRING)
	private StatusContaReceber status;

	@Temporal(TemporalType.DATE)
	private Date dtVencimento;

	@Temporal(TemporalType.DATE)
	private Date dtPagamento;

	private BigDecimal valorTotal;

	private BigDecimal valorDesconto;

	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
	private Pessoa pessoa;

	@Enumerated(EnumType.STRING)
	private TipoEndereco tipoEndereco;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusContaReceber getStatus() {
		return status;
	}

	public void setStatus(StatusContaReceber status) {
		this.status = status;
	}

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public Date getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

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
		ContaReceber other = (ContaReceber) obj;
		return Objects.equals(id, other.id);
	}
}

/*
 * Resumo:
 * 
 * A classe ContaReceber representa uma entidade de contas a receber no contexto
 * de um sistema financeiro ou administrativo. Ela é mapeada para uma tabela
 * chamada conta_receber no banco de dados usando JPA.
 * 
 * Principais funcionalidades da classe:
 * 
 * Atributos principais: id: Chave primária da entidade, gerada automaticamente.
 * descricao: Descrição da conta a receber. status: Status da conta, que pode
 * ser, por exemplo, "PAGA" ou "PENDENTE", usando uma enumeração
 * StatusContaReceber. dtVencimento e dtPagamento: Datas de vencimento e
 * pagamento da conta. valorTotal e valorDesconto: Valores totais e descontos
 * aplicados à conta.
 * 
 * Relacionamentos: Existe um relacionamento muitos-para-um com a entidade
 * Pessoa, que representa o responsável pela conta. Esse relacionamento é
 * mapeado através da coluna pessoa_id.
 * 
 * Métodos: Possui métodos getter e setter para acessar e modificar os atributos
 * da classe, além de sobrescrever os métodos equals e hashCode para garantir a
 * correta comparação e manipulação dos objetos dessa classe.
 * 
 */