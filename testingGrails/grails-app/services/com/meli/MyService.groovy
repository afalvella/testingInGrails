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
		return Person.findByFirstNameAndLastName("John", "Smith")
	}
}
