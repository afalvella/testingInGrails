package com.meli

class PersonController {

	PersonService personService
	
    def getPersonList = {
		render(contentType:"text/json") {
			personService.getPersonList()
		}
	}
}
