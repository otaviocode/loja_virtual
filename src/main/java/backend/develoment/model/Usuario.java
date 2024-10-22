package backend.develoment.model;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	private Long id;

	private String login;

	private String senha;

	@Temporal(TemporalType.DATE)
	private Date dataAtualSenha;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuarios_acesso", uniqueConstraints = @UniqueConstraint(columnNames = { "usuario_id",
			"acesso_id" }, name = "unique_acesso_user"), joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario", unique = false, foreignKey = @ForeignKey(name = "usuario_fk", value = ConstraintMode.CONSTRAINT)), inverseJoinColumns = @JoinColumn(name = "acesso_id", unique = false, referencedColumnName = "id", table = "acesso", foreignKey = @ForeignKey(name = "acesso_fk", value = ConstraintMode.CONSTRAINT)))
	private List<Acesso> acessos;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.acessos;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}

/*
 * Resumo do código:
 * 
 * Esta classe Usuario representa uma entidade mapeada para uma tabela de banco
 * de dados chamada "usuario" e implementa a interface UserDetails, que é usada
 * pelo Spring Security para gerenciar autenticação e autorização.
 * 
 * Atributos: id: Identificador único do usuário. login: Nome de usuário. senha:
 * Senha do usuário. dataAtualSenha: Data da última atualização da senha.
 * acessos: Lista de permissões ou acessos associados ao usuário.
 * 
 * Métodos implementados da interface UserDetails: getAuthorities(): Retorna a
 * lista de acessos (permissões) do usuário. getPassword(): Retorna a senha do
 * usuário. getUsername(): Retorna o login (nome de usuário).
 * isAccountNonExpired(), isAccountNonLocked(), isCredentialsNonExpired(),
 * isEnabled(): Métodos que indicam o status da conta (se está expirada,
 * bloqueada, se as credenciais estão expiradas, e se a conta está ativa).
 * 
 * Esses métodos são obrigatórios para o Spring Security verificar o status da
 * conta e autenticar o usuário corretamente. O relacionamento entre Usuario e
 * Acesso é de um-para-muitos, com uma tabela de junção chamada usuarios_acesso
 * para armazenar os acessos.
 */