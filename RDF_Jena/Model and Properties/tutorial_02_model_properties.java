package jena.examples.rdf ;

import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;

/** Tutorial 2 criando um modelo e adicionando propriedades a um recurso
 */

public class Tutorial01 extends Object {
    
	//Algumas definições
    static String personURI    = "http://somewhere/LucasFelipe";
    static String givenName    = "Lucas Felipe";
    static String familyName   = "Moreira Silva";
    static String fullName     = givenName + " " + familyName;
    
      public static void main (String args[]) {
        
		//Modelo vazio criado
        Model model = ModelFactory.createDefaultModel();

       // Criando o recurso lucasfelipe e adicionando propriedades a ele (estilo cascata)
       Resource lucasFelipe = model.createResource(personURI)
								 .addProperty(VCARD.FN, fullName)
								 .addProperty(VCARD.N,
											  model.createResource()
												   .addProperty(VCARD.Given, givenName)
												   .addProperty(VCARD.Family, familyName));
      
      }
}
