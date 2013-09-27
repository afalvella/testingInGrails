import com.meli.Person

class BootStrap {

    def init = { servletContext ->
		
		def person = new Person(firstName:'John', lastName:'Smith')
		person.save(flush:true)
    }
	
    def destroy = {
    }
}
