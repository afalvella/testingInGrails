package com.meli

class CollaboratorService {

    def doYourMagic() {
		log.info 'Do Your Magic'
		return 'Im a service collaborator'
    }
	
	def anotherImportantMethod() {
		return 'This code rocks'
	}
	
	def methodWithTooManyBranches(Integer number) {
		if(number < 0){
			return 'negative'
		}else{
			if(number == 0){
				return 'zero'	
			}else{
				return 'positive'
			}
		}
	}
	
	def handleException() {
		return 'handling exception'
	}
}
