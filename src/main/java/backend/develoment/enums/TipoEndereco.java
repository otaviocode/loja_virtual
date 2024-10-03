package backend.develoment.enums; 
// Define o pacote ao qual esta classe enum pertence, chamado "backend.develoment.enums". Isso organiza melhor o código, colocando enums em um local específico.

public enum TipoEndereco { 
// Declara um enum chamado "TipoEndereco", que é um tipo especial de classe em Java, usado para definir um conjunto fixo de constantes (no caso, tipos de endereço).

    COBRANCA("Cobrança"), 
    // Define uma constante chamada "COBRANCA" e associa a ela a string "Cobrança".
    
    ENTREGA("Entrega"); 
    // Define uma constante chamada "ENTREGA" e associa a ela a string "Entrega".

    private String descricao; 
    // Declara um campo privado "descricao" para armazenar a descrição associada a cada constante do enum.

    private TipoEndereco(String descricao) { 
    // Construtor privado do enum, usado para atribuir a string fornecida ao campo "descricao" quando a constante é inicializada.
        this.descricao = descricao; 
        // Atribui o valor da string passada para o campo "descricao".
    }

    public String getDescricao() { 
    // Método público que retorna a descrição associada à constante do enum.
        return descricao; 
    }

    @Override 
    // Sobrescreve o método toString() da classe Object, que é chamado quando uma representação em string da constante é necessária.
    public String toString() { 
        return this.descricao; 
        // Retorna a descrição da constante do enum ao invés do nome da constante, quando o método toString() é chamado.
    }
}
