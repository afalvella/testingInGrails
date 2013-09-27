package testinggrails

import com.grailsrocks.functionaltest.*

class MyFunctionalTests extends BrowserTestCase {
   
	 void testSearchApiWithParameters() {
		 get('https://api.mercadolibre.com/sites/MLA/search?q=ipod')
		 assertStatus 200
		 assertContentContains '"site_id": "MLA"'
		 assertContentContains '"query": "ipod"'
	 }
	 
	 void testGetGoogle() {
		 get('https://www.google.com.ar')
		 assertStatus 200
		 assertContentContains "Google"
	 }
	 
}
