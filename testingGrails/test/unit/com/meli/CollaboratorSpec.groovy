
package com.meli

import spock.lang.Specification;

class CollaboratorSpec extends Specification {

	CollaboratorService collaboratorService
	
	void setup() {
		collaboratorService = new CollaboratorService()
    }

    void "test do your magic" () {
        when: "call the method doYourMagic"
		def resultValueFromService = collaboratorService.doYourMagic()
		
		then: "the value must be 'Im a service collaborator'"
		def expectedValue = 'Im a service collaborator'
		expectedValue == resultValueFromService
    }
	
	void "test anotherMethod" () {
		expect:
		'This code rocks' == collaboratorService.anotherImportantMethod()
	}
}
