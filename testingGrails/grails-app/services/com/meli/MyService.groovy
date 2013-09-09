package com.meli

class MyService {

	CollaboratorService collaborator
	
    String numberToString(Integer intParam) {
		intParam?.toString()
    }
	
	def doComplexTask() {
		collaborator.doYourMagic()
	}
	
	def getJohnSmith() {
		Person.findByFirstNameAndLastName("John", "Smith")
	}
	
	def callingTwoMethodsOfACollaborator() {
		collaborator.doYourMagic()
		return collaborator.anotherImportantMethod()
	}
	
	def persistAPerson(String firstName, String lastName) {
		log.info "Persisting $firstName $lastName"
		
		def newPerson = new Person(firstName:'Steve', lastName:'Jobs')
		newPerson.save(flush:true)
		
	}
}
