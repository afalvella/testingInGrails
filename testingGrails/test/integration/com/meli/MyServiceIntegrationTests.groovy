package com.meli

import static org.junit.Assert.*
import org.junit.*
import static grails.test.MockUtils.*


class MyServiceIntegrationTests {
	
	MyService myService
	
	@Test
    void "test doComplexTask"() {
		def expectedValue = 'Im a service collaborator'
		assert expectedValue == myService.doComplexTask()
    }
}
