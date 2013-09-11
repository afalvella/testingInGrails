package com.meli

class MyService {

	CollaboratorService collaboratorService
	
    String numberToString(Integer intParam) {
		intParam?.toString()
    }
	
	def doComplexTask() {
		log.info 'Do Complex Task'
		collaboratorService.doYourMagic()
	}
	
	def getJohnSmith() {
		Person.findByFirstNameAndLastName("John", "Smith")
	}
	
	def callingTwoMethodsOfACollaborator() {
		collaboratorService.doYourMagic()
		return collaboratorService.anotherImportantMethod()
	}
	
	def persistAPerson(String firstName, String lastName) {
		log.info "Persisting $firstName $lastName"
		
		Person newPerson = new Person(firstName:firstName, lastName:lastName)
		def id = newPerson.save()
		return id
	}
}
