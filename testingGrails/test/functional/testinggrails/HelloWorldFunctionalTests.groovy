package testinggrails

import com.grailsrocks.functionaltest.*

class HelloWorldFunctionalTests extends BrowserTestCase {
   
	 void testGetGoogle() {
		 get('http://www.google.com')
	 
		 assertStatus 200
		 assertContentContains "Google"
	 }
}
