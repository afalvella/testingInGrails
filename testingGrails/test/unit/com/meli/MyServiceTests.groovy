package com.meli

import grails.test.mixin.*
import grails.test.mixin.support.GrailsUnitTestMixin;
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class MyServiceTests {

	MyService myService
	
    void setUp() {
        myService = new MyService()
    }
	
    void testNumberToString_whenZero_shouldReturnTheCorrectValue() {
        assert myService.numberToString(0) == '0' 
    }
	
	void testNumberToString_whenNull_shouldReturnNull(){
		assertEquals(null,myService.numberToString(null))
	}
}
