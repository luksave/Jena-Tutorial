# Navegação em Modelos
Para acessar as informações em um modelo é usada a URI de um recurso. Dada a URI de um recurso qualquer, o objeto deste recurso pode ser recuperado através do método getResource(String uri). Se o objeto do tipo Resource existe no modelo ele é recuperado, caso contrário, é criado um novo objeto.

Neste [exemplo](https://github.com/luksave/Jena-Tutorial/blob/master/RDF_Jena/Navigating/Tutorial_01_navigating.java) há a definição de um modelo simples, com um recurso nomeado 'lucasfelipe'. O seguinte trecho de código recupera o recurso, adicionando em uma variável do tipo recurso que em seguida tem sua propriedade 'Given' impressa:

Resource vcard = model.getResource(lucasfelipe);
