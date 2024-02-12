package PracticeREST;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class DeleteTestMethod {

	@Test
	public void test05()

	{
		RestAssured.baseURI = "https://reqres.in/api/users/708";
		RestAssured.given().
		when().delete().then().
		statusCode(204).
		log().all();
	}

}
