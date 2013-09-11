package com.meli

import grails.test.mixin.support.GrailsUnitTestMixin


@TestFor(MyService)
class MyServiceTests {
	
	void setUp() {
		//The testFor annotation give me a reference to the service called "service" so it's not necessary to instantiate it.
		//myService = new MyService()
    }
	
    void testNumberToString_whenZero_shouldReturnTheCorrectValue() {
        assert service.numberToString(0) == '0' 
    }
	
	void testNumberToString_whenNull_shouldReturnTheCorrectValue() {
		assert service.numberToString(null) == null
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
		service.collaboratorService = control.createMock()
		
		//Now I can test the class
		assertEquals(mockMsg, service.doComplexTask())
		
		//I can verify the call to the collaborator
		control.verify()	 
	}
	
	void "test the order of invocation _ when call a Collaborator _ should respect the order"() {
		String mockMsg = 'Im a mock collaborator'
		String anotherMsg = 'This code rules'
		
		def control = mockFor(CollaboratorService, false)  // --> setting strict expectations
		control.demand.doYourMagic(1..1) { -> return mockMsg }
		control.demand.anotherImportantMethod(1..1) { -> return anotherMsg }
		
		service.collaboratorService = control.createMock()

		//Now I should call one time each method an in order 
		assertEquals(anotherMsg, service.callingTwoMethodsOfACollaborator())
		
		//In the verify I check the order and the cardinality
		control.verify()
	}
	
	void "test mocking with AS operator _ when call the Collaborator _ should return expectedValue"() {
		def expectedValue = 'Im mocked with AS operator'
		def doYourMagicMock = { -> return expectedValue }
		def anotherMethodMock = { -> return 'another response' }
		
		def helper = [anotherImportantMethod:anotherMethodMock, doYourMagic:doYourMagicMock]
		def mockCollab = helper as CollaboratorService
		service.collaboratorService = mockCollab
		
		assert expectedValue == service.doComplexTask()
		assert 'another response' == mockCollab.anotherImportantMethod()
	}
}
