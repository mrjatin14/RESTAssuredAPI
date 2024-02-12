package Session08;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class APIKey {
	
	@Test
	public void apiKey()
	
	{
		//get requestSpecification for the given request
		RequestSpecification requestSpec = RestAssured.given();
	
		
		requestSpec.baseUri("https://api.openweathermap.org");
		requestSpec.basePath("/data/2.5/weather");
		requestSpec.queryParam("q", "Mandla").
		queryParam("appid","ac963935263358c785f63fbd2290cf44");
		
		Response response=requestSpec.get();
		
		
		//validate status code
		Assert.assertEquals(response.statusCode(), 200);
		
		//print status line & body
		System.out.println("Response status line : " + response.statusLine());
		System.out.println("Response body : " + response.body().asString());
		
	}

}
