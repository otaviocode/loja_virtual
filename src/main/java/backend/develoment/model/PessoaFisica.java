package backend.develoment.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String cpf;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}

/*
 * A classe PessoaFisica estende a classe Pessoa, adicionando os atributos cpf e
 * dataNascimento com seus respectivos métodos getter e setter.
 */