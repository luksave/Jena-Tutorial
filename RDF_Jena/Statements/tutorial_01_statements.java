package jena.examples.rdf ;

import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;

/** Tutorial 1 Criando um modelo simples e listando suas sentenças
 */

public class Tutorial01 extends Object {
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
								 .addProperty(VCARD.N,
											  model.createResource()
												   .addProperty(VCARD.Given, givenName)
												   .addProperty(VCARD.Family, familyName));
      
      

				// Lista as sentenças do modelo através da interface do iterador
				StmtIterator iter = model.listStatements();

				// Dá como saída o predicado, sujeito e objeto de cada sentença
				while (iter.hasNext()) {
					Statement stmt      = iter.nextStatement();  // Obtém a próxima sentença
					Resource  subject   = stmt.getSubject();     // Obtém o sujeito da sentença
					Property  predicate = stmt.getPredicate();   // Obtém o predicado da sentença
					RDFNode   object    = stmt.getObject();      // Obtém o objeto da sentença

					System.out.print(subject.toString());
					System.out.print(" " + predicate.toString() + " ");
					
					if (object instanceof Resource) 
						System.out.print(object.toString());

					// Se o objeto é na verdade um literal
					else 
						System.out.print(" \"" + object.toString() + "\"");

					System.out.println(" .");

				} 

		}

}
