/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import java.io.InputStream;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

public class Tutorial01 {

	public static void main (String args[]) {

		//Busca todas as triplas da fonte de dados especificada, caso não seja especificado um grafo em específico
		String query = "Select ?s ?p ?o where {?s ?p ?o}";

		/*
		* querySPARQL - A string de consulta na linguagem SPARQL
		* usarResultSet - Imprimir resultados da consulta na forma tabular (true) ou em RDF/XML padrão (false)
		* file = Número relativo ao arquivo contendo dados RDF
		*/

		//Fonte de dados: 1 = vc-db-1.rdf (16 triplas)
		//Fonte de dados: 2 = vc-db-2.rdf (18 triplas)
		//Fonte de dados: 3 = vc-db-3.rdf (25 triplas)
		//Fonte de dados: 4 = vc-db-4.rdf (04 triplas)        

		queryModel(query, true, 1);

	}

	public static void queryModel(String querySPARQL, boolean usarResultSet, int file){

		String inputFileName = null;

		if     (file == 1)	inputFileName  = "vc-db-1.rdf";
		else if(file == 2)	inputFileName  = "vc-db-2.rdf";
		else if(file == 3)	inputFileName  = "vc-db-3.rdf";
		else if(file == 4)	inputFileName  = "vc-db-4.rdf";
		else								throw new IllegalArgumentException("Arquivo: " + inputFileName + " não encontrado!");


		// Criação de um MODELO RDF vazio
		Model model = ModelFactory.createDefaultModel();

		// Uso da classe Java FILEMANAGER para localizar o arquivo de entrada
		InputStream in = FileManager.get().open( inputFileName );
		if (in == null) throw new IllegalArgumentException("Arquivo: " + inputFileName + " nao encontrado");

		// Leitura do arquivo RDF de entrada na sintaxe padrão RDF/XML        
		model.read(in, "");

		// Criação de um objeto Query com a string de consulta na linguagem SPARQL
		Query query = QueryFactory.create(querySPARQL);

		// Interface para a execução de uma única consulta sobre o GRAFO do arquivo    	
		QueryExecution qe = QueryExecutionFactory.create(query, model);

		if(usarResultSet){
			// Executa a consulta definida na string SPARQL e armazena em um ResultSet
			ResultSet results = qe.execSelect();

			// Formatador dos resultados de uma consulta
			ResultSetFormatter.out(System.out, results, query);

		}else{
			// Escrita do MODELO RDF na sintaxe padrão W3C RDF/XML    		
			model.write(System.out);

		}

	}

}
