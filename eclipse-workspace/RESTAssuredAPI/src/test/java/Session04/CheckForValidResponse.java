package Session04;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class CheckForValidResponse {
	/*
//https://reqres.in/api/users/2
	@Test(enabled = false)
	public void GetSingleUser()
	
	{
		RestAssured.baseURI= "https://reqres.in/api/users/20";
		
		//get req specification of the req
		
		RequestSpecification reqSpec = RestAssured.given();
		
		//call get method
		
		Response response = reqSpec.get();
		
		//get response  code
		int statusCode = response.getStatusCode();
		
		//validate actual status code with expected
		
//		Assert.assertEquals(statusCode, 200, "Incorrect status code recieved");
		
		//checking error status code so https://reqres.in/api/users/20";
		
		//checking error status line
		
		String statusLine = response.getStatusLine();
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Incorrect status line recieved");
		
	}
	*/

	/*
	@Test(enabled = false)
	public void GetSingleUserUsingValidatableResponse()
	
	{
//		RestAssured.baseURI= "https://reqres.in/api/users/20";
		baseURI= "https://reqres.in/api/users/20";
		//get req specification of the req
		
		RequestSpecification reqSpec = RestAssured.given();
		
		//call get method
		
		Response response = reqSpec.get();
		
		ValidatableResponse validateRes = response.then();
		
		//status code
//		validateRes.statusCode(200);
//		System.out.println("second validation");
		validateRes.statusLine("HTTP/1.1 200 OK");
	}
	*/
	@Test
	public void GetSingleUser_BDDMethod()
	
	{
		.given()
		
		.when().get("https://reqres.in/api/users/2")
		
		.then().statusCode(200).statusLine("HTTP/1.1 200 OK");
	}
		

}
