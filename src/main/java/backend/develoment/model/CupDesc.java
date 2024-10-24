package backend.develoment.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "cup_desc")
@SequenceGenerator(name = "seq_cup_desc", sequenceName = "seq_cup_desc", allocationSize = 1, initialValue = 1)
public class CupDesc implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cup_desc")
	private Long id;

	private String codDesc;
	private BigDecimal valorRealDesc;
	private BigDecimal valorPorcentDesc;

	@Temporal(TemporalType.DATE)
	private Date dataValidadeCupom;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodDesc() {
		return codDesc;
	}

	public void setCodDesc(String codDesc) {
		this.codDesc = codDesc;
	}

	public BigDecimal getValorRealDesc() {
		return valorRealDesc;
	}

	public void setValorRealDesc(BigDecimal valorRealDesc) {
		this.valorRealDesc = valorRealDesc;
	}

	public BigDecimal getValorPorcentDesc() {
		return valorPorcentDesc;
	}

	public void setValorPorcentDesc(BigDecimal valorPorcentDesc) {
		this.valorPorcentDesc = valorPorcentDesc;
	}

	public Date getDataValidadeCupom() {
		return dataValidadeCupom;
	}

	public void setDataValidadeCupom(Date dataValidadeCupom) {
		this.dataValidadeCupom = dataValidadeCupom;
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
		CupDesc other = (CupDesc) obj;
		return Objects.equals(id, other.id);
	}
}

/*
 * Resumo das Funções:
 * 
 * Classe CupDesc: Representa um cupom de desconto, com atributos como código de
 * desconto, valores de desconto (real e porcentagem), e data de validade.
 * 
 * Atributos principais: id: Identificador único do cupom, gerado
 * automaticamente por uma sequência. codDesc: Código textual do cupom.
 * valorRealDesc: Valor em dinheiro do desconto. valorPorcentDesc: Valor
 * percentual do desconto. dataValidadeCupom: Data limite de validade do cupom.
 * 
 * Getters e Setters: Funções responsáveis por acessar (get) e modificar (set)
 * os atributos privados da classe.
 * 
 * Métodos hashCode e equals: Servem para comparar instâncias da classe CupDesc,
 * baseando-se no valor do atributo id. Isso é útil para verificar se dois
 * objetos representam o mesmo cupom.
 * 
 * Esse código segue o padrão de uma entidade JPA, com mapeamento de uma tabela
 * de cupons de desconto em um banco de dados.
 * 
 */