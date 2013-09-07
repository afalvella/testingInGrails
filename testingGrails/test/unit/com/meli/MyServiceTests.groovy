package com.meli

import grails.test.mixin.*
import grails.test.mixin.support.GrailsUnitTestMixin;
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(MyService)
class MyServiceTests {

	void setUp() {
		//The testFor annotation give me a reference to the service called "service" so it's not necessary to instantiate it.
		//myService = new MyService()
    }
	
    void testNumberToString_whenZero_shouldReturnTheCorrectValue() {
        assert service.numberToString(0) == '0' 
    }
	
	void testNumberToString_whenNull_shouldReturnNull(){
		assertEquals(null, service.numberToString(null))
	}
	
	void testDoComplexTask_whenMockingCollaborator_shouldReturnWhatIMock() {
		String mockMsg = 'Im a mock collaborator'
		
		//Get a mock 'template' 
		def control = mockFor(CollaboratorService)
		//Set its behavior
		control.demand.doYourMagic(1..1) { -> return mockMsg }
		//Set the instance in the class under test
		service.collaborator = control.createMock()
		
		//Now I can test the class
		assertEquals(mockMsg, service.doComplexTask())
		
		//I can verify the call to the collaborator
		control.verify()	 
	}
}
