package jena.examples.rdf ;

import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;

/** Tutorial 1 creating a simple model
 */

public class Tutorial01 extends Object {
    // some definitions
    static String personURI    = "http://somewhere/LucasFelipe";
    static String givenName    = "Lucas Felipe";
    static String familyName   = "Moreira Silva";
    static String fullName     = givenName + " " + familyName;
    
      public static void main (String args[]) {
        // create an empty model
        Model model = ModelFactory.createDefaultModel();

       // create the resource and add properties (estilo cascata)
       Resource lucasFelipe = model.createResource(personURI)
								 .addProperty(VCARD.FN, fullName)
								 .addProperty(VCARD.N,
											  model.createResource()
												   .addProperty(VCARD.Given, givenName)
												   .addProperty(VCARD.Family, familyName));
      
      }

		// list the statements in the Model
		StmtIterator iter = model.listStatements();

		// print out the predicate, subject and object of each statement
		while (iter.hasNext()) {
			Statement stmt      = iter.nextStatement();  // get next statement
			Resource  subject   = stmt.getSubject();     // get the subject
			Property  predicate = stmt.getPredicate();   // get the predicate
			RDFNode   object    = stmt.getObject();      // get the object

			System.out.print(subject.toString());
			System.out.print(" " + predicate.toString() + " ");
			
			if (object instanceof Resource) 
				System.out.print(object.toString());

			// object is a literal
			else 
				System.out.print(" \"" + object.toString() + "\"");

			System.out.println(" .");
		} 

}
