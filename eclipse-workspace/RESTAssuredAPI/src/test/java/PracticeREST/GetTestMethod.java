package PracticeREST;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetTestMethod {
	
//	https://reqres.in/api/users/2
	
	@Test
	public void test01()
	{
		Response res =RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(res.asString());
		System.out.println("Status Code:" + res.getStatusCode());
		System.out.println("Response Body:" + res.getBody().asString());
		System.out.println("Time:" + res.getTime());
		System.out.println("Response Header:" + res.getHeader("Content-Type"));
		
		//validate status code
		//expected status code = 200
		
//		int expectedStatusCode = 200;
		//intentionally fail
		int expectedStatusCode = 201;
		int actualStatusCode = res.getStatusCode();
		
		Assert.assertEquals(expectedStatusCode, actualStatusCode );
					
	}
	
	@Test
	public void test02()
	{
		//given , when, then
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given()
		.queryParam("page", 2)
		.when().get()
		.then().statusCode(200);
		
		
		
		
	}
	

}
