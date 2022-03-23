package apiTests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class Test_API {
	
	
	@Test
	public void getRequest() {
		
		given().get("https://reqres.in/api/users?page=2").then().log().all();
		
	}
	
	@Test
	public void Post() {
		
		JSONObject requst = new JSONObject();
		requst.put("name", "Salam");
		requst.put("job", "IT");
		
		System.out.println(requst);
		
		given().body(requst.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201);
		
		
		
	}

}
