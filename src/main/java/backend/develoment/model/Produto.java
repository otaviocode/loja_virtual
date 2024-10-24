package backend.develoment.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
	private Long id;

	private String tipoUnidade;
	private String nome;
	private Boolean ativo = Boolean.TRUE;

	@Column(columnDefinition = "text", length = 2000)
	private String descricao;

	private Double peso;
	private Double largura;
	private Double altura;
	private Double profundidade;

	private BigDecimal valorVenda = BigDecimal.ZERO;

	private Integer qtdEstoque = 0;
	private Integer qtdAlertaEstoque = 0;

	private String linkYoutube;
	private Boolean alertaQtdEstoque = Boolean.FALSE;
	private Integer qtdeClique = 0;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade(String tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(Double profundidade) {
		this.profundidade = profundidade;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Integer getQtdAlertaEstoque() {
		return qtdAlertaEstoque;
	}

	public void setQtdAlertaEstoque(Integer qtdAlertaEstoque) {
		this.qtdAlertaEstoque = qtdAlertaEstoque;
	}

	public String getLinkYoutube() {
		return linkYoutube;
	}

	public void setLinkYoutube(String linkYoutube) {
		this.linkYoutube = linkYoutube;
	}

	public Boolean getAlertaQtdEstoque() {
		return alertaQtdEstoque;
	}

	public void setAlertaQtdEstoque(Boolean alertaQtdEstoque) {
		this.alertaQtdEstoque = alertaQtdEstoque;
	}

	public Integer getQtdeClique() {
		return qtdeClique;
	}

	public void setQtdeClique(Integer qtdeClique) {
		this.qtdeClique = qtdeClique;
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
}

/*
 * Resumo das Funções:
 * 
 * Classe Produto: Representa um produto com diversas propriedades como nome,
 * descrição, peso, dimensões e estoque.
 * 
 * Atributos principais: id: Identificador único do produto, gerado
 * automaticamente. tipoUnidade: Define a unidade de medida (ex.: kg, litro) do
 * produto. nome: Nome do produto. descricao: Uma descrição detalhada do
 * produto, com até 2000 caracteres. peso, largura, altura, profundidade:
 * Informações físicas do produto. valorVenda: Preço de venda do produto.
 * qtdEstoque, qtdAlertaEstoque: Quantidade em estoque e quantidade mínima para
 * alerta de estoque baixo. linkYoutube: Link de um vídeo sobre o produto
 * (possivelmente um tutorial ou demonstração). qtdeClique: Contador de
 * visualizações ou cliques no produto (talvez utilizado para medir
 * popularidade).
 * 
 * Comportamentos: Ativo: Indica se o produto está ativo no sistema. Alerta de
 * Estoque: Indica se o produto atingiu o nível de alerta de estoque baixo.
 * 
 * Anotações de mapeamento JPA:
 * 
 * @Entity: Define a classe como uma entidade JPA.
 * 
 * @Table: Define a tabela correspondente no banco de dados.
 * 
 * @SequenceGenerator: Define uma sequência de geração de IDs para a tabela de
 * produtos.
 * 
 * Getters e Setters: Responsáveis por acessar e modificar os atributos do
 * produto.
 * 
 * Métodos hashCode e equals: Usados para comparar objetos da classe Produto com
 * base no valor do atributo id.
 * 
 * Este código define a estrutura de um produto dentro do sistema, permitindo
 * armazenar suas características físicas, preço e informações de estoque.
 */