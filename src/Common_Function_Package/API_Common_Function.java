package Common_Function_Package;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;

public class API_Common_Function {
	
public static int response_statusCode(String baseURL, String resource, String requestBody) {
		
		RestAssured.baseURI= baseURL;
		//Step 2 : Configure Request Body
		int statusCode = given().header("Content-Type","application/json").body(requestBody).
				when().post(resource).then().extract().statusCode();
		//System.out.println(statusCode);		
		return statusCode;
		}
	
	public static String response_Body(String baseURL, String resource, String requestBody) {
		
		RestAssured.baseURI= baseURL;
		//Step 2 : Configure Request Body
		
		String responseBody=given().header("Content-Type","application/json").body(requestBody).
				when().post(resource).then().extract().response().asString();
		//System.out.println(responseBody);
		return responseBody;
		}
}

