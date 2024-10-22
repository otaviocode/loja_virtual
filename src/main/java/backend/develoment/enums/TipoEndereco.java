package backend.develoment.enums;

public enum TipoEndereco {

	COBRANCA("Cobrança"), ENTREGA("Entrega");

	private String descricao;

	private TipoEndereco(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.descricao;
	}
}

/*
 * Resumo do Código:
 * 
 * Este código define uma enumeração (enum) chamada TipoEndereco, que representa
 * dois tipos de endereço:
 * 
 * COBRANCA ("Cobrança"), ENTREGA ("Entrega").
 * 
 * Cada constante enum tem uma descrição associada, armazenada na variável
 * descricao. O construtor privado atribui a descrição correspondente a cada
 * constante no momento da sua criação. O método getDescricao() permite acessar
 * essa descrição, e o método toString() foi sobrescrito para retornar a
 * descrição ao invés do nome da constante quando necessário.
 * 
 * A enum é útil para padronizar o uso de tipos de endereço dentro da aplicação,
 * evitando o uso de strings soltas e proporcionando maior consistência no
 * código.
 */