package com;

import model.CardDetails;
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
	
}
