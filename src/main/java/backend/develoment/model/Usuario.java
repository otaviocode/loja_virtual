package backend.develoment.model; 
// Declara o pacote onde essa classe está localizada.

import java.sql.Date; 
// Importa a classe 'Date' da biblioteca SQL para trabalhar com datas.

import java.util.Collection; 
// Importa a interface 'Collection', usada para coleções de dados.

import java.util.List; 
// Importa a interface 'List', que é uma subinterface de Collection, usada para listas de objetos.

import org.springframework.security.core.GrantedAuthority; 
// Importa a interface 'GrantedAuthority', usada para representar permissões de segurança.

import org.springframework.security.core.userdetails.UserDetails; 
// Importa a interface 'UserDetails', que é usada para fornecer informações de um usuário para o Spring Security.

import jakarta.persistence.ConstraintMode; 
// Importa o 'ConstraintMode', usado para definir o modo de restrições em chave estrangeira.

import jakarta.persistence.Entity; 
// Indica que a classe é uma entidade JPA que será mapeada para uma tabela no banco de dados.

import jakarta.persistence.FetchType; 
// Define como os dados associados serão carregados, neste caso, 'FetchType.LAZY' para carregamento sob demanda.

import jakarta.persistence.ForeignKey; 
// Define uma chave estrangeira em um relacionamento de banco de dados.

import jakarta.persistence.GeneratedValue; 
// Define que o valor da chave primária será gerado automaticamente.

import jakarta.persistence.GenerationType; 
// Define a estratégia de geração para a chave primária (neste caso, SEQUENCE).

import jakarta.persistence.Id; 
// Indica o campo que será a chave primária da tabela.

import jakarta.persistence.JoinColumn; 
// Especifica uma coluna de junção em um relacionamento entre entidades.

import jakarta.persistence.JoinTable; 
// Cria uma tabela de junção para relacionamentos @OneToMany ou @ManyToMany.

import jakarta.persistence.OneToMany; 
// Define um relacionamento de um para muitos entre duas entidades.

import jakarta.persistence.SequenceGenerator; 
// Define um gerador de sequência para gerar os valores da chave primária.

import jakarta.persistence.Table; 
// Especifica a tabela do banco de dados com a qual esta entidade está mapeada.

import jakarta.persistence.Temporal; 
// Especifica o mapeamento de campos de data para tipos de dados temporais.

import jakarta.persistence.TemporalType; 
// Define o tipo de dado temporal, neste caso, 'DATE', que armazena apenas a data (sem hora).

import jakarta.persistence.UniqueConstraint; 
// Define restrições únicas em colunas da tabela (garante que valores não se repitam).

@Entity
@Table(name = "usuario") 
// Mapeia a entidade para a tabela "usuario" no banco de dados.

@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1) 
// Cria um gerador de sequência para a entidade "Usuario", definindo o nome da sequência e os parâmetros de geração.

public class Usuario implements UserDetails { 
// Declara a classe 'Usuario' e implementa a interface 'UserDetails' (exigida pelo Spring Security para informações de segurança do usuário).

	private static final long serialVersionUID = 1L; 
	// Define um identificador serial para assegurar a compatibilidade em processos de serialização.

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario") 
	// Anota o campo 'id' como chave primária e define que seu valor será gerado automaticamente usando uma sequência.
	private Long id; 
	
	private String login; 
	// Campo que armazena o nome de usuário (login).

	private String senha; 
	// Campo que armazena a senha do usuário.

	@Temporal(TemporalType.DATE) 
	// Define que o campo armazena apenas a data (sem horário).
	private Date dataAtualSenha; 
	// Campo para armazenar a data da última atualização da senha.

	@OneToMany(fetch = FetchType.LAZY) 
	// Define um relacionamento de um para muitos, onde um usuário pode ter muitos acessos.
	@JoinTable(name = "usuarios_acesso", 
	// Define a tabela de junção "usuarios_acesso" para o relacionamento entre usuários e acessos.
	uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "acesso_id"}, 
	// Define uma restrição única para as colunas "usuario_id" e "acesso_id".
	name = "unique_acesso_user"), 
	// Nome da restrição única.
	joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario", 
	// Define a coluna de junção (chave estrangeira) para "usuario_id" na tabela "usuario".
	unique = false, foreignKey = @ForeignKey(name = "usuario_fk", value = ConstraintMode.CONSTRAINT)), 
	// Define a chave estrangeira "usuario_fk" com restrição de integridade.
	inverseJoinColumns = @JoinColumn(name = "acesso_id", unique = false, referencedColumnName = "id", 
	// Define a coluna de junção inversa (para "acesso_id").
	table = "acesso", foreignKey = @ForeignKey(name = "acesso_fk", value = ConstraintMode.CONSTRAINT))) 
	// Define a chave estrangeira "acesso_fk" para a tabela "acesso".
	private List<Acesso> acessos; 
	// Lista que armazena os acessos do usuário.

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { 
		// Método que retorna as permissões (ou acessos) do usuário.
		return this.acessos;
	}

	@Override
	public String getPassword() { 
		// Método que retorna a senha do usuário.
		return this.senha;
	}

	@Override
	public String getUsername() { 
		// Método que retorna o nome de usuário (login).
		return this.login;
	}
	
	@Override
	public boolean isAccountNonExpired() { 
		// Método que indica se a conta do usuário está expirada (aqui sempre retorna 'true').
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() { 
		// Método que indica se a conta do usuário está bloqueada (aqui sempre retorna 'true').
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() { 
		// Método que indica se as credenciais (senha) do usuário estão expiradas (aqui sempre retorna 'true').
		return true;
	}
	
	@Override
	public boolean isEnabled() { 
		// Método que indica se a conta do usuário está ativa (aqui sempre retorna 'true').
		return true;
	}
}
