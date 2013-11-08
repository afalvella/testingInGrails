package com.meli

import static org.junit.Assert.*
import grails.test.GrailsMock
import static grails.test.MockUtils.*
import grails.test.mixin.support.GrailsUnitTestMixin
import grails.test.mixin.TestFor
import grails.test.mixin.Mock

@TestFor(MyService)
@Mock(Person)
class FirstTests {
	
    void testInvokingAServiceWithoutDeclaringIt() {
		//The testFor annotation give me a reference to the service called "service"
        assertEquals('123', service.numberToString(123)) 
    }
	
	void "test doComplexTask _ when mocking a Collaborator _ should return a mock message"() {
		def mockMsg = 'Im a mock created with GrailsMock'
		def mockControl = new GrailsMock(CollaboratorService)
		mockControl.demand.doYourMagic() { -> return mockMsg }
		service.collaboratorService = mockControl.createMock()
		
		assertEquals(mockMsg, service.doComplexTask())	
	}
		
}
