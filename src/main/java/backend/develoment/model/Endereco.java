package backend.develoment.model;

import java.io.Serializable;
import java.util.Objects;
import backend.develoment.enums.TipoEndereco;
import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
@SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco", allocationSize = 1, initialValue = 1)
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
	private Long id;

	private String ruaLogra;
	private String cep;
	private String numero;
	private String complemento;
	private String bairro;
	private String uf;
	private String cidade;

	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
	private Pessoa pessoa;

	@Enumerated(EnumType.STRING)
	private TipoEndereco tipoEndereco;

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRuaLogra() {
		return ruaLogra;
	}

	public void setRuaLogra(String ruaLogra) {
		this.ruaLogra = ruaLogra;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}
}

/*
 * Resumo do que o código faz:
 * 
 * A classe Endereco representa uma entidade de endereço no contexto de uma
 * aplicação Java, que utiliza JPA para persistência de dados. Ela tem os
 * seguintes atributos:
 * 
 * id: chave primária gerada automaticamente. ruaLogra: nome da rua ou
 * logradouro. cep: código postal (CEP). numero: número do endereço.
 * complemento: informações adicionais como apartamento ou bloco. bairro: bairro
 * do endereço. uf: estado (Unidade Federativa). cidade: cidade do endereço.
 * pessoa: relacionamento com a entidade Pessoa, onde muitos endereços podem
 * pertencer a uma pessoa. tipoEndereco: enumeração que define o tipo de
 * endereço (ex. cobrança ou entrega).
 * 
 * A classe implementa Serializable, o que permite que seus objetos sejam
 * transformados em bytes para armazenamento ou transmissão. Ela também redefine
 * os métodos hashCode() e equals() para comparar objetos da classe Endereco com
 * base no atributo id.
 */