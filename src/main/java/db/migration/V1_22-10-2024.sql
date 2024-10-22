SELECT constraint_name 
FROM information_schema.constraint_column_usage 
WHERE table_name = 'usuario_acesso' 
AND column_name = 'acesso_id' 
AND constraint_name <> 'unique_acesso_user';

ALTER TABLE usuarios_acesso 
DROP CONSTRAINT "uk8bak9jswon2id2jbunuqlfl9e";

/*Explicação:

Primeira Parte (SELECT):
A consulta busca o nome de uma restrição (constraint_name) na tabela usuarios_acesso, onde 
a coluna acesso_id está envolvida. No entanto, a condição AND column_name = 'acesso_id' foi 
repetida duas vezes (o que não é necessário).
Ela também exclui da seleção a restrição chamada unique_acesso_user usando 
constraint_name <> 'unique_acesso_user'.
Segunda Parte (ALTER TABLE):
O comando ALTER TABLE remove a restrição uk8bak9jswon2id2jbunuqlfl9e da tabela usuarios_acesso. 
Esse tipo de restrição pode ser uma chave única ou estrangeira que está sendo removida da 
estrutura da tabela.
Melhorias sugeridas:

Remover a repetição da condição AND column_name = 'acesso_id' na cláusula WHERE para 
simplificar a consulta:*/
