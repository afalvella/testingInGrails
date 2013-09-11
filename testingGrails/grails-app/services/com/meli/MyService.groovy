package com.meli

class MyService {

	CollaboratorService collaborator
	
    String numberToString(Integer intParam) {
		intParam?.toString()
    }
	
	def doComplexTask() {
		log.info 'Do Complex Task'
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
		
		Person newPerson = new Person(firstName:firstName, lastName:lastName)
		def id = newPerson.save()
		return id
	}
}
