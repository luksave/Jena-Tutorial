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
}
