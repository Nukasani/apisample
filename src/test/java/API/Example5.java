package API;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Example5  
{

	public static void main(String[] args) 
	{
		//create http request
		RestAssured.baseURI="http://restapi.demoqa.com/customer/register";
		RequestSpecification req=RestAssured.given();
		
		//pack parameters with values  and then attach to request body
		JSONObject jo=new JSONObject();
		jo.put("firstname","nukasani");
		jo.put("lastname","sriharsha");
		jo.put("username", "harsha");
		jo.put("password","hamara");
		jo.put("emai","sundaram123@gmail.com");//should be unique every time
		req.body(jo.toString());
		
		//send request with http method
		Response res=req.request(Method.POST,"");
		int sc=res.getStatusCode();
		System.out.println("status code received is:"+sc);
		System.out.println("response body:"+res.body().asString());

	}

}
