package StepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class AddPlacecode extends Utils {
	RequestSpecification re;
	ResponseSpecification	basicres;
	public Response test;
	static String placeid;
	TestDataBuild obj = new TestDataBuild();
@Given("^Add place payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
public void add_place_payload_with(String name, String lan, String address) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
 	//	RestAssured.baseURI="https://rahulshettyacademy.com";
		
	 re=	given().spec(requestSpecifcation()).body(obj.addplacepayload(name,lan,address)).when().log().all();
}
@When("^user calls\"([^\"]*)\" using \"([^\"]*)\" request$")
public void user_calls_using_request(String resource, String method) throws Throwable {
      
	APIResources resourceurl= APIResources.valueOf(resource);
	System.out.println(resourceurl.getresource());
	if(method.equalsIgnoreCase("POST")){
         test =	re.post(resourceurl.getresource()).then().extract().response();
	}
	else if(method.equalsIgnoreCase("Get")){
		 test =	re.get(resourceurl.getresource()).then().extract().response();
	}
    }
  
@Then("^Response should be have status code is (\\d+)$")
public void response_should_be_have_status_code_is(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	
	System.out.println(test.asString());
	assertEquals(200, test.getStatusCode());
}
 @And("^\"([^\"]*)\" in response body  is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String strArg1, String strArg2) throws Throwable {
	 
	 
       System.out.println(strArg1);
System.out.println(test.asString());
assertEquals((getjsonpath(test,strArg1)),strArg2);
    }
 
 @Then("^verify placeid created  matches to \"([^\"]*)\" using \"([^\"]*)\"$")
public void verify_placeid_created_matches_to_using(String arg1, String resource) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	 
 placeid=	 getjsonpath(test,"place_id");
	  re=	given().spec(requestSpecifcation()).queryParam("place_id", placeid);
	  user_calls_using_request(resource,"get");
	  String n=	 getjsonpath(test,"name");
	  System.out.println(n);
   assertEquals(arg1, n);
}

 @Given("^DeletePlace payload$")
public void deleteplace_payload() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  re = given().spec(requestSpecifcation()).body(obj.deleteplace(placeid)).log().all();
}
}
