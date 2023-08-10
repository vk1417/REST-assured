package Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo1 {

	public static void main(String[] args) {
		
	        // Set the base URL for the API
	        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

	        // Send a GET request to the "/posts/1" endpoint
	        Response response = RestAssured.get("/posts/1");

	        // Print the response status code
	        int statusCode = response.getStatusCode();
	        System.out.println("Status Code: " + statusCode);

	        // Print the response body
	        String responseBody = response.getBody().asString();
	        System.out.println("Response Body: " + responseBody);
	   
	}

}
