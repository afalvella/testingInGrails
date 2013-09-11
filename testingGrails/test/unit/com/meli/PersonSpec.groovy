package com.meli

import grails.test.mixin.*
import org.junit.*

import spock.lang.Specification;

class PersonSpec extends Specification {

    def "test static mocking on a Domain Class"() {
		setup:
		GroovyMock(Person, global:true)
		Person.count() >> 4000
		
		expect: 
		Person.count() == 4000
    }
}
