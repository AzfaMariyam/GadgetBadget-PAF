package com;



import model.funder;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 

//For JSON
import com.google.gson.*; 

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

@Path("/Funders")


public class funderService {
	
	
	
	funder funderObj = new funder(); 
	
	
	//Reading
	//completed projects
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readFunders() 
	 { 
	 return funderObj.readFunders();
	 } 
	

}
