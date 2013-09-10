package com.meli

class CollaboratorService {

    def doYourMagic() {
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
}
