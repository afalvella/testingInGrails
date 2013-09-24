package com.meli

class MyService {

	def collaboratorService
	def calculatorService
	
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
	
	def getParity(Integer number) {
		try{
			calculatorService.getParity(number)
		}catch(Exception e){
			collaboratorService.handleException()
		}	
	}
}
