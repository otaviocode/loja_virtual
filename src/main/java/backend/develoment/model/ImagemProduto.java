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
@Table(name = "imagem_produto")
@SequenceGenerator(name = "seq_imagem_produto", sequenceName = "seq_imagem_produto", allocationSize = 1, initialValue = 1)
public class ImagemProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_imagem_produto")
	private Long id;

	@Column(columnDefinition = "text") // Verifique se essa anotação é necessária
	private String imagemOriginal;

	private String imagemMiniatura;

	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
	private Pessoa pessoa;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImagemOriginal() {
		return imagemOriginal;
	}

	public void setImagemOriginal(String imagemOriginal) {
		this.imagemOriginal = imagemOriginal;
	}

	public String getImagemMiniatura() {
		return imagemMiniatura;
	}

	public void setImagemMiniatura(String imagemMiniatura) {
		this.imagemMiniatura = imagemMiniatura;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		ImagemProduto other = (ImagemProduto) obj;
		return Objects.equals(id, other.id);
	}
}

/*
 * Resumo das Funções:
 * 
 * Classe ImagemProduto: Representa imagens de produtos, armazenando tanto a
 * imagem original quanto uma versão miniatura da imagem.
 * 
 * Atributos principais: id: Identificador único da imagem, gerado
 * automaticamente por uma sequência. imagemOriginal: Armazena a imagem original
 * do produto em formato de texto. imagemMiniatura: Armazena uma versão
 * miniatura da imagem do produto.
 * 
 * Relacionamento com Pessoa: A classe possui uma associação @ManyToOne com a
 * entidade Pessoa, indicando que várias imagens podem estar associadas a uma
 * pessoa.
 * 
 * Anotações de mapeamento JPA:
 * 
 * @Entity: Define a classe como uma entidade JPA.
 * 
 * @Table: Define a tabela no banco de dados como "imagem_produto".
 * 
 * @SequenceGenerator: Define uma sequência para gerar os valores de id.
 * 
 * @ManyToOne: Define um relacionamento de muitos para um com a entidade Pessoa.
 * 
 * @JoinColumn: Mapeia a chave estrangeira que referencia a pessoa.
 * 
 * Getters e Setters: Métodos que permitem acessar e modificar os valores dos
 * atributos da classe.
 * 
 * Métodos hashCode e equals: São usados para comparar objetos da classe
 * ImagemProduto com base no valor do atributo id.
 * 
 * Este código é responsável por armazenar e mapear imagens de produtos em um
 * sistema, vinculando cada imagem a uma pessoa através de uma chave
 * estrangeira.
 */
