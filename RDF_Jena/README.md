Introdução ao RDF com Jena
============
Exemplos para estudo seguindo os tutoriais disponíveis no site [oficial](https://jena.apache.org/tutorials/rdf_api_pt.html).

## Introdução

### RDF
RDF (Framework para Descrição de Recursos), é um padrão para descrição de recursos, ou melhor, para tudo que pode ser identificado. Geralmente, o RDF é representado como um diagrama de nós e arcos, chamados grafos (vide exemplo).

![Figura 1 - Grafo JohnSmith](https://i.imgur.com/oSlJDVe.png)

O código usado para criar esse grafo, ou modelo, pode ser encontrado [neste exemplo]().

Recursos possuem propriedades, as quais são atributos do recurso e podem possuir valor. Nos grafos, é comum que os recursos sejam identificados por elipses e uma URI. As propriedades são identificadas pelos arcos e seus valores pelos retângulos.

##### URI e IRI
URIs são Identificadores Uniformes de Recursos, enquanto as IRIs podem ser consideradas a versão internacionalizada das URIs. 

Diversas organizações podem definir suas próprias definições para um recurso e, às vezes, um mesmo identificador pode acabar definindo mais de um recurso. Para que o parser (Software que processa o conteúdo de um XML) da XML (Linguagem de marcação sob a qual o RDF é baseado) possa lidar com essas múltiplas definições, elas são organizadas em Namespaces, por exemplo vcard no grafo acima.


### Jena
Jena é uma API Java que poder ser usada para criar e manipular grafos RDF. Jena possui classes para representar grafos, 
recursos, propriedades e literais.


## Tabela de definições

| Termo | Descrição |
| ----- | --------- |
| 'RDF' | Padrão/Framework para Descrição de Recursos |
| 'URI' | Identificador Uniforme de Recursos |
| 'IRI' | Padrão de URI internacional |
| 'Recursos' | Tudo aquilo que se pode identificar, representadas em elipses |
| 'Propriedades' | Definidas sob recursos, são representadas por arcos, intitulados com o nome da propriedade|
| 'Valor' | Toda propriedade possui um valor (pode ou não ser um literal), representadas por retângulos |
| 'Namespaces'| São espaços de nomes com conjuntos de identificadores  |
| 'Modelo' |  É a interface que representa recursos, propriedades e literais|
| 'Modelo de dados RDF' | Forma de representar sentenças RDF independetemente de sintaxe |
| 'Grafo RDF' | Representação (modelagem matemática) de um modelo de dados RDF |
| 'Sentença ou Tripla' | Definem fatos sobre os recursos. É um arco (aresta) no modelo RDF|

