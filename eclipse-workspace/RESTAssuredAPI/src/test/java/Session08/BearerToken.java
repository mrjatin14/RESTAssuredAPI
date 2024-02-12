package Session08;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerToken {
	
	@Test
	public void bearerTokenDemo()
	
	{
		//get requestSpecification for the given request
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify url
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");
		
		/*
		 * {
		 "name":"Jatin",
		 "gender": "male";
		 "email":jatin14@gmail.com",
		 "status":"Active"
			 
	}
		 
	*/	
	
		JSONObject payload = new JSONObject();
		payload.put( "name","Jatin123456789");
		payload.put( "gender","male");
		payload.put( "email","jatin1456789@gmail.com");
		payload.put( "status","Active");
		
		String authToken = "f2162399c428920935f846536826ee808b33711c22e5c23d8ab46ea536e5a098";
		
		requestSpec.header("Authorization", authToken).
		contentType(ContentType.JSON).
		body(payload.toJSONString());
		
		
		//perform post request
		Response response =requestSpec.post();
		
	
		//print response body
		System.out.println("Response body :"  +response.body().asString());
		

		
	
		
	}

}
