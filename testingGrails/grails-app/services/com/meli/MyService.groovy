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
}
