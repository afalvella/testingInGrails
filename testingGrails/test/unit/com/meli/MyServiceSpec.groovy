package com.meli

import spock.lang.Specification;

class MyServiceSpec extends Specification{
	
	MyService myService
	
	def setup() {
		myService = new MyService()
		GroovyMock(Person, global:true)
		Person.count() >> 4000
		Person.findByFirstNameAndLastName("John", "Smith") >> "finding John Smith"
	}
	
	def "test get John Smith _ when mocking a static method in the domain class _ should return what i've mocked"() {
		expect:
		"finding John Smith" == myService.getJohnSmith()
		Person.count() == 4000
	}
	
	
}
