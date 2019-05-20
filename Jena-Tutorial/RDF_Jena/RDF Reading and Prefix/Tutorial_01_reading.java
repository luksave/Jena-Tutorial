import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;

import java.io.*;

/** Tutorial 1 - Leitura de RDF XML de um arquivo e escrita 
 */
public class Tutorial_01_reading extends Object {

    static final String inputFileName  = "vc-db-1.rdf";
                              
    public static void main (String args[]) {

        // Cria um modelo vazio a ser preenchido na leitura do arquivo
        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open( inputFileName );
        if (in == null)
            throw new IllegalArgumentException( "File: " + inputFileName + " not found");
        
        
        // Leitura do arquivo RDF/XML
        model.read(in, "");
                    
        // Escreve o modelo no padrão XML
        model.write(System.out);  

    }
}

