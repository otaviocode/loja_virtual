package backend.develoment.model; 
// Define o pacote ao qual esta classe pertence, chamado "backend.develoment.model". Organiza a classe dentro do projeto.

import java.io.Serializable; 
// Importa a interface "Serializable", permitindo que objetos desta classe sejam convertidos em bytes para armazenamento ou transmissão.

import java.util.Objects; 
// Importa a classe "Objects", que contém métodos utilitários como "equals()" e "hashCode()".

import backend.develoment.enums.TipoEndereco; 
// Importa a enumeração "TipoEndereco" do pacote "enums" para ser usada nesta classe.

import jakarta.persistence.*; 
// Importa as anotações e classes do JPA (Jakarta Persistence API) para mapeamento de entidades no banco de dados.

@Entity 
// Indica que esta classe é uma entidade JPA e será mapeada para uma tabela no banco de dados.

@Table(name = "endereco") 
// Especifica que esta entidade será mapeada para uma tabela chamada "endereco" no banco de dados.

@SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco", allocationSize = 1, initialValue = 1) 
// Define um gerador de sequência para a entidade. Ele cria uma sequência chamada "seq_endereco", com valor inicial 1 e incrementos de 1.

public class Endereco implements Serializable { 
// Define a classe "Endereco" que implementa a interface "Serializable", permitindo a conversão de objetos dessa classe para uma sequência de bytes.

    private static final long serialVersionUID = 1L; 
    // Define um número de versão único para a serialização da classe, garantindo compatibilidade durante a deserialização.

    @Id 
    // Indica que o campo "id" é a chave primária da tabela.

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco") 
    // Especifica que o valor de "id" será gerado automaticamente usando uma sequência definida anteriormente.

    private Long id; 
    // Campo "id" que será a chave primária da entidade.

    private String ruaLogra; 
    // Campo que representa o logradouro ou nome da rua.

    private String cep; 
    // Campo que representa o CEP (Código de Endereçamento Postal).

    private String numero; 
    // Campo que representa o número da residência ou estabelecimento.

    private String complemento; 
    // Campo que representa um complemento do endereço, como apartamento, bloco, etc.

    private String bairro; 
    // Campo que representa o bairro do endereço.

    private String uf; 
    // Campo que representa a Unidade Federativa (estado) do endereço.

    private String cidade; 
    // Campo que representa a cidade do endereço.

    @ManyToOne(targetEntity = Pessoa.class) 
    // Indica uma relação "muitos-para-um" com a entidade "Pessoa". Cada endereço pertence a uma pessoa.

    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk")) 
    // Especifica a coluna de junção "pessoa_id" para a chave estrangeira que referencia a tabela "Pessoa". A chave é obrigatória.

    private Pessoa pessoa; 
    // Campo que representa a relação com a entidade "Pessoa".

    @Enumerated(EnumType.STRING) 
    // Especifica que o campo "tipoEndereco" será salvo como uma string no banco de dados e usará a enumeração "TipoEndereco".

    private TipoEndereco tipoEndereco; 
    // Campo que representa o tipo de endereço, como "COBRANCA" ou "ENTREGA".

    public void setTipoEndereco(TipoEndereco tipoEndereco) { 
    // Método setter para definir o valor de "tipoEndereco".

        this.tipoEndereco = tipoEndereco; 
        // Atribui o valor de "tipoEndereco".
    }

    public TipoEndereco getTipoEndereco() { 
    // Método getter para acessar o valor de "tipoEndereco".

        return tipoEndereco; 
        // Retorna o valor de "tipoEndereco".
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

    public String getRuaLogra() { 
    // Método getter para acessar o campo "ruaLogra".

        return ruaLogra; 
        // Retorna o valor de "ruaLogra".
    }

    public void setRuaLogra(String ruaLogra) { 
    // Método setter para definir o valor de "ruaLogra".

        this.ruaLogra = ruaLogra; 
        // Atribui o valor de "ruaLogra".
    }

    public String getCep() { 
    // Método getter para acessar o campo "cep".

        return cep; 
        // Retorna o valor de "cep".
    }

    public void setCep(String cep) { 
    // Método setter para definir o valor de "cep".

        this.cep = cep; 
        // Atribui o valor de "cep".
    }

    public String getNumero() { 
    // Método getter para acessar o campo "numero".

        return numero; 
        // Retorna o valor de "numero".
    }

    public void setNumero(String numero) { 
    // Método setter para definir o valor de "numero".

        this.numero = numero; 
        // Atribui o valor de "numero".
    }

    public String getComplemento() { 
    // Método getter para acessar o campo "complemento".

        return complemento; 
        // Retorna o valor de "complemento".
    }

    public void setComplemento(String complemento) { 
    // Método setter para definir o valor de "complemento".

        this.complemento = complemento; 
        // Atribui o valor de "complemento".
    }

    public String getBairro() { 
    // Método getter para acessar o campo "bairro".

        return bairro; 
        // Retorna o valor de "bairro".
    }

    public void setBairro(String bairro) { 
    // Método setter para definir o valor de "bairro".

        this.bairro = bairro; 
        // Atribui o valor de "bairro".
    }

    public String getUf() { 
    // Método getter para acessar o campo "uf".

        return uf; 
        // Retorna o valor de "uf".
    }

    public void setUf(String uf) { 
    // Método setter para definir o valor de "uf".

        this.uf = uf; 
        // Atribui o valor de "uf".
    }

    public String getCidade() { 
    // Método getter para acessar o campo "cidade".

        return cidade; 
        // Retorna o valor de "cidade".
    }

    public void setCidade(String cidade) { 
    // Método setter para definir o valor de "cidade".

        this.cidade = cidade; 
        // Atribui o valor de "cidade".
    }

    public Pessoa getPessoa() { 
    // Método getter para acessar o campo "pessoa".

        return pessoa; 
        // Retorna o valor de "pessoa".
    }

    public void setPessoa(Pessoa pessoa) { 
    // Método setter para definir o valor de "pessoa".

        this.pessoa = pessoa; 
        // Atribui o valor de "pessoa".
    }

    @Override 
    // Sobrescreve o método "hashCode()" para gerar um código hash para a entidade, baseado no campo "id".

    public int hashCode() { 
    // Retorna o código hash da entidade.

        return Objects.hash(id); 
        // Usa o método "Objects.hash()" para gerar um código hash baseado no campo "id".
    }

    @Override 
    // Sobrescreve o método "equals()" para comparar dois objetos da classe "Endereco".

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

        Endereco other = (Endereco) obj; 
        // Converte o outro objeto para o tipo "Endereco".

        return Objects.equals(id, other.id); 
        // Compara o campo "id" dos dois objetos.
    }
}
