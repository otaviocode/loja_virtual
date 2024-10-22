package backend.develoment.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "form_pagamento")
@SequenceGenerator(name = "seq_form_pagamento", sequenceName = "seq_form_pagamento", allocationSize = 1, initialValue = 1)
public class FormaPagamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_form_pagamento")
	private Long id;

	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		FormaPagamento other = (FormaPagamento) obj;
		return Objects.equals(id, other.id);
	}
}

/*
 * O código acima define uma classe chamada FormaPagamento, que mapeia para uma
 * tabela no banco de dados chamada form_pagamento por meio do JPA. Aqui está um
 * resumo da implementação: Descrição da Classe FormaPagamento
 * 
 * Anotações:
 * 
 * @Entity: Define que essa classe é uma entidade JPA.
 * 
 * @Table(name = "form_pagamento"): Especifica o nome da tabela no banco de
 * dados.
 * 
 * @SequenceGenerator: Define um gerador de sequência para o campo id,
 * controlando o auto-incremento dos valores.
 * 
 * @Id: Define que o campo id é a chave primária.
 * 
 * @GeneratedValue: Especifica a estratégia de geração automática de valores
 * para o campo id, utilizando a sequência seq_form_pagamento.
 */