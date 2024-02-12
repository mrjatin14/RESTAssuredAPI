package PracticeREST;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PatchTestMethod {
	
	@Test
	public void test05()
	{
		//given , when, then
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Chotu");
		jsonData.put("job", "Tester");
		
		RestAssured.baseURI = "https://reqres.in/api/users/708";
		RestAssured.given().header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		body(jsonData.toJSONString()).
		when().patch().then().statusCode(200).
		log().all();
}
	
}
