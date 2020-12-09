package parsingTech;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test2par {

	public static void main(String[] args)
	{
        //Finding the type of response
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		Response res=RestAssured.given().get();
		
		//Display response
		
		String y=res.getStatusLine();
		System.out.println(y);
		String x=res.getContentType();
		System.out.println(x);
		if(x.contains("xml"))
		{
			System.out.println("Response type is xml");
		}
		else if(x.contains("json"))
		{
			System.out.println("response type is json");
		}
		else if(x.contains("html"))
		{
			System.out.println("response type in html");
		}
		else 
		{
			System.out.println("response is none of the above");
		}
	}

}
