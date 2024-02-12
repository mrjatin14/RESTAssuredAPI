package Session08;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Authorization {
	
	
	@Test
	public void  BasicAuth()
	{
		RequestSpecification basicAuth = RestAssured.given();
		
		//specify URL
		basicAuth.baseUri("http://postman-echo.com");
		basicAuth.basePath("/basic-auth");
		
		
		//perform get request
		//Response response = basicAuth.auth().basic("postman", "password").get();
		
		//if i want to add Preemptive Basic preemptive Authorization
		
		Response response = basicAuth.auth().preemptive().basic("postman", "password").get();
		
		//print status line
		System.out.println("Response status : " +response.statusLine() );
		System.out.println("Response body : " +response.body().asString() );
	
	}
	
	
	@Test
	public void  DigestAuth()

	//https://httpbin.org/digest-auth/undefined/jatin/jatin

	{

		RequestSpecification digestAuth = RestAssured.given();

		//specify URL
		digestAuth.baseUri("https://httpbin.org/digest-auth");
		digestAuth.basePath("/undefined/jatin/jatin");

		//perform get request
		Response response = digestAuth.auth().digest("jatin", "jatin").get();

		Assert.assertEquals(response.statusCode(), 200);
		
		
		//print status line
		System.out.println("Response status : " +response.statusLine() );
		System.out.println("Response body : " +response.body().asString() );
		
	
	}

}
