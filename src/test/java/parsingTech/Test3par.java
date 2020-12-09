package parsingTech;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Test3par 
{
	public static <BurredWriter> void main(String[] args) throws Exception
	{
		RestAssured.baseURI="https://restcountries.eu/rest/v2/all";
		Response res=RestAssured.given().get();
		
		//Console is not able to Show the response 
		//Taking response into file 
		File f=new File("countries.txt");
		FileWriter fw=new FileWriter(f);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(res.getBody().asString());
		bw.close();
		fw.close(); 
		

	}

}
