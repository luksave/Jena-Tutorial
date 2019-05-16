package jena.examples.rdf ;

import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;

/** Tutorial 2 Criando um modelo simples e listando suas sentenças em XML
 */

public class tutorial_02_statements extends Object {
    // Algumas definições 
    static String personURI    = "http://somewhere/LucasFelipe";
    static String givenName    = "Lucas Felipe";
    static String familyName   = "Moreira Silva";
    static String fullName     = givenName + " " + familyName;
    
      public static void main (String args[]) {
        // Cria um modelo vazio
        Model model = ModelFactory.createDefaultModel();

       	// Cria o recurso e adiciona algumas propriedades (estilo cascata)
       	Resource lucasFelipe = model.createResource(personURI)
								 .addProperty(VCARD.FN, fullName)
								 .addProperty(VCARD.N, model.createResource()
												   .addProperty(VCARD.Given, givenName)
												   .addProperty(VCARD.Family, familyName));
      
      
				// Lista as sentenças do modelo através da interface do iterador
				StmtIterator iter = model.listStatements();

				// Imprime o modelo criado no formato XML
				model.write(System.out); 

		}

}
