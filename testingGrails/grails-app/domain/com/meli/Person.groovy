package com.meli

class Person {

    String firstName
	String lastName
	Integer age
	
	static constraints = {
		firstName (nullable:true)
		lastName (nullable:true)
		age(nullable:true)
	}
}
