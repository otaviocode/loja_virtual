package backend.develoment.model; 
// Define o pacote ao qual esta classe pertence, chamado "backend.develoment.model". Organiza a classe dentro do projeto.

import java.io.Serializable; 
// Importa a interface "Serializable", que permite que objetos dessa classe sejam convertidos em bytes para armazenamento ou transmissão.

import java.util.Objects; 
// Importa a classe "Objects", que contém métodos utilitários como "equals()" e "hashCode()".

import jakarta.persistence.*; 
// Importa as anotações do JPA para mapeamento de entidades no banco de dados.

@Entity 
// Indica que esta classe é uma entidade JPA e será mapeada para uma tabela no banco de dados.

@Table(name = "categoria_produto") 
// Especifica que esta entidade será mapeada para uma tabela chamada "categoria_produto" no banco de dados.

@SequenceGenerator(name = "seq_categoria_produto", sequenceName = "seq_categoria_produto", allocationSize = 1, initialValue = 1) 
// Define um gerador de sequência para a entidade. Ele cria uma sequência chamada "seq_categoria_produto", com valor inicial 1 e incrementos de 1.

public class CategoriaProduto implements Serializable { 
// Define a classe "CategoriaProduto" que implementa a interface "Serializable", permitindo a conversão de objetos dessa classe para uma sequência de bytes.

    private static final long serialVersionUID = 1L; 
    // Define um número de versão único para a serialização da classe, garantindo compatibilidade durante a deserialização.

    @Id 
    // Indica que o campo "id" é a chave primária da tabela.

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria_produto") 
    // Especifica que o valor de "id" será gerado automaticamente usando uma sequência definida anteriormente.

    private Long id; 
    // Campo "id" que será a chave primária da entidade.

    @Column(name = "nome_desc", nullable = false) 
    // Define o campo "nomeDesc" como obrigatório (não pode ser nulo) e mapeia-o para a coluna "nome_desc" no banco de dados.

    private String nomeDesc; 
    // Campo "nomeDesc" que armazena o nome ou descrição da categoria do produto.

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

    public String getNomeDesc() { 
    // Método getter para acessar o campo "nomeDesc".

        return nomeDesc; 
        // Retorna o valor de "nomeDesc".
    }

    public void setNomeDesc(String nomeDesc) { 
    // Método setter para definir o valor de "nomeDesc".

        this.nomeDesc = nomeDesc; 
        // Atribui o valor de "nomeDesc".
    }

    @Override 
    // Sobrescreve o método "hashCode()" para gerar um código hash para a entidade, baseado no campo "id".

    public int hashCode() { 
    // Retorna o código hash da entidade.

        return Objects.hash(id); 
        // Usa o método "Objects.hash()" para gerar um código hash baseado no campo "id".
    }

    @Override 
    // Sobrescreve o método "equals()" para comparar dois objetos da classe "CategoriaProduto".

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

        CategoriaProduto other = (CategoriaProduto) obj; 
        // Converte o outro objeto para o tipo "CategoriaProduto".

        return Objects.equals(id, other.id); 
        // Compara o campo "id" dos dois objetos.
    }
}
