package backend.develoment.enums;

public enum StatusContaPagar {

	COBRANCA("Pagar"), VENCIDA("Vencida"), ABERTA("Aberta"), QUITADA("Quitada"), NEGOCIADA("Renegociada"),
	ALUGUEL("Aluguel"), FUNCIONARIO("Funcionario");

	private String descricao;

	private StatusContaPagar(String descricao) {
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
 * Este código define uma enumeração (enum) chamada StatusContaPagar, que
 * representa os diferentes estados que uma conta a pagar pode ter. As opções
 * incluem:
 * 
 * COBRANCA ("Pagar"), VENCIDA ("Vencida"), ABERTA ("Aberta"), QUITADA
 * ("Quitada"), NEGOCIADA ("Renegociada"), ALUGUEL ("Aluguel"), FUNCIONARIO
 * ("Funcionario").
 * 
 * Cada constante da enumeração tem uma descrição associada que é armazenada em
 * uma variável descricao. O método getDescricao() permite acessar essa
 * descrição, e o método toString() foi sobrescrito para retornar diretamente o
 * valor da descrição.
 * 
 * Esta enumeração é útil para organizar os diferentes status de contas a pagar
 * de uma maneira clara e padronizada.
 */