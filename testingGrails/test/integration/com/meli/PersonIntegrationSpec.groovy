package com.meli

import org.codehaus.groovy.grails.web.json.JSONObject;

import grails.converters.JSON;
import grails.plugin.spock.IntegrationSpec

class PersonIntegrationSpec extends IntegrationSpec {

	def setup() {
		Person aPerson = new Person(firstName:'Juan', lastName:'Perez', age:30)
		aPerson.save()
	}

	def cleanup() {
	}

	void "test dynamic finder _ when I set up some test data _ should return the corresponding domain object"() {
		expect: 
		Person.findByFirstName('Juan') != null
	}
	
	void "test controller"() {
		given: 
		PersonController controller = new PersonController()
		
		when:
		controller.getPersonList()
		
		then:
		def respuesta = controller.response
		respuesta.getStatus() == 200
		respuesta.getContentType() == "application/json;charset=UTF-8"
		String contenido = respuesta.contentAsString
		def json = JSON.parse(contenido)
		json[0].lastName == 'Smith'
		json[1].lastName == 'Perez'
	}
	
}