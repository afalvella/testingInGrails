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
	
	def persistAPerson(String firstName, String lastName, Integer age=0 ) {
		log.info "Persisting $firstName $lastName"
		
		Person newPerson = new Person(firstName:firstName, lastName:lastName, Age:age)
		def id = newPerson.save(validate:false)
		return id
	}
}
