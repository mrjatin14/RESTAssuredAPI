package Session07;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class QueryParameterDemo {
	
//	https://reqres.in/api/users?page=2
	
	@Test
	public void filterData()
	
	{
		//get requestSpecification for the given request
		RequestSpecification responseBody = RestAssured.given();
		
		//specify url
		responseBody.baseUri("https://reqres.in");
		responseBody.basePath("api/users");
		responseBody.queryParam("page", 2).queryParam("id", 10);
		
		
		//perform get request
		Response response =responseBody.get();

		String res =response.asString();
		//print response body
		System.out.println("Response body :"  +res );
	}

}
