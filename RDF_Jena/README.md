# Introdução ao RDF com Jena
Exemplos para estudo seguindo os tutoriais disponíveis no site [oficial](https://jena.apache.org/tutorials/rdf_api_pt.html).

## Introdução
Jena é uma API Java que poder ser usada para criar e manipular grafos RDF. Jena possui classes para representar grafos, 
recursos, propriedades e literais.

### Algumas definições
- **RDF** é um padrão para descrição de recursos.
- **Recursos** são tudo aquilo que se pode identificar.
- Recursos possuem **propriedades**; representadas por arcos, intitulados com o nome da propriedade.
- O nome de uma propriedade é também uma URI.
- Toda propriedade possui um **valor**, que pode ou não ser um literal.
- Um **modelo** de dados representa propriedades nomeadas e seus valores.
- O **modelo de dados RDF** é uma forma de representar sentenças RDF independetemente de sintaxe. 
- Um **grafo RDF** é a representação de um modelo de dados RDF.
- Uma **sentença** ou **tripla** é um arco (aresta) no modelo RDF, elas definem fatos sobre os recursos
