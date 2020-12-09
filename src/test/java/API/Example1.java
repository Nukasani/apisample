package API;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Example1 
{
	public static void main(String[] args) 
	{
		//Create HTTP request
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		RequestSpecification req=RestAssured.given();
	
		//Send Request
		Response res=req.request(Method.GET);
		
		//analyze HTTP response in various representation
		String rsl=res.getStatusLine();
		System.out.println("Status line:\n"+rsl);
		System.out.println("Headers are:");
		
		List<Header> hs=res.getHeaders().asList();
		for(Header h:hs)
		{
			System.out.println(h.getName()+";"+h.getValue());
		}
		ResponseBody rbo=res.getBody();
		String rb=rbo.asString();
		System.out.println("response body is:\n"+rb);
		
	}

}
