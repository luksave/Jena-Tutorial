# Operações em Modelos
Jena permite manipular modelos como um todo matematicamente através das três operações mais comuns de conjuntos: união, intersecção e diferença.

## União
A união de dois modelos é a união do conjunto de sentenças que representa cada modelo. Isso permite que fontes de dados discrepantes sejam juntadas. O processo procura nós em comum para a união, lidando com arcos duplicados quando preciso.

Considerando os seguintes modelos:

![Figura 3 - Modelos antes da união]()

O resultado da operação de união sobre eles será:

![Figura 4 - Modelos unidos]()

O [exemplo 1]() possui o fragmento de código de como a união pode ser feita.

## Intersecção
Pode ser computada da mesma forma que a união, fazendo o uso do método intersection(Model model). Essa operação cria um novo modelo independente que contém todas as sentenças que estão em ambos modelos, o modelo passado como parâmetro e as do outro modelo. O novo modelo não precisa ser do mesmo tipo do que foi passado como parâmetro ou do usado na diferença.

O [exemplo 2]() possui o fragmento de código de como a intersecção pode ser feita.

## Diferença
Pode ser computada da mesma forma que a união, fazendo o uso do método difference(Model modelo). Essa operação cria um novo modelo independente que contém todas as sentenças no modelo passado como parâmetro e que não estão em outro modelo. O novo modelo não precisa ser do mesmo tipo do que foi passado como parâmetro ou do usado na diferença.

O [exemplo 3]() possui o fragmento de código de como essa união pode ser feita. É importante notar que neste caso 

			Model modelA = model1.difference(model2);
			Model modelB = model2.difference(model1);

modelA e modelB são diferentes. A ordem dos operandos na diferença importa.
