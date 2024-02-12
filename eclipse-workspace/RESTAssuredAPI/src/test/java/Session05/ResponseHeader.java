package Session05;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ResponseHeader {
	
//	https://reqres.in/api/users/2	
	
	@Test
	public void GetSingleUser()
	
	{
		RequestSpecification reqspec = RestAssured.given();
		
		reqspec.baseUri("https://reqres.in");
		reqspec.basePath("/api/users/2");
		
		
		//create get request
		Response  response = reqspec.get();
		
		//validate response header
		
		String contentType = response.getHeader("Content-Type");
		//System.out.println("Value of content-type :   "  + contentType);
		
		//read all the response header list  & print them	
	
		//>>>>get headers method will return list of collrction headers
		Headers  headersList = response.getHeaders();
		
		//iterate over header list
		for (Header header : headersList )
		{
			System.out.println( header.getName( ) + ":" + header.getValue());
		}
		
		//validate header contentType , expected value  : application/json; charset=utf-8
		
		Assert.assertEquals(contentType, "application/json; charset=utf-81" , "Header content type mismatch..");
		
	}

}
