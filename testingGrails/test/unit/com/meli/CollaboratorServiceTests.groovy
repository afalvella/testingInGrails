package com.meli

import grails.test.mixin.*
import org.junit.*


@TestFor(CollaboratorService)
class CollaboratorServiceTests {
	
	CollaboratorService instance
	
	void setUp(){
		instance = new CollaboratorService()
	}

    void "test methodWithTooManyBranches _ when param is zero _ should return zero as string "() {
        String zeroAsString = 'zero'
		assert zeroAsString == instance.methodWithTooManyBranches(0)
    }
	
	void "test doYourMagic _ when is called _ should return a string "() {
		String expectedValue = 'Im a service collaborator'
		assert expectedValue == instance.doYourMagic()
	}
}
