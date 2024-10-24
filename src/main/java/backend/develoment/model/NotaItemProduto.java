package backend.develoment.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
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

@Entity
@Table(name = "nota_item_produto")
@SequenceGenerator(name = "seq_nota_item_produto", sequenceName = "seq_nota_item_produto", allocationSize = 1, initialValue = 1)
public class NotaItemProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nota_item_produto")
	private Long id;

	@Column(nullable = false)
	private Double quantidade;

	@ManyToOne(targetEntity = Produto.class)
	@JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
	private Produto produto;

	@ManyToOne(targetEntity = NotaFiscalCompra.class)
	@JoinColumn(name = "nota_fiscal_compra_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "nota_fiscal_compra_fk"))
	private NotaFiscalCompra notaFiscalCompra;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public NotaFiscalCompra getNotaFiscalCompra() {
		return notaFiscalCompra;
	}

	public void setNotaFiscalCompra(NotaFiscalCompra notaFiscalCompra) {
		this.notaFiscalCompra = notaFiscalCompra;
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
		NotaItemProduto other = (NotaItemProduto) obj;
		return Objects.equals(id, other.id);
	}
}

/*
 * Resumo das Funções:
 * 
 * Classe NotaItemProduto: Representa um item de produto que está vinculado a
 * uma nota fiscal de compra.
 * 
 * Atributos principais: id: Identificador único do item de produto, gerado
 * automaticamente. quantidade: Quantidade do produto incluído na nota fiscal.
 * 
 * Relacionamento com Produto: O item de produto está associado a uma entidade
 * Produto, representando o produto incluído na nota fiscal.
 * 
 * Relacionamento com NotaFiscalCompra: O item também está relacionado a uma
 * entidade NotaFiscalCompra, indicando a nota fiscal à qual o item pertence.
 * 
 * Anotações de mapeamento JPA:
 * 
 * @Entity: Define a classe como uma entidade JPA.
 * 
 * @Table: Define a tabela no banco de dados como "nota_item_produto".
 * 
 * @SequenceGenerator: Define uma sequência para gerar os valores de id.
 * 
 * @ManyToOne: Define relacionamentos de muitos para um com as entidades Produto
 * e NotaFiscalCompra.
 * 
 * @JoinColumn: Mapeia as chaves estrangeiras que referenciam Produto e
 * NotaFiscalCompra.
 * 
 * Getters e Setters: Funções responsáveis por acessar e modificar os valores
 * dos atributos da classe.
 * 
 * Métodos hashCode e equals: Usados para comparar objetos da classe
 * NotaItemProduto, baseando-se no valor do atributo id.
 * 
 * Este código modela os itens de produtos contidos em uma nota fiscal de
 * compra, permitindo o controle da quantidade e da associação com os produtos e
 * notas fiscais.
 */