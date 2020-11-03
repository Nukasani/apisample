package API;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Example3  
{

	public static void main(String[] args) 
	{
		//one path parameter for request and response in html
		 //create Http request
		RestAssured.baseURI="https://www.lipsum.com/hindi";
		RequestSpecification req=RestAssured.given();
		 
		//request with http method and with one parameter
		Response res=req.request(Method.GET,"");
		
		//analyse response
		String rsl=res.getStatusLine();
		System.out.println("status line is:\n"+rsl);
		System.out.println("headers are");
		List<Header> hs=res.getHeaders().asList();
		for(Header h:hs)
		{
			System.out.println(h.getName()+":"+h.getValue());
		}
		String rb=res.getBody().asString();
		System.out.println("response body is:\n"+rb);
		
	}

}
