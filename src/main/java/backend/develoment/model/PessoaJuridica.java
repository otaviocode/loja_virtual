package backend.develoment.model;
// Define o pacote onde a classe está localizada.

import jakarta.persistence.Entity;
// Importa a anotação Entity do JPA (Jakarta Persistence API) para mapear a classe como uma entidade.

import jakarta.persistence.Table;
// Importa a anotação Table do JPA para especificar a tabela correspondente à entidade.

@Entity
// Indica que esta classe será mapeada para uma tabela no banco de dados.

@Table(name = "pessoa_juridica")
// Especifica o nome da tabela correspondente a esta entidade.

public class PessoaJuridica extends Pessoa {
// Define a classe "PessoaJuridica", que herda de "Pessoa", permitindo que ela utilize os atributos e métodos da classe pai.

    private static final long serialVersionUID = 1L;
    // Número de versão para garantir a compatibilidade durante o processo de serialização.

    private String cnpj;
    // Campo para armazenar o CNPJ da pessoa jurídica.

    private String inscEstadual;
    // Campo para armazenar a inscrição estadual da pessoa jurídica.

    private String inscMunicipal;
    // Campo para armazenar a inscrição municipal da pessoa jurídica.

    private String nomeFantasia;
    // Campo para armazenar o nome fantasia da empresa.

    private String razaoSocial;
    // Campo para armazenar a razão social da empresa.

    private String categoria;
    // Campo para armazenar a categoria da pessoa jurídica.

    public String getCnpj() {
    // Método getter para acessar o CNPJ da pessoa jurídica.

        return cnpj;
    }

    public void setCnpj(String cnpj) {
    // Método setter para definir o CNPJ da pessoa jurídica.

        this.cnpj = cnpj;
    }

    public String getInscEstadual() {
    // Método getter para acessar a inscrição estadual da pessoa jurídica.

        return inscEstadual;
    }

    public void setInscEstadual(String inscEstadual) {
    // Método setter para definir a inscrição estadual da pessoa jurídica.

        this.inscEstadual = inscEstadual;
    }

    public String getInscMunicipal() {
    // Método getter para acessar a inscrição municipal da pessoa jurídica.

        return inscMunicipal;
    }

    public void setInscMunicipal(String inscMunicipal) {
    // Método setter para definir a inscrição municipal da pessoa jurídica.

        this.inscMunicipal = inscMunicipal;
    }

    public String getNomeFantasia() {
    // Método getter para acessar o nome fantasia da pessoa jurídica.

        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
    // Método setter para definir o nome fantasia da pessoa jurídica.

        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
    // Método getter para acessar a razão social da pessoa jurídica.

        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
    // Método setter para definir a razão social da pessoa jurídica.

        this.razaoSocial = razaoSocial;
    }

    public String getCategoria() {
    // Método getter para acessar a categoria da pessoa jurídica.

        return categoria;
    }

    public void setCategoria(String categoria) {
    // Método setter para definir a categoria da pessoa jurídica.

        this.categoria = categoria;
    }
}
