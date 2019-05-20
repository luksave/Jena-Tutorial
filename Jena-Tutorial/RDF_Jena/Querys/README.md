# Consultas em Modelos
O core de Jena possibilita um númeto limitado de primitivas de consulta, por exemplo os métodos para navegar um modelo a partir de recursos com URIs conhecidas, recuperar um recurso através de um valor de propriedade, etc. SPARQL provê consultas mais poderosas sob os modelos.

Métodos como Model.listStatements() e Model.listSubjects são os mais simples. O primeiro lista todas as sentenças de um modelo, o que pode não ser interessante dependendo do tamanho de um modelo. O segundo é similar, mas retorna um iterador sobre os recursos que possem propriedades, ou seja, fazem parte de uma sentença. Para listar apenas os recursos que possuem determinada propriedade P é possível usar Model.listSubjectWithProperty(Property P, RDF).  

Assumindo que somente recursos vcard terão a propriedade vcard:FN e que, no dados, todos os recursos possuem essa propriedades, será possível encontrar todos os vcards da seguinte maneira:

		// Listar vcards
		ResIterator iter = model.listSubjectsWithProperty(VCARD.FN);
		while (iter.hasNext()) {
				Resource r = iter.nextResource();
				...
		}

Todos esse métodos são baseados em model.listStatements(Selector s), método que retorna um iterador sobre todas as sentenças no modelo selecionado por s. Apesar de possuir uma interface flexível só há uma implementação atualmente para selector, a classe SimpleSelector.

		Selector selector = new SimpleSelector(subject, predicate, object)

Ele seleciona as sentenças em que o sujeito bate com subject e/ou um predicado que bate com predicate e/ou um objeto que bate com object. Cada um desses argumentos poderia ser passado como null para ser ignorados pelo seletor, que casaria qualquer coisa no lugar. Novamente, para selecionar todas as sentenças com o predicado VCARD.FN basta fazer:

		Selector selector = new SimpleSelector(null, VCARD.FN, null);

O [exemplo 1](https://github.com/luksave/Jena-Tutorial/blob/master/RDF_Jena/Querys/Tutorial_01_querys.java) realiza uma busca em um banco de dados RDF fazendo uso de model.listResourcesWithProperty(VCARD.FN); para iterar sobre recursos com a propriedade VCARD.FN. Enquanto [exemplo 2](https://github.com/luksave/Jena-Tutorial/blob/master/RDF_Jena/Querys/Tutorial_02_querys.java) realiza o mesmo trabalho fazendo uso de um selector.

Uma das vantagens do uso de um selector é poder refinar as consultas sobrescrevendo o método selects(...), como no [exemplo 3](https://github.com/luksave/Jena-Tutorial/blob/master/RDF_Jena/Querys/Tutorial_03_querys.java). Isso garante que, após o resultado da consulta de SimpleSelector, o resultado seja casado novamente com algum padrão defino; no exemplo, que o final da sentença tenha a cadeia "Smith".

