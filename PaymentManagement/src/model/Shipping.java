package model;

import java.sql.*; 

public class Shipping {
	
	//create database connection 
		private Connection connect() 
		{ 
			Connection con = null; 
			try
			{ 
				Class.forName("com.mysql.jdbc.Driver"); 
		 
				//connect to paymentgb database - DBServer/DBName, username, password 
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paymentgb","root", ""); 
			} 
			catch (Exception e) 
				{e.printStackTrace();} 
			return con; 
		 }
		
		//insert shipping details
		public String insertShipping(String firstName, String lastName, String address, String city, String country, String zipcode, String phoneno) 
		{ 
			String output = ""; 
			try{
				Connection con = connect(); 
				if (con == null) 
				{
					return "Error while connecting to the database for inserting."; 
				} 
				
				// create a prepared statement
				String query = " insert into shippingdetails (`shipmentID`,`firstName`,`lastName`,`address`,`city`,`country`, `zipcode`,`phoneno`)"
						+ " values (?, ?, ?, ?, ?, ?, ?, ?)"; 
				
				PreparedStatement preparedStmt = con.prepareStatement(query); 
				// binding values
				 preparedStmt.setInt(1, 0); 
				 preparedStmt.setString(2, firstName); 
				 preparedStmt.setString(3, lastName); 
				 preparedStmt.setString(4, address); 
				 preparedStmt.setString(5, city); 
				 preparedStmt.setString(6, country); 
				 preparedStmt.setInt(7, Integer.parseInt(zipcode)); 
				 preparedStmt.setInt(8, Integer.parseInt(phoneno));
			//	 preparedStmt.setDouble(4, Double.parseDouble(price)); 
				 
				 
				 
				// execute the statement
				 preparedStmt.execute(); 
				
				 con.close(); 
				 	output = "Inserted successfully"; 
			 	
			}
			catch (Exception e) 
			{ 
				 output = "Error while inserting the shipment details."; 
				 System.err.println(e.getMessage()); 
			} 
			return output; 
		}
		
		
		public String readShipmentDetails() 
		{ 
			 String output = ""; 
			 try
			 { 
				 Connection con = connect(); 
				 if (con == null) 
				 {
					 return "Error while connecting to the database for reading.";  
				 }
				 
				 // Prepare the html table to be displayed
				 output = "<table border='1'><tr><th>First Name</th><th>Last Name</th>" +
				 "<th>Address</th>" + 
				 "<th>City</th>" +
				 "<th>Country</th><th>Zip Code</th>" +
				 "<th>Phone number</th></tr>"; 
				 
				 String query = "select * from shippingdetails"; 
				 Statement stmt = con.createStatement(); 
				 ResultSet rs = stmt.executeQuery(query); 

				// iterate through the rows in the result set
				 while (rs.next()) 
				 { 
					 String shipmentID = Integer.toString(rs.getInt("shipmentID")); 
					 String firstName = rs.getString("firstName"); 
					 String lastName = rs.getString("lastName"); 
					 String address = rs.getString("address"); 
					 String city = rs.getString("city"); 
					 String country = rs.getString("country"); 
					 String zipcode = Integer.toString(rs.getInt("zipcode")); 
					 String phoneno = Integer.toString(rs.getInt("phoneno")); 
					 
					 
					 // Add into the html table
					 output += "<tr><td>" + firstName + "</td>"; 
					 output += "<td>" + lastName + "</td>"; 
					 output += "<td>" + address + "</td>"; 
					 output += "<td>" + city + "</td>"; 
					 output += "<td>" + country + "</td>"; 
					 output += "<td>" + zipcode + "</td>"; 
					 output += "<td>" + phoneno + "</td>";
					 
					 // buttons
					 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
					 + "<td><form method='post' action='shipmentdetails.jsp'>"
					 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
					 + "<input name='itemID' type='hidden' value='" + shipmentID  
					 + "'>" + "</form></td></tr>"; 
				 }
				 
				 con.close(); 
				 
				 // Complete the html table
				 output += "</table>"; 
				 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while reading the items."; 
				 System.err.println(e.getMessage()); 
			 } 
			 
			 return output; 
			 
		} 
		
		
		public String updateShipment(String shipmentID, String firstname, String lastname, String address, String city, String country, String zipcode, String phoneno)
		{ 
			 String output = ""; 
			 
			 try
			 { 
				 Connection con = connect(); 
				 
				 if (con == null) 
				 {
					 return "Error while connecting to the database for updating.";
				 } 
				 
				 // create a prepared statement
				 String query = "UPDATE shippingdetails SET firstname=?,lastname=?,address=?,city=?,country=?,zipcode=?,phoneno=? WHERE shipmentID =?"; 
				 
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 
				 // binding values
				 preparedStmt.setString(1, firstname); 
				 preparedStmt.setString(2, lastname); 
				 preparedStmt.setString(3, address); 
				 preparedStmt.setString(4, city); 
				 preparedStmt.setString(5, country); 
				 preparedStmt.setInt(6, Integer.parseInt(zipcode) );
				 preparedStmt.setInt(7, Integer.parseInt(phoneno));
				 preparedStmt.setInt(8, Integer.parseInt(shipmentID)); 
				
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 output = "Updated successfully"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while updating the shipment details."; 
				 System.err.println(e.getMessage()); 
			 } 
			 
			 return output; 
			 
		} 
		
		public String deleteShipment(String shipmentID) 
		{ 
			String output = ""; 
			 try
			 { 
				 Connection con = connect(); 
				 
				 if (con == null) 
				 {
					 return "Error while connecting to the database for deleting."; 
				 }
				 
				 // create a prepared statement
				 String query = "delete from shippingdetails where shipmentID=?"; 
				 
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 
				 // binding values
				 preparedStmt.setInt(1, Integer.parseInt(shipmentID)); 
				 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 output = "Deleted successfully"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while deleting the shipment details."; 
				 System.err.println(e.getMessage()); 
			 } 
			 return output; 
			 
		}
		
	

}
