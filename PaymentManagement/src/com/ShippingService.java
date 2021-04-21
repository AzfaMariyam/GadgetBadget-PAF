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
	
	

}
