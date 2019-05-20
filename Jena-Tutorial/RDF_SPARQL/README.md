# SPARQL
Como mencionado na seção [query](https://github.com/luksave/Jena-Tutorial/tree/master/RDF_Jena/Querys#consultas-em-modelos) de Jena, SPARQL provê consultas mais poderosas sob os modelos do que Jena.

SPARQL é uma linguagem de consulta e um protocolo para acessar RDF baseado no padrão W3C. Como linguagem de consulta, SPARQL é orientado a dados, isto é, só consulta informações armazenadas em modelos; não há inferência pela linguagem de consulta em si. SPARQL não faz nada além de obter a descrição de algo que uma aplicação deseja, na forma de uma consulta, e retornar a informação, na forma de um conjunto de ligações ou como um grafo RDF.

## Formato de Dados
SPARQL consulta grafos RDF. Um grafo RDF é um conjunto de triplas. O que importa para SPARQL são as triplas, e não a serialização. A serialização é apenas uma maneira de escrever as triplas. 

RDF/XML é uma recomendação da W3C, mas isso pode dificultar a visão das triplas, já que há múltiplas formas de codificar o mesmo grafo. O [tutorial disponibilizado oficialmente](https://jena.apache.org/tutorials/sparql_data_pt.html), usa uma serialização mais parecida com triplas, chamada Turtle.

Em [formato de dados](https://github.com/luksave/Jena-Tutorial/tree/master/RDF_SPARQL/Formato%20de%20Dados) é possível encontrar o arquivo vc-db-1.rdf, que contém RDF ALGUMAS descrições de vcards de pessoas, uma representação gráfica das triplas e duas escritas.



