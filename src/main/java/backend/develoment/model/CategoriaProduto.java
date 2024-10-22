package backend.develoment.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name = "categoria_produto")
@SequenceGenerator(name = "seq_categoria_produto", sequenceName = "seq_categoria_produto", allocationSize = 1, initialValue = 1)
public class CategoriaProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria_produto")
	private Long id;

	@Column(name = "nome_desc", nullable = false)
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
		CategoriaProduto other = (CategoriaProduto) obj;
		return Objects.equals(id, other.id);
	}
}

/*
 * Resumo do Código:
 * 
 * A classe CategoriaProduto é uma entidade JPA que mapeia uma tabela chamada
 * "categoria_produto" no banco de dados. Ela é responsável por representar as
 * categorias dos produtos na aplicação.
 * 
 * Atributos: id: chave primária gerada automaticamente usando uma sequência.
 * nomeDesc: armazena o nome ou descrição da categoria do produto, mapeada para
 * a coluna "nome_desc".
 * 
 * Métodos: Getters e setters para acessar e modificar os campos id e nomeDesc.
 * hashCode() e equals(): métodos sobrescritos para garantir a correta
 * comparação e geração de código hash da entidade, usando o campo id.
 * 
 * A classe implementa a interface Serializable, permitindo que objetos dessa
 * classe sejam convertidos em uma sequência de bytes para serem transmitidos ou
 * armazenados, garantindo assim a persistência e a transferência de estado de
 * instâncias da classe.
 */