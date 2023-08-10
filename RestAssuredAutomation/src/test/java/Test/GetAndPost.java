package Test;

import org.apache.commons.codec.binary.Base32;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*; 
public class GetAndPost {
	//@Test	
	public void testGet()
	{
		baseURI = "https://reqres.in/api";
		
		given().
		 get("/users?page=2").
		then().
		 statusCode(200). 
		 body("data[5].first_name", equalTo("Rachel")). 
		 body("data.first_name",hasItems("Rachel","George"));
	}
@Test	
public void testPost()
{
	JSONObject request = new JSONObject();
	request.put("name", "Vijay");
	request.put("job", "Tester");
	
	System.out.println(request.toJSONString());
	
	baseURI = "https://reqres.in/api";
	given().
	 header("Content-Type","application/json").
	 contentType(ContentType.JSON).
	 accept(ContentType.JSON).
	 body(request.toJSONString()).
	 when().
	  post("/users").
	 then(). 
	  statusCode(201). 
	  log().all();
}
}


