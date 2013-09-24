class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
		
		"/example/people"(controller:'Person', parseRequest:true) {
			action = [GET:'getPersonList']
		}
		
	}
}
