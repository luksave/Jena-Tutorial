import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;

import java.io.*;

/** Tutorial 03 - Operações com grafos - Diferença
 */
public class Tutorial_03_operations extends Object {
    
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

		// Diferença dos modelos
		Model modelA = model1.difference(model2);
		Model modelB = model2.difference(model1);

		// Impressão dos grafos resultantes como RDF/XML
		modelA.write(System.out, "RDF/XML-ABBREV");
		System.out.println();
		modelB.write(System.out, "RDF/XML-ABBREV");
		System.out.println();

	}
}
