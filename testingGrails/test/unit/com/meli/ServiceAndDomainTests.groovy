package com.meli

import static grails.test.MockUtils.*
import static org.junit.Assert.*
import grails.test.mixin.TestFor


@TestFor(MyService)
class ServiceAndDomainTests {

    Person smith
	Person rambo
	
	void setUp(){
		rambo = new Person(firstName:'John', lastName:'Rambo')
		smith = new Person(firstName:'John', lastName:'Smith')
		mockDomain(Person,[rambo, smith])
	}

    void "test getJohnSmith _ when calling MyService _ should return the correct mocked domain"() {
        assert smith == service.getJohnSmith()
    }
	
	void "test getting a Domain Class _ when using dynamic finders _ should return the correct mocked domain" () {
		Person result = Person.findByLastName('Rambo')
		assert result.getLastName() == 'Rambo'
	}
	
}
