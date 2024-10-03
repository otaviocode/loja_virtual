package backend.develoment.model;
// Define o pacote onde esta classe está localizada, chamado "backend.develoment.model".

import java.io.Serializable;
// Importa a interface "Serializable", que permite que objetos dessa classe possam ser convertidos em uma sequência de bytes (para armazenamento ou transmissão).

import jakarta.persistence.*;
// Importa as anotações e classes do JPA (Jakarta Persistence API) para mapear a entidade e suas propriedades ao banco de dados.

@Entity
// Indica que esta classe é uma entidade JPA que será mapeada para uma tabela no banco de dados.

@Table(name = "marca_produto")
// Especifica o nome da tabela no banco de dados que será usada para armazenar as instâncias desta entidade. No caso, será a tabela "marca_produto".

@SequenceGenerator(name = "seq_marca_produto", sequenceName = "seq_marca_produto", allocationSize = 1, initialValue = 1)
// Define um gerador de sequência para a chave primária da entidade, com o nome "seq_marca_produto", iniciando no valor 1 e incrementando em 1 a cada novo registro.

public class MarcaProduto implements Serializable {
// Define a classe "MarcaProduto", que implementa a interface "Serializable", permitindo que objetos dessa classe possam ser serializados.

    private static final long serialVersionUID = 1L;
    // Número de versão da classe para garantir compatibilidade durante o processo de serialização e deserialização.

    @Id
    // Indica que o campo "id" é a chave primária da tabela no banco de dados.

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marca_produto")
    // Define que o valor do campo "id" será gerado automaticamente usando uma sequência, conforme definido anteriormente.

    private Long id;
    // Campo que representa a chave primária "id" da tabela "marca_produto".

    @Column(nullable = false)
    // Define que o campo "nomeDesc" é uma coluna no banco de dados que não pode ser nula (obrigatório).

    private String nomeDesc;
    // Campo que representa a descrição da marca do produto, será armazenada no banco de dados como uma string.

    public Long getId() {
    // Método getter para acessar o valor de "id".

        return id;
    }

    public void setId(Long id) {
    // Método setter para definir o valor de "id".

        this.id = id;
    }

    public String getNomeDesc() {
    // Método getter para acessar o valor de "nomeDesc".

        return nomeDesc;
    }

    public void setNomeDesc(String nomeDesc) {
    // Método setter para definir o valor de "nomeDesc".

        this.nomeDesc = nomeDesc;
    }

}
