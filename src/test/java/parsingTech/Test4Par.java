package parsingTech;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test4Par 
{
	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://restCountries.eu/rest/v2/name/india";
		Response res=RestAssured.given().queryParam("fullText",true).get();
		JsonPath jp=res.andReturn().jsonPath();
		
		//get specified field
		String x=jp.getString("region");
		System.out.println(x);
		
		//get Array of values
		List<String> y=jp.getList("borders");
		System.out.println(y);
		
		//get values of multiple field
		List<String> z=jp.getList("languages.name");
		System.out.println(z);
		
		//get languages
		List<String> x1=jp.getList("languages");
		System.out.println(x1);
		
		
	}

}
