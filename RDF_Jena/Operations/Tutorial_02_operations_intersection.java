import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;

import java.io.*;

/** Tutorial 02 - Operações com grafos - Intersecção
 */
public class Tutorial_02_operations extends Object {
    
    static final String inputFileName1 = "vc-db-3.rdf";    
    static final String inputFileName2 = "vc-db-4.rdf";
    
    public static void main (String args[]) {

    // Criando dois modelos vazios
    Model model1 = ModelFactory.createDefaultModel();
    Model model2 = ModelFactory.createDefaultModel();
   
    // Leitura dos arquivos RDF/XML, tratando excessão de arquivo não encontrado
    InputStream in1 = FileManager.get().open(inputFileName1);
    InputStream in2 = FileManager.get().open(inputFileName2);
    
		if (in1 == null) throw new IllegalArgumentException( "File: " + inputFileName1 + " not found");
    if (in2 == null) throw new IllegalArgumentException( "File: " + inputFileName2 + " not found");

    model1.read( in1, "" );
    model2.read( in2, "" );
    
    // Intersecção dos modelos
     Model model = model1.intersection(model2);
    
    // Impressão do grafo resultado como RDF/XML
    model.write(System.out, "RDF/XML-ABBREV");
    System.out.println();
    
	}

}
