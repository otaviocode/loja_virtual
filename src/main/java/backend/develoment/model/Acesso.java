package backend.develoment.model; 
// Define o pacote ao qual esta classe pertence, chamado "backend.develoment.model". Organiza a classe dentro do projeto.

import java.util.Objects; 
// Importa a classe "Objects", que contém métodos utilitários como "equals()" e "hashCode()".

import org.springframework.security.core.GrantedAuthority; 
// Importa a interface "GrantedAuthority" do Spring Security, que é usada para representar uma permissão concedida a uma entidade (como um usuário).

import jakarta.persistence.*; 
// Importa as anotações do JPA (Jakarta Persistence API) para mapeamento de entidades no banco de dados.

@Entity 
// Indica que esta classe é uma entidade JPA e será mapeada para uma tabela no banco de dados.

@Table(name = "acesso") 
// Especifica que esta entidade será mapeada para uma tabela chamada "acesso" no banco de dados.

@SequenceGenerator(name = "seq_acesso", sequenceName = "seq_acesso", initialValue = 1, allocationSize = 1) 
// Define um gerador de sequência para a entidade. Ele cria uma sequência chamada "seq_acesso", com valor inicial 1 e incrementos de 1.

public class Acesso implements GrantedAuthority { 
// Define a classe "Acesso" que implementa a interface "GrantedAuthority" do Spring Security. Isso significa que essa classe pode representar uma autoridade (ou permissão) no sistema.

    private static final long serialVersionUID = 1L; 
    // Define um número de versão único para a serialização da classe. Esse número é importante para garantir a compatibilidade durante a deserialização.

    @Id 
    // Indica que o campo "id" é a chave primária da tabela.

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acesso") 
    // Especifica que o valor de "id" será gerado automaticamente usando uma sequência definida anteriormente.

    private Long id; 
    // Campo "id" que será a chave primária da entidade.

    @Column(nullable = false) 
    // Define que o campo "descricao" é obrigatório (não pode ser nulo) no banco de dados.

    private String descricao; 
    // Campo "descricao" que armazena o tipo de acesso (exemplo: ROLE_ADMIN ou ROLE_SECRETARIO).

    @Override 
    // Sobrescreve o método da interface "GrantedAuthority".

    public String getAuthority() { 
    // Implementa o método obrigatório da interface "GrantedAuthority". Retorna a descrição do acesso como a autoridade concedida.

        return this.descricao; 
        // Retorna o valor de "descricao".
    }

    public Long getId() { 
    // Método getter para acessar o campo "id".

        return id; 
        // Retorna o valor de "id".
    }

    public void setId(Long id) { 
    // Método setter para definir o valor de "id".

        this.id = id; 
        // Atribui o valor de "id".
    }

    public String getDescricao() { 
    // Método getter para acessar o campo "descricao".

        return descricao; 
        // Retorna o valor de "descricao".
    }

    public void setDescricao(String descricao) { 
    // Método setter para definir o valor de "descricao".

        this.descricao = descricao; 
        // Atribui o valor de "descricao".
    }

    @Override 
    // Sobrescreve o método "hashCode()" para gerar um código hash para a entidade, baseado no campo "id".

    public int hashCode() { 
    // Retorna o código hash da entidade.

        return Objects.hash(id); 
        // Usa o método "Objects.hash()" para gerar um código hash baseado no campo "id".
    }

    @Override 
    // Sobrescreve o método "equals()" para comparar dois objetos da classe "Acesso".

    public boolean equals(Object obj) { 
    // Compara a instância atual com outro objeto.

        if (this == obj) 
        // Verifica se os objetos são idênticos.

            return true; 
            // Retorna true se forem o mesmo objeto.

        if (obj == null) 
        // Verifica se o outro objeto é nulo.

            return false; 
            // Retorna false se o outro objeto for nulo.

        if (getClass() != obj.getClass()) 
        // Verifica se o outro objeto é da mesma classe.

            return false; 
            // Retorna false se as classes forem diferentes.

        Acesso other = (Acesso) obj; 
        // Converte o outro objeto para o tipo "Acesso".

        return Objects.equals(id, other.id); 
        // Compara o campo "id" dos dois objetos.
    }

}
