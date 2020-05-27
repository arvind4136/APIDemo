package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
public static RequestSpecification Basicreq;
	
	public RequestSpecification requestSpecifcation() throws IOException{
		
		if(Basicreq==null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("login.txt"));
	//	RestAssured.baseURI="https://rahulshettyacademy.com";
		 Basicreq=	  new RequestSpecBuilder().setBaseUri(getglobalvalues("baseURL")).addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
		  .setContentType(ContentType.JSON).build();
		 
		 return Basicreq;
		}
		
		 return Basicreq;
	}
	
	public String getglobalvalues(String Key) throws IOException{
		
		Properties p = new Properties();
		FileInputStream fs = new FileInputStream("src//main/java//resources//config.properties");
		p.load(fs);
	String x=	p.getProperty(Key);
		return x;
	}
	
	public String getjsonpath(Response test,String key){
		
		String path = test.asString();
		System.out.println(path);
		JsonPath j = new JsonPath(path);
		String Value=j.getString(key);
		return Value;
	}
	
}
