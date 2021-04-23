package com;

import model.Shipping;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*; 

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document;


@Path("/Shipment") 
public class ShippingService {
	
	Shipping shipObj = new Shipping();
	
	//read shipment details
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	public String readItems() 
	{ 
	 return shipObj.readShipmentDetails();
	} 
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertItem(
	 @FormParam("firstName") String firstName, 
	 @FormParam("lastName") String lastName, 
	 @FormParam("address") String address, 
	 @FormParam("city") String city,
	 @FormParam("country") String country, 
	 @FormParam("zipcode") String zipcode, 
	 @FormParam("phoneno") String phoneno) 
	{ 
		String output = shipObj.insertShipping(firstName, lastName, address, city, country, zipcode, phoneno); 
	 	return output; 
	}
	
	//update shipment details
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateShipment(String shipmentData) 
	{ 
		//Convert the input string to a JSON object 
		 JsonObject shipmentObj = new JsonParser().parse(shipmentData).getAsJsonObject(); 
		
		 //Read the values from the JSON object
		 String shipmentID = shipmentObj.get("shipmentID").getAsString(); 
		 String firstName = shipmentObj.get("firstName").getAsString(); 
		 String lastName = shipmentObj.get("lastName").getAsString(); 
		 String address = shipmentObj.get("address").getAsString(); 
		 String city = shipmentObj.get("city").getAsString(); 
		 String country = shipmentObj.get("country").getAsString(); 
		 String zipcode = shipmentObj.get("zipcode").getAsString(); 
		 String phoneno = shipmentObj.get("phoneno").getAsString();
		
		 String output = shipObj.updateShipment(shipmentID, firstName, lastName, address, city, country, zipcode, phoneno ); 
		
		 return output; 
	}
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteShipment(String shipmentData) 
	{ 
			//Convert the input string to an XML document
			 Document doc = Jsoup.parse(shipmentData, "", Parser.xmlParser()); 
			 
			//Read the value from the element <itemID>
			 String shipmentID = doc.select("shipmentID").text(); 
			 String output = shipObj.deleteShipment(shipmentID); 
			
			 return output; 
	}


	
	

}
