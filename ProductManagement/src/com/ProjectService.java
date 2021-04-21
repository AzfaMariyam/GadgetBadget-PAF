package com;

import model.Product;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 

//For JSON
import com.google.gson.*; 

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

@Path("/Projects")

public class ProjectService {

	Product projectObj = new Product(); 
	
	
	
	
	//Reading
	//pending projects
	
		@GET
		@Path("/") 
		@Produces(MediaType.TEXT_HTML) 
		public String readProjects() 
		 { 
		 return projectObj.readProjects();
		 } 
		
		
	//Inserting
	//pending projects
		@POST
		@Path("/") 
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String insertProject(@FormParam("projectCode") String projectCode, 
				 @FormParam("projectName") String projectName, 
				 @FormParam("projectDesc") String projectDesc,
				 @FormParam("fundAmount") String fundAmount)
				  
		{ 
			String output = projectObj.insertProject(projectCode, projectName, projectDesc, fundAmount); 
			return output; 
		}
		
		
	//Updating

	//pending projects
		@PUT
		@Path("/Projects") 
		@Consumes(MediaType.APPLICATION_JSON) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String updateProject(String projectData) 
		{ 
			//Convert the input string to a JSON object 
			JsonObject projectObject = new JsonParser().parse(projectData).getAsJsonObject(); 
			
			//Read the values from the JSON object
			String projectID = projectObject.get("projectID").getAsString(); 
			String projectCode = projectObject.get("projectCode").getAsString(); 
			String projectName = projectObject.get("projectName").getAsString(); 
			String projectDesc = projectObject.get("projectDesc").getAsString(); 
			String fundAmount = projectObject.get("fundAmount").getAsString(); 
			
			String output = projectObj.updateProduct(projectID, projectCode, projectName, projectDesc, fundAmount); 
		
			return output; 
		}
		
		
	
	//Deleting
	
	//pending projects
		@DELETE
		@Path("/Projects") 
		@Consumes(MediaType.APPLICATION_XML) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String deleteProject(String projectData) 
		{ 
			//Convert the input string to an XML document
			Document doc1 = Jsoup.parse(projectData, "", Parser.xmlParser()); 
		 
			//Read the value from the element <productID>
			String projectID = doc1.select("projectID").text(); 
			String output = projectObj.deleteProduct(projectID); 
			return output; 
		}
	
}
