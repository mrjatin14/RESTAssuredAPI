package Session06;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class ResponseBodyJSON {
	
	
//	https://reqres.in/api/users?page=2
	@Test
	public void f()
	{
		//get requestSpecification refrence
		RequestSpecification responseBody = RestAssured.given();
		
		//specify baseURI
		
		responseBody.baseUri("https://reqres.in/");
		responseBody.basePath("api/users?page=2");
		
		//create get request
		Response response =responseBody.get();
		
		ResponseBody res =response.getBody();
		
		/*
		String responseString = res.asString();
		System.out.println("ResponseBody  : "  +responseString);
		
		//check for presense of George in response body
		Assert.assertEquals(responseString.contains("George"),true, "Check for presence of George");
		
		*/
		
		
		
		//get json path view of response body
		
		JsonPath jsonPathView = response.jsonPath();
		
		//x.data[0].first_name
		
		String firstName = jsonPathView.get("data[0].first_name");
		System.out.println("email address:"+jsonPathView.get("data[1].avatar") );
		Assert.assertEquals(firstName, "George", "Check for presence of George");
		
	}
	
	

}
