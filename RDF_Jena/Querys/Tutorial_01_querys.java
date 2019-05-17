import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.*;

import java.io.*;

/** Tutorial 01 - Selecionando recursos com VCARD via recurso com propriedade
*/
public class Tutorial_01_querys {

static final String inputFileName = "vc-db-1.rdf";
    
    public static void main (String args[]) {
        
    	// Cria um modelo vazio
        Model model = ModelFactory.createDefaultModel();
       
      // Leitura do arquivo RDF/XML, tratando excessão de não encontrado 
      InputStream in = FileManager.get().open(inputFileName);
      if (in == null) throw new IllegalArgumentException( "File: " + inputFileName + " not found");
      model.read( in, "");
      
      // Selecionando todos os recursos com uma propriedade VCARD.FN
      ResIterator iter = model.listResourcesWithProperty(VCARD.FN);
      if (iter.hasNext()){
          System.out.println("O banco de dados contém vcards para:");

          while (iter.hasNext())
              System.out.println("  " + iter.nextResource()
                                            .getRequiredProperty(VCARD.FN)
                                            .getString() );
             
      }else 
          System.out.println("Nenhum vcard encontrado");
                  
  }

}

