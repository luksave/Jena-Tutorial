import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;

/** Tutorial 1 Navegando em um modelo simples
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
	  
	
	
			// Recupera o recurso e imprime seu identificador
	   	Resource recurso = model.getResource(personURI);
	   	System.out.println(recurso.toString()+ "\n");
	   	
			// Recupera uma propriedade como recurso e imprime a parte de interesse
	   	Resource nome = recurso.getProperty(VCARD.N).getResource();	
	   	System.out.println(nome.getProperty(VCARD.Given));
	}

}

