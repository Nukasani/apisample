package API;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Example4 
{

	public static void main(String[] args) throws Exception 
	{
		// create http request
		RestAssured.baseURI="https://www.amazon.com/s";
		RequestSpecification req=RestAssured.given();
		
		//send http request with http method and query parameter
		Response res=req.queryParam("k","Corona beer").queryParam("beer&ref","nb_sb_noss").get("");
		
		//analyze http response
		String rsl=res.getStatusLine();
		System.out.println(rsl);
		List<Header> hs=res.getHeaders().asList();
		for(Header h:hs)
		{
			System.out.println(h.getName()+""+h.getValue());
		}
		String rb=res.getBody().asString();
		String hv=res.getHeader("Content-Type");
		File f;
		if(hv.contains("json"))
		{
			f=new File("E://amazoncoronabeer.json");
		}
		else if(hv.contains("xml"))
		{
			f=new File("E://amazoncoronabeer.xml");
		}
		else if(hv.contains("html"))
		{
			f=new File("E://amazoncoronabeer.html");
		}
		else if(hv.contains("csv"))
		{
			f=new File("E://amazoncoronabeer.csv");
		}
		else 
		{
			f=new File("E://amazoncoronabeer.txt");
		}
		FileWriter w=new FileWriter(f);
		w.write(rb);
		w.close();
		

	}

}
