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
	public String viewFunders() 
	 { 
	 return funderObj.viewFunders();
	 } 
	
	
	
	//Inserting
	//completed projects
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertFunders(@FormParam("funderCode") String funderCode,
			 @FormParam("funderName") String funderName, 
			 @FormParam("funderAddress") String funderAddress, 
			 @FormParam("funderTel") String funderTel,
			 @FormParam("funderEmail") String funderEmail, 
			 @FormParam("funderGender") String funderGender,
			 @FormParam("funderFund") String funderFund, 
			 @FormParam("funderTime") String funderTime, 
			 @FormParam("funderDes") String funderDes)
			
			  
	{ 
		String output = funderObj.insertFunders(funderCode,funderName,funderAddress,funderTel,funderEmail,funderGender,funderFund,funderTime,funderDes); 
		return output; 
	}
	
	
	
	

}
