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
	
	
	
	
	//Deleting
	
		//complete projects
		@DELETE
		@Path("/") 
		@Consumes(MediaType.APPLICATION_XML) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String deleteFunders(String funderData) 
		{ 
			//Convert the input string to an XML document
			Document doc = Jsoup.parse(funderData, "", Parser.xmlParser()); 
		 
			//Read the value from the element <productID>
			String funderID = doc.select("funderID").text(); 
			String output = funderObj.deleteFunders(funderID); 
			return output; 
		}
	
		
		
		//Updating
		//Complete projects
		
		@PUT
		@Path("/") 
		@Consumes(MediaType.APPLICATION_JSON) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String updateFunders(String funderData) 
		{ 
			//Convert the input string to a JSON object 
			JsonObject funderObject = new JsonParser().parse(funderData).getAsJsonObject(); 
			
			//Read the values from the JSON object
			String funderID = funderObject.get("funderID").getAsString();
			String funderCode = funderObject.get("funderCode").getAsString(); 
			String funderName = funderObject.get("funderName").getAsString(); 
			String funderAddress = funderObject.get("funderAddress").getAsString(); 
			String funderTel = funderObject.get("funderTel").getAsString(); 
			String funderEmail = funderObject.get("funderEmail").getAsString();
			String funderGender = funderObject.get("funderGender").getAsString();
			String funderFund = funderObject.get("funderFund").getAsString();
			String funderTime = funderObject.get("funderTime").getAsString();
			String funderDes = funderObject.get("funderDes").getAsString();
			
			
			String output = funderObj.updateFunders(funderID,funderCode,funderName,funderAddress,funderTel,funderEmail,funderGender,funderFund,funderTime,funderDes); 
		
			return output; 
		}

}
