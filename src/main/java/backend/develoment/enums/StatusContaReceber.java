package backend.develoment.enums;

public enum StatusContaReceber {

	COBRANCA("Pagar"), VENCIDA("Vencida"), ABERTA("Aberta"), QUITADA("Quitada");

	private String descricao;

	private StatusContaReceber(String descricao) {
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
 * Este código define uma enumeração (enum) chamada StatusContaReceber, que
 * lista os possíveis status de uma conta a receber. As opções incluem:
 * 
 * COBRANCA ("Pagar"), VENCIDA ("Vencida"), ABERTA ("Aberta"), QUITADA
 * ("Quitada").
 * 
 * Cada status tem uma descrição associada, armazenada em uma variável
 * descricao. O método getDescricao() permite acessar a descrição de cada
 * status, enquanto o método toString() foi sobrescrito para retornar essa
 * descrição diretamente.
 * 
 * A enumeração é útil para representar de maneira clara e padronizada os
 * diferentes estados em que uma conta a receber pode se encontrar.
 */