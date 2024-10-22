package backend.develoment.model;

import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import jakarta.persistence.*;

@Entity
@Table(name = "acesso")
@SequenceGenerator(name = "seq_acesso", sequenceName = "seq_acesso", initialValue = 1, allocationSize = 1)
public class Acesso implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acesso")
	private Long id;

	@Column(nullable = false)
	private String descricao;

	@Override
	public String getAuthority() {
		return this.descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Acesso other = (Acesso) obj;
		return Objects.equals(id, other.id);
	}
}

/*
 * Resumo do Código:
 * 
 * Esta classe Java define uma entidade JPA chamada Acesso, usada para
 * representar as permissões (ou acessos) de um usuário em um sistema Spring
 * Security. A entidade é mapeada para uma tabela chamada "acesso" no banco de
 * dados.
 * 
 * Atributos: id: chave primária gerada automaticamente usando uma sequência.
 * descricao: representa o tipo de acesso (como ROLE_ADMIN, ROLE_USER).
 * 
 * Métodos: getAuthority(): implementa a interface GrantedAuthority, retornando
 * a descrição da permissão. Métodos getters e setters para os campos id e
 * descricao. hashCode() e equals(): métodos sobrescritos para garantir que duas
 * instâncias de Acesso possam ser comparadas corretamente, usando o campo id.
 * 
 * A classe é usada no contexto de segurança, onde cada instância de Acesso
 * representa uma autoridade ou permissão associada a um usuário dentro do
 * sistema.
 */