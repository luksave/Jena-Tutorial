# Sentenças
 Uma sentença, ou statement, são a combinação um Recurso, uma Propriedade e um Valor de Propriedade. Cada arco no modelo RDF
 é uma sentença. De modo mais simples, elas definem um fato sobre um recurso.
 
## Estrutura de Sentenças
As sentenças são compostas por três partes:

![Figura 2 - Estrutura de Sentença](https://i.imgur.com/MfI0rKN.png)
 
 * Sujeito - Do qual se declara algo - Exemplo: Lucas Felipe
 * Predicado - Descritor de relacionamento - Exemplo: Tem idade
 * Objeto - Valor de uma propriedade ou recurso - Exemplo: 22
 
Essa organização é chamada de Tripla RDF, justamente por ser composta de três partes.

## [Exemplo - Modelo RDF em Triplas](https://github.com/luksave/Jena-Tutorial/blob/master/RDF_Jena/Statements/tutorial_01_statements.java)
É possível definir um modelo RDF como um conjunto de sentenças. No exemplo desta pasta, é usada uma interface
para estender um exemplo anterior e listar todas as sentenças criadas e imprimi-las. A interface usada define um método chamado
listStatements() que retorna um StmtIterator, para iterar sob as sentenças. Este iterador possui um método chamado nextStatement
que retorna a próxima sentença do iterador, além de métodos para acessar sujeito predicado e objeto de uma sentença.

Os objetos de uma sentença podem ser tanto valores literais quanto outros recursos, por conta disso, o método getObject() 
retorna um objeto do tipo RDFNode, que  uma superclasse comum de ambos Resource e Literal. Dái a necessidade do uso de 
instanceof para determinar qual e processá-lo de acordo.

A execução deste exemplo deve ter como saída:

    e7c622fa-ae15-4e8f-9567-6ac5394477a8 http://www.w3.org/2001/vcard-rdf/3.0#Family  "Moreira Silva" .
    e7c622fa-ae15-4e8f-9567-6ac5394477a8 http://www.w3.org/2001/vcard-rdf/3.0#Given  "Lucas Felipe" .
    http&#58;//somewhere/LucasFelipe http://www.w3.org/2001/vcard-rdf/3.0#N e7c622fa-ae15-4e8f-9567-6ac5394477a8 .
    http&#58;//somewhere/LucasFelipe http://www.w3.org/2001/vcard-rdf/3.0#FN  "Lucas Felipe Moreira Silva" .
    
## [Exemplo - Modelo RDF XML](https://github.com/luksave/Jena-Tutorial/blob/master/RDF_Jena/Statements/tutorial_02_statements.java)
Jena possui métodos para ler e escrever RDF como XML. Estes métodos podem armazenar o modelo RDF em um arquivo e carregá-lo novamente em outro momento.

Este exemplo apresenta o mesmo modelo RDF do anterior, mas impesso no formato XML. A sintaxe do XML é um pouco mais complexa por não ter sido feita com foco no entendimento humano, mas sim no de máquinas.

A execução deste exemplo deve ter como saída:

	<rdf:RDF
		xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
		xmlns:vcard="http://www.w3.org/2001/vcard-rdf/3.0#">
		<rdf:Description rdf:about="http://somewhere/LucasFelipe">
			<vcard:N rdf:parseType="Resource">
			  <vcard:Family>Moreira Silva</vcard:Family>
			  <vcard:Given>Lucas Felipe</vcard:Given>
			</vcard:N>
			<vcard:FN>Lucas Felipe Moreira Silva</vcard:FN>
		</rdf:Description>
	</rdf:RDF>

