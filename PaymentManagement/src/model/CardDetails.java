package model;

import java.sql.*; 

public class CardDetails {
	
	private Connection connect() 
	{ 
		Connection con = null; 
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver"); 
	 
			//Provide the correct details: DBServer/DBName, username, password 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paymentgb","root", ""); 
		} 
		catch (Exception e) 
			{e.printStackTrace();} 
		return con; 
	 }
	
	public String insertCardDetails(String cardType, String cardNo, String 	expMonth, String expYear, String securityCode) 
	{ 
		String output = ""; 
		try{
			Connection con = connect(); 
			if (con == null) 
			{
				return "Error while connecting to the database for inserting card details."; 
			} 
			
			// create a prepared statement
			String query = " insert into carddetails (`cardDetID`,`cardType`,`cardNo`,`expMonth`,`expYear`, `securityCode`)"
					+ " values (?, ?, ?, ?, ?, ?)"; 
			
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			// binding values
			 preparedStmt.setInt(1, 0); 
			 preparedStmt.setString(2, cardType); 
			 preparedStmt.setInt(3, Integer.parseInt(cardNo)); 
			 preparedStmt.setInt(4, Integer.parseInt(expMonth)); 
			 preparedStmt.setInt(5, Integer.parseInt(expYear)); 
			 preparedStmt.setInt(6, Integer.parseInt(securityCode));
			 
			 
			// execute the statement
			 preparedStmt.execute(); 
			
			 con.close(); 
			 	output = "Inserted successfully"; 
		 	
		}
		catch (Exception e) 
		{ 
			 output = "Error while inserting the card details."; 
			 System.err.println(e.getMessage()); 
		} 
		return output; 
	}
	
	
	
	public String readCardDetails() 
	{ 
		 String output = ""; 
		 try
		 { 
			 Connection con = connect(); 
			 if (con == null) 
			 {
				 return "Error while connecting to the database for reading card details.";  
			 }
			 
			 // Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>Card Type</th><th>Card Number</th>" +
			 "<th>Expiration Month</th>" + 
			 "<th>Expiration Year</th>" +
			 "<th>Security Code</th>" +
			 "<th>Update</th><th>Remove</th></tr>"; 
			 
			 String query = "select * from carddetails"; 
			 Statement stmt = con.createStatement(); 
			 ResultSet rs = stmt.executeQuery(query); 

			// iterate through the rows in the result set
			 while (rs.next()) 
			 { 
				 String cardDetID = Integer.toString(rs.getInt("cardDetID")); 
				 String cardType = rs.getString("cardType"); 
				 String cardNo = Integer.toString(rs.getInt("cardNo")); 
				 String expMonth = Integer.toString(rs.getInt("expMonth")); 
				 String expYear = Integer.toString(rs.getInt("expYear")); 
				 String securityCode = Integer.toString(rs.getInt("securityCode")); 
				 
				 // Add into the html table
				 output += "<tr><td>" + cardType + "</td>"; 
				 output += "<td>" + cardNo + "</td>"; 
				 output += "<td>" + expMonth + "</td>"; 
				 output += "<td>" + expYear + "</td>"; 
				 output += "<td>" + securityCode + "</td>";
				 
				 // buttons
				 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
				 + "<td><form method='post' action='items.jsp'>"
				 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
				 + "<input name='itemID' type='hidden' value='" + cardDetID 
				 + "'>" + "</form></td></tr>"; 
			 }
			 
			 con.close(); 
			 
			 // Complete the html table
			 output += "</table>"; 
			 
		 } 
		 catch (Exception e) 
		 { 
			 output = "Error while reading the card details."; 
			 System.err.println(e.getMessage()); 
		 } 
		 
		 return output; 
		 
	} 
	
	
	public String updateCardDetails(String cardDetID, String cardType, String cardNo, String expMonth, String expYear, String securityCode)
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
			 String query = "UPDATE carddetails SET cardType=?,cardNo=?,expMonth=?,expYear=?,securityCode=? WHERE cardDetID=?"; 
			 
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 
			 // binding values
			 preparedStmt.setString(1, cardType); 
			 preparedStmt.setInt(2, Integer.parseInt(cardNo)); 
			 preparedStmt.setInt(3, Integer.parseInt(expMonth)); 
			 preparedStmt.setInt(4, Integer.parseInt(expYear)); 
			 preparedStmt.setInt(5, Integer.parseInt(securityCode));
			 preparedStmt.setInt(6, Integer.parseInt(cardDetID));
			
			 // execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 output = "Updated card details successfully"; 
		 } 
		 catch (Exception e) 
		 { 
			 output = "Error while updating the card details."; 
			 System.err.println(e.getMessage()); 
		 } 
		 
		 return output; 
		 
	} 
	
	public String deleteCardDetails(String cardDetID) 
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
			 String query = "delete from carddetails where cardDetID=?"; 
			 
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(cardDetID)); 
			 
			 // execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 output = "Deleted card details successfully"; 
		 } 
		 catch (Exception e) 
		 { 
			 output = "Error while deleting the card details."; 
			 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 
	}
	

}
