import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.*;

import java.io.*;

/** Tutorial 03 - Selecionando recursos com VCARD via selector com maior refinação
*/
public class Tutorial_03_querys {

static final String inputFileName = "vc-db-1.rdf";
    
    public static void main (String args[]) {
        
    	// Cria um modelo vazio
        Model model = ModelFactory.createDefaultModel();
       
      // Cria um seletor para vcards que são nós RDF onde a sentença (seu identificador) termina com a cadeia "Smith".
			Selector selector = new SimpleSelector(null, VCARD.FN, (RDFNode) null) {
	      	public boolean selects(Statement s) { return s.getString().endsWith("Smith"); }

      };      

      // Leitura do arquivo RDF/XML, tratando excessão de não encontrado 
      InputStream in = FileManager.get().open(inputFileName);
      if (in == null) throw new IllegalArgumentException( "File: " + inputFileName + " not found");
      model.read( in, "");
      
      // Selecionando todas as sentenças que batem com o selector
      StmtIterator iter = model.listStatements(selector);
     
			if (iter.hasNext()){
          System.out.println("O banco de dados contém vcards para:");

          while (iter.hasNext())
              System.out.println("  " + iter.nextStatement().getString() );
          
          
      }else 
          System.out.println("Nenhum vcard encontrado");
                    
    }

}

