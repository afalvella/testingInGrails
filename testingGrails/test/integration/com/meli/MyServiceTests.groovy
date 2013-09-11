package com.meli

import static org.junit.Assert.*
import org.junit.*
import static grails.test.MockUtils.*

class MyServiceTests {
	
	MyService myService
	
	@Before
    void setUp() {
        myService = new MyService()
		//mockLogging(MyService)
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void "test doComplexTask"() {
		def expectedValue = 'Im a service collaborator'
		assert expectedValue == myService.doComplexTask()
    }
}
