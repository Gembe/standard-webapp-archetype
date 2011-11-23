#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * Copyright (C) 2011 ArtiVisi Intermedia <info@artivisi.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ${package}.ui.controller;

import org.junit.Test;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ApplicationConfigControllerTestIT {
	
	@Test
	public void testGetExistingConfigByName(){
		expect().
		statusCode(200).
		body(
				"id", equalTo("abc123"), 
				"name", equalTo("applicationname"), 
				"label", equalTo("Application Name"), 
				"value", equalTo("Belajar Restful")
		).
		when().get("http://localhost:10000/config/applicationname");
	}
	
	@Test
	public void testGetNonExistentConfigByName(){
		expect().
		statusCode(404).
		when().get("http://localhost:10000/config/nonexistentconfig");
	}
}
