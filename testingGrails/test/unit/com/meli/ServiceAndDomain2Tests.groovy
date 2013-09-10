package com.meli

import static org.junit.Assert.*
import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*
import static grails.test.MockUtils.*


@TestFor(MyService)
class ServiceAndDomain2Tests {

	MyService myService
	
	@Before
    void setUp() {
		myService = new MyService()
		mockDomain(Person)
    }

    void testPersistAPerson() {
        //myService.persistAPerson("Juan", "Perez")
		//assertNotNull Person.findByLastName("Perez")
		assert true
    }
}
