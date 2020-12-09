package parsingTech;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test1 
{

	public static void main(String[] args) 
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		Response res=RestAssured.given().get();
		
		//display the response came from the restful service
		String sl=res.getStatusLine();
		String[] x=sl.split(" ");
		System.out.println(sl);
		System.out.println(x[1]);
		String y=res.getContentType();
		System.out.println(y);

	}

}
