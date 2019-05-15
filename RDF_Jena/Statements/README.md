# Sentenças
 Uma sentença, ou statement, são a combinação um Recurso, uma Propriedade e um Valor de Propriedade. Cada arco no modelo RDF
 é uma sentença. De modo mais simples, elas definem um fato sobre um recurso.
 
## Estrutura de Sentenças
As sentenças são compostas por três partes:
 
 * Sujeito - do qual se declara algo
 * Predicado - descritor de relacionamento
 * Objeto - Valor de uma propriedade ou recurso
 
Essa organização é chamada de Tripla RDF, justamente por ser composta de três partes.

## [Exemplo - Modelo RDF](https://github.com/luksave/Jena-Tutorial/blob/master/RDF_Jena/Statements/tutorial_01_statements.java)
É possível definir um modelo RDF como um conjunto de sentenças. No exemplo desta pasta, é usada uma interface
para estender um exemplo anterior e listar todas as sentenças criadas e imprimi-las. A interface usada define um método chamado
listStatements() que retorna um StmtIterator, para iterar sob as sentenças. Este iterador possui um método chamado nextStatement
que retorna a próxima sentença do iterador, além de métodos para acessar sujeito predicado e objeto de uma sentença.

Os objetos de uma sentença podem ser tanto valores literais quanto outros recursos, por conta disso, o método getObject() 
retorna um objeto do tipo RDFNode, que  uma superclasse comum de ambos Resource e Literal. Dái a necessidade do uso de 
instanceof para determinar qual e processá-lo de acordo.
