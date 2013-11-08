package com.meli

import static org.junit.Assert.*
import static grails.test.MockUtils.*
import grails.test.mixin.TestFor
import grails.test.mixin.Mock

@TestFor(MyService)
@Mock([Person])
class ServiceAndDomainWithAnnotationTests {

	void setUp() {
        def persons = []
		persons << new Person(firstName:'Linus', lastName:'Torvalds') 
		persons << new Person(firstName:'Bill', lastName:'Gates')
		persons*.save()
    }

    void "test Mock Annotation _ when call a dynamic finder _ should return the mocked domain object"() {
		def lastNameOfBillGates = 'Gates'  
        assert lastNameOfBillGates == Person.findByFirstName('Bill').getLastName()
    }
	
	
	void "test persistPerson _ when call save a domain _ should save the domain object"() {
		mockLogging(MyService)
		
		service.persistAPerson('Steve', 'Jobs')
		def list = Person.list()
		assert 'Steve' == Person.findByLastName('Jobs').firstName
	}
	
}
