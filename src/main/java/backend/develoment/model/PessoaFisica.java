package backend.develoment.model;
// Define o pacote onde a classe está localizada.

import java.util.Date;
// Importa a classe Date para manipulação de datas.

import jakarta.persistence.*;
// Importa anotações do JPA (Jakarta Persistence API) para mapear a entidade ao banco de dados.

@Entity
// Indica que esta classe será mapeada para uma tabela no banco de dados.

@Table(name = "pessoa_fisica")
// Especifica o nome da tabela correspondente a esta entidade.

public class PessoaFisica extends Pessoa {
// Define a classe "PessoaFisica", que herda de "Pessoa", permitindo que ela utilize os atributos e métodos da classe pai.

    private static final long serialVersionUID = 1L;
    // Número de versão para garantir a compatibilidade durante o processo de serialização.

    @Column(nullable = false)
    // Indica que o campo "cpf" não pode ser nulo no banco de dados.

    private String cpf;
    // Campo para armazenar o CPF da pessoa física.

    @Temporal(TemporalType.DATE)
    // Indica que o campo "dataNascimento" deve ser tratado como uma data.

    private Date dataNascimento;
    // Campo para armazenar a data de nascimento da pessoa física.

    public String getCpf() {
    // Método getter para acessar o CPF da pessoa física.

        return cpf;
    }

    public void setCpf(String cpf) {
    // Método setter para definir o CPF da pessoa física.

        this.cpf = cpf;
    }

    public Date getDataNascimento() {
    // Método getter para acessar a data de nascimento da pessoa física.

        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
    // Método setter para definir a data de nascimento da pessoa física.

        this.dataNascimento = dataNascimento;
    }
}
