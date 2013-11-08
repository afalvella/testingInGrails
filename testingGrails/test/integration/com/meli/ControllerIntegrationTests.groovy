package com.meli

import static org.junit.Assert.*

import org.junit.*

import static grails.test.MockUtils.*

class ControllerIntegrationTests extends GroovyTestCase{
	
	public void setUp(){
		def person = new Person(firstName:'Juan', lastName:'Perez')
		person.save(flush:true)
	}
	
	@Test
    void "test controller"() {
		PersonController controller = new PersonController()
		controller.getPersonList()
		def respuesta = controller.response 
		assertTrue respuesta.getStatus() == 200
		assertTrue respuesta.getContentType() == "application/json;charset=UTF-8"
		def contenido = respuesta.contentAsString
		assertTrue contenido == '[{"class":"com.meli.Person","id":1,"age":null,"firstName":"John","lastName":"Smith"},{"class":"com.meli.Person","id":2,"age":null,"firstName":"Juan","lastName":"Perez"}]'
	}
	
}
