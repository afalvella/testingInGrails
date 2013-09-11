
package com.meli

import spock.lang.Specification;

class CollaboratorSpec extends Specification {

	CollaboratorService collaborator
	
	void setup() {
		collaborator = new CollaboratorService()
    }

    void "test do your magic" () {
        when: "call the method doYourMagic"
		def value = collaborator.doYourMagic()
		
		then: "the value must be 'Im a service collaborator'"
		def expectedValue = 'Im a service collaborator'
		expectedValue == value
    }
	
	void "test anotherMethod" () {
		expect:
		'This code rocks' == collaborator.anotherImportantMethod()
	}
}
