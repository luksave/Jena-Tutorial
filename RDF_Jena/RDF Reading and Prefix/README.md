# Leitura
O exemplo faz a leitura de um arquivo no formato RDF, adiciona as informações em um modelo e imprime o modelo. O segundo 
argumento na função read() seria a URI a ser usada para resolver URIs relativas. Como no arquivo não há referências URI 
relativas, esse campo pode ser vazio.

# Controle de Prefixos

## Definição Explícita de Prefixos
A saída do exemplo leitura mostra que o XML criou um prefixo namespace vcard e o usa para abreviar URIs. RDF usa somente 
URIs completas, e não sua forma encurtada, Jena provê formas de controlar namespaces usados na saída com seu mapeamento de 
prefixos. Funciona como uma abreviação explícita do namespace. Por exemplo, para abreviar "http://somewhere/else#" 
basta fazer: 

```java
// Criação do modelo e atribuindo o valor do prefixo à string
Model m = ModelFactory.createDefaultModel();
String nsA = "http://somewhere/else#";

// Concatenação do prefixo com o nome do recurso
Resource root = m.createResource( nsA + "root" );

// Define a propriedade P  e o recurso x, ambos com o prefixo nsA
Property P = m.createProperty( nsA + "P" );
Resource x = m.createResource( nsA + "x" );

// Adiciona a sentença ao modelo
m.add( root, P, x );

// Definição do prefixo nsA no modelo m
m.setNsPrefix( "nsA", nsA );

// Impressão do modelo agora com o prefixo
m.write( System.out );
```

Sem a definição dos prefixos, os namespaces tem nomes criados automaticamente, como j.0, j.1, etc.


## Definição Implícita de Prefixos
Jena se lembra de prefixos usados anteriormente em entradas para model.read(), como as definidas acima pelo método 
setNsPrefix().

Um prefixo pode ser removido através do método removeNsPrefix(String prefix)
