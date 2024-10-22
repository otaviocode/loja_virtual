package backend.develoment.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "marca_produto")
@SequenceGenerator(name = "seq_marca_produto", sequenceName = "seq_marca_produto", allocationSize = 1, initialValue = 1)
public class MarcaProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marca_produto")
	private Long id;

	@Column(nullable = false)
	private String nomeDesc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDesc() {
		return nomeDesc;
	}

	public void setNomeDesc(String nomeDesc) {
		this.nomeDesc = nomeDesc;
	}
}

/*
 * Essa classe define a entidade MarcaProduto que será mapeada para uma tabela
 * de mesmo nome no banco de dados. Ela possui dois atributos: id, que é a chave
 * primária, e nomeDesc, que armazena o nome ou descrição da marca do produto.
 */