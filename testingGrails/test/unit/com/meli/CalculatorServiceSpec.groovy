package com.meli

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll;

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(CalculatorService)
class CalculatorServiceSpec extends Specification {

	CalculatorService calculator = new CalculatorService()
	
	@Unroll("test if #number is #parity")
	void "test isEven"() {
		expect:
		calculator.getParity(number) == parity
		
		where:
		number	|	parity
		0		|	'Even'
		1		|	'Odd'
		2		|	'Even'
		
	}
}
