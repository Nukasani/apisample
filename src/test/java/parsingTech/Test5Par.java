package parsingTech;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test5Par 
{
	public static void main(String[] args) throws Exception
	{
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/employees";
		Response res=RestAssured.given().get();
		JsonPath jp=res.jsonPath();
		List<String> emname=jp.getList("data.employee_name");
		List<String> emsalary=jp.getList("data.employee_salary");
		
		//write response values into text file
		File f=new File("empResponse.txt");
		FileWriter fw=new FileWriter(f);
		BufferedWriter bw =new BufferedWriter(fw);
		
		for(int i=0;i<emname.size();i++)
		{
			bw.write(emname.get(i)+":"+emsalary.get(i));
			bw.newLine();
		}
		bw.close();
		fw.close();
	}

}
