package PracticeREST;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutTestMethod {
	
	@Test
	public void test04()
	{
		//given , when, then
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Raja");
		jsonData.put("job", "Teacher");
		
		RestAssured.baseURI = "https://reqres.in/api/users/708";
		RestAssured.given().header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		body(jsonData.toJSONString()).
		when().put().then().statusCode(200).
		log().all();
}
	
}
