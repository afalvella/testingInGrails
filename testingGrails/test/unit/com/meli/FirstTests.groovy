package com.meli

import static org.junit.Assert.*

import grails.test.GrailsMock
import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(MyService)
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
		
//		def mockControl = mockFor(Collections)
//		mockControl.demand.static.sort(1..1) { -> return ['a','c','b'] }
//		def mockInstance = mockControl.createMock()
//		assert mockInstance.sort(listToSort) == listToSort		
	}
}
