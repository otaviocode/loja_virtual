package backend.develoment.model;
// Define o pacote onde a classe está localizada.

import java.io.Serializable;
// Importa a interface Serializable para permitir que a classe seja serializada (convertida para uma sequência de bytes).

import java.util.ArrayList;
// Importa a classe ArrayList para trabalhar com listas dinâmicas.

import java.util.List;
// Importa a interface List, que define uma lista de elementos.

import java.util.Objects;
// Importa a classe Objects, que contém métodos úteis como hashCode e equals para comparar objetos.

import jakarta.persistence.*;
// Importa anotações do JPA (Jakarta Persistence API) para mapear a entidade ao banco de dados.

@Entity
// Indica que esta classe será mapeada para uma tabela no banco de dados.

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// Define a estratégia de herança no banco de dados, onde cada classe da hierarquia terá sua própria tabela.

@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", initialValue = 1, allocationSize = 1)
// Define um gerador de sequência para a chave primária, com nome "seq_pessoa", inicializando em 1 e incrementando 1 a cada novo registro.

public abstract class Pessoa implements Serializable {
// Define a classe "Pessoa" como abstrata, ou seja, não pode ser instanciada diretamente, e implementa a interface Serializable.

    private static final long serialVersionUID = 1L;
    // Número de versão para garantir a compatibilidade durante o processo de serialização.

    @Id
    // Indica que o campo "id" é a chave primária da tabela.

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    // Gera automaticamente o valor do "id" usando a sequência definida anteriormente.

    private Long id;
    // Campo que representa o identificador único da pessoa.

    private String nome;
    // Campo para armazenar o nome da pessoa.

    private String email;
    // Campo para armazenar o email da pessoa.

    private String telefone;
    // Campo para armazenar o telefone da pessoa.

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // Define um relacionamento "um para muitos" com a classe Endereco. 
    // "mappedBy = pessoa" indica que o campo pessoa em Endereco é a chave estrangeira.
    // "orphanRemoval = true" significa que endereços órfãos (não relacionados a nenhuma pessoa) serão removidos.
    // "cascade = CascadeType.ALL" faz com que todas as operações (inserção, atualização, exclusão) em Pessoa sejam propagadas para Endereco.
    // "fetch = FetchType.LAZY" carrega os endereços de forma preguiçosa, ou seja, somente quando for necessário.

    private List<Endereco> enderecos = new ArrayList<Endereco>();
    // Lista que armazena os endereços relacionados a essa pessoa.

    public void setEnderecos(List<Endereco> enderecos) {
    // Método setter para definir a lista de endereços da pessoa.

        this.enderecos = enderecos;
    }

    public List<Endereco> getEnderecos() {
    // Método getter para acessar a lista de endereços da pessoa.

        return enderecos;
    }

    public Long getId() {
    // Método getter para acessar o valor do "id".

        return id;
    }

    public void setId(Long id) {
    // Método setter para definir o valor do "id".

        this.id = id;
    }

    public String getNome() {
    // Método getter para acessar o nome da pessoa.

        return nome;
    }

    public void setNome(String nome) {
    // Método setter para definir o nome da pessoa.

        this.nome = nome;
    }

    public String getEmail() {
    // Método getter para acessar o email da pessoa.

        return email;
    }

    public void setEmail(String email) {
    // Método setter para definir o email da pessoa.

        this.email = email;
    }

    public String getTelefone() {
    // Método getter para acessar o telefone da pessoa.

        return telefone;
    }

    public void setTelefone(String telefone) {
    // Método setter para definir o telefone da pessoa.

        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
    // Método hashCode que gera um código hash para a pessoa com base no "id".

        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
    // Método equals para comparar se duas pessoas são iguais, com base no "id".

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        return Objects.equals(id, other.id);
    }

}
