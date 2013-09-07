package com.meli

import static org.junit.Assert.*
import grails.test.GrailsMock
import grails.test.mixin.support.*
import static grails.test.MockUtils.*

@TestFor(MyService)
@Mock(Person)
class FirstTests {
	
    void testInvokingAServiceWithoutDeclaringIt() {
		//The testFor annotation give me a reference to the service called "service"
        assertEquals('123', service.numberToString(123)) 
    }
	
	void testDoComplexTask_whenMockingCollaborator_shouldReturnWhatIMock() {
		def mockMsg = 'Im a mock created with GrailsMock'
		def mockControl = new GrailsMock(CollaboratorService)
		mockControl.demand.doYourMagic() { -> return mockMsg }
		service.collaborator = mockControl.createMock()
		
		assertEquals(mockMsg, service.doComplexTask())	
	}
		
	void testUsingStaticMethods_whenCallCollectionsSort_shouldReturnWhatWeMocked() {
		List listResult = ['a','b','c']
		List listToSort = ['b','c','a']
		Collections.sort(listToSort)
		assertEquals listResult, listToSort			
	}
	
}
