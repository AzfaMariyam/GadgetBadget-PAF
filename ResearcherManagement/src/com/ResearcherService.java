package com;

import model.Researcher; 

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 

//For JSON
import com.google.gson.*; 

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

@Path("/Researchers") 
public class ResearcherService {
	
	
	Researcher researcherObj = new Researcher(); 
	
	//Reading Researcher details
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readUsers() 
	 { 
		return researcherObj.readUsers(); 
	 } 
	
	//Inserting Researcher details
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertUsers(@FormParam("name") String name, 
			 @FormParam("surname") String surname, 
			 @FormParam("email") String email,
			 @FormParam("gender") String gender,
			 @FormParam("productType") String productType,
			 @FormParam("productID") String productID,
			 @FormParam("phoneNo") String phoneNo
			 )
			  
	{ 
		String output = researcherObj.insertUsers(name, surname, email, gender, productType,productID,phoneNo); 
		return output; 
	}
	
	
	
	
	
	//Updating Researcher Details
	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateUsers(String researcherData) 
	{ 
		//Convert the input string to a JSON object 
		JsonObject researcherObject = new JsonParser().parse(researcherData).getAsJsonObject(); 
		
		//Read the values from the JSON object
		String userID = researcherObject.get("userID").getAsString(); 
		String name = researcherObject.get("name").getAsString(); 
		String surname = researcherObject.get("surname").getAsString(); 
		String email = researcherObject.get("email").getAsString(); 
		String gender = researcherObject.get("gender").getAsString();
		String productType = researcherObject.get("productType").getAsString();
		String productID = researcherObject.get("productID").getAsString();
		String phoneNo = researcherObject.get("phoneNo").getAsString();
		
		String output = researcherObj.updateUsers(userID, name, surname, email, gender, productType, productID, phoneNo); 
	
		return output; 
	}
	

	
	
	//Deleting Researcher Details
	

	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteUser(String researcherData) 
	{ 
		//Convert the input string to an XML document
		Document doc = Jsoup.parse(researcherData, "", Parser.xmlParser()); 
	 
		//Read the value from the element <userID>
		String userID = doc.select("userID").text(); 
		String output = researcherObj.deleteUsers(userID); 
		return output; 
	}
	
	

}
