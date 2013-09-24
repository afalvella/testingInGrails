package com.meli

import spock.lang.Specification;

class MyServiceSpec extends Specification{
	
	MyService myService
	
	def setup() {
		myService = new MyService()
		//Mocking static methods
		GroovyMock(Person, global:true)
		Person.count() >> 4000
		Person.findByFirstNameAndLastName("John", "Smith") >> "finding John Smith"
	}
	
	def "test getJohnSmith _ when mocking static methods in the domain class _ should return what i've mocked"() {
		expect:
		"finding John Smith" == myService.getJohnSmith()
		Person.count() == 4000
	}
	
	def "test doComplexTask _ when mocking the collaborator _ should return what i've mocked" () {
		given: "a mock of the CollaboratorService"
		def mockCollaborator = Mock(CollaboratorService)
		myService.collaboratorService = mockCollaborator
		
		when:
		myService.doComplexTask()
		
		then:
		1 * mockCollaborator.doYourMagic()
	}
	
	def "test getParity _ when using stubs and mocks _ should return the expected value"() {
		given:
		def stubCalculator = Stub(CalculatorService)
		stubCalculator.getParity(_) >> { throw new Exception() } 
		def mockCollaborator = Mock(CollaboratorService)
		
		myService.calculatorService = stubCalculator
		myService.collaboratorService = mockCollaborator
		
		when:
		myService.getParity(10) 
		
		then:
		1 * mockCollaborator.handleException()
	}
}
