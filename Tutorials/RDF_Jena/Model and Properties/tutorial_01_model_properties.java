// Algumas definições
static String personURI    = "http://somewhere/JohnSmith";
static String fullName     = "John Smith";

// Criando um modelo vazio
Model model = ModelFactory.createDefaultModel();

// Criando o recurso
Resource johnSmith = model.createResource(personURI);

// Adiciona uma propriedade
 johnSmith.addProperty(VCARD.FN, fullName);
