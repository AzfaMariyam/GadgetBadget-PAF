package com;

import model.CardDetails;


//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*; 

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document;


@Path("/CardDetails")
public class CardDetService {

	CardDetails cardD = new CardDetails();
	
	//read card details
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	public String readCardDetails() 
	{ 
	 return cardD.readCardDetails();
	}
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertCardDetails(
	 @FormParam("cardType") String cardType, 
	 @FormParam("cardNo") String cardNo, 
	 @FormParam("expMonth") String expMonth, 
	 @FormParam("expYear") String expYear,
	 @FormParam("securityCode") String securityCode)
	{ 
		String output = cardD.insertCardDetails(cardType, cardNo, expMonth, expYear, securityCode); 
	 	return output; 
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateCardDetails(String CardData) 
	{ 
		//Convert the input string to a JSON object 
		 JsonObject cardObj = new JsonParser().parse(CardData).getAsJsonObject(); 
		
		 //Read the values from the JSON object
		 String cardDetID = cardObj.get("cardDetID").getAsString(); 
		 String cardType = cardObj.get("cardType").getAsString(); 
		 String cardNo = cardObj.get("cardNo").getAsString(); 
		 String expMonth = cardObj.get("expMonth").getAsString(); 
		 String expYear = cardObj.get("expYear").getAsString(); 
		 String securityCode = cardObj.get("securityCode").getAsString(); 
		 String output = cardD.updateCardDetails(cardDetID,cardType,cardNo,expMonth,expYear,securityCode);
		 return output; 
	}
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteCardDetails(String CardData) 
	{ 
			//Convert the input string to an XML document
			 Document doc = Jsoup.parse(CardData, "", Parser.xmlParser()); 
			 
			//Read the value from the element <itemID>
			 String cardDetID = doc.select("cardDetID").text(); 
			 String output = cardD.deleteCardDetails(cardDetID); 
			
			 return output; 
	}
}
