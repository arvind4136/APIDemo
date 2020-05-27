package StepDefinition;

import cucumber.api.java.Before;

public class Hooks {
	

	@Before("@Deleteplace")
	public void beforemethod() throws Throwable{
		//execute only if place id is null
		AddPlacecode obj = new AddPlacecode();
		
		if(AddPlacecode.placeid==null){
		obj.add_place_payload_with("rohit", "hinidi", "mumbai");
		obj.user_calls_using_request("AddPlaceAPI", "POST");
		obj.verify_placeid_created_matches_to_using("rohit", "getPlaceAPI");
		}
		
	}
}
