package com;

import model.Buyer; 


//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*; 
//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

//GET
@Path("/Buyers") 
public class BuyerService 
{ 
 Buyer buyerObj = new Buyer(); 
@GET
@Path("/") 
@Produces(MediaType.TEXT_HTML) 
public String readDetails() 
 { 
 return buyerObj.readDetails(); 
 }


//POST
@POST
@Path("/") 
@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
@Produces(MediaType.TEXT_PLAIN) 
public String insertDetails(
 @FormParam("Name") String name, 
 @FormParam("Gender") String gender, 
 @FormParam("Address") String address,
 @FormParam("ContactNo") String contactno,
 @FormParam("Email") String email) 
{ 
 String output = buyerObj.insertDetails(name,gender,address,contactno,email); 
return output; 
}




//PUT
@PUT
@Path("/") 
@Consumes(MediaType.APPLICATION_JSON) 
@Produces(MediaType.TEXT_PLAIN) 
public String updateDetails(String buyerdata) 
{ 
//Convert the input string to a JSON object 
 JsonObject buyerObject = new JsonParser().parse(buyerdata).getAsJsonObject(); 
//Read the values from the JSON object
 String id = buyerObject.get("id").getAsString(); 
 String name = buyerObject.get("name").getAsString(); 
 String gender = buyerObject.get("gender").getAsString(); 
 String address = buyerObject.get("address").getAsString(); 
 String contactno = buyerObject.get("contactno").getAsString(); 
 String email = buyerObject.get("email").getAsString(); 
 
 String output = buyerObj.updateDetails(id,name,gender,address,contactno,email); 
 return output; 
}




//DELETE
@DELETE
@Path("/") 
@Consumes(MediaType.APPLICATION_XML) 
@Produces(MediaType.TEXT_PLAIN) 
public String deleteDetails(String buyerData) 
{ 
//Convert the input string to an XML document
 Document doc = Jsoup.parse(buyerData, "", Parser.xmlParser()); 
 
//Read the value from the element <itemID>
 String buyerid = doc.select("id").text(); 
 String output = buyerObj.deleteDetails(buyerid); 
return output; 
}



}




