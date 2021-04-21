package model;

import java.sql.*;

public class Buyer {
	
	//A common method to connect to the DB
	private Connection connect() 
	 { 
	 Connection con = null; 
	 try
	 { 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 
	 //Provide the correct details: DBServer/DBName, username, password 
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", ""); 
	 } 
	 catch (Exception e) 
	 {e.printStackTrace();} 
	 return con; 
	 } 
	public String insertDetails(String name, String gender, String address, String contactno, String email) 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for inserting."; } 
	 // create a prepared statement
	 String query = " insert into items  (`BuyerID`,`Name`,`Gender`,`Address`,`ContactNo`,`Email`)"
	 + " values (?, ?, ?, ?, ?,?)"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setInt(1, 0); 
	 preparedStmt.setString(2, name); 
	 preparedStmt.setString(3, gender); 
	 preparedStmt.setString(4, address); 
	 preparedStmt.setString(5,contactno); 
	 preparedStmt.setString(6, email); 
	// execute the statement
	 
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Inserted successfully"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while inserting the item."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	public String readDetails() 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for reading."; } 
	 // Prepare the html table to be displayed
	 output = "<table border='1'><tr><th>ID</th><th>Name</th>" +
	 "<th>Gender</th>" +"<th>Address</th>"+
	 "<th>ContactNo</th>" +"<th>Email</th>"+
	 "<th>Update</th><th>Remove</th></tr>"; 
	 
	 String query = "select * from items"; 
	 Statement stmt = con.createStatement(); 
	 ResultSet rs = stmt.executeQuery(query); 
	 // iterate through the rows in the result set
	 while (rs.next()) 
	 { 
	 String buyerId = Integer.toString(rs.getInt("BuyerID")); 
	 String name = rs.getString("Name"); 
	 String gender = rs.getString("Gender"); 
	 String address = rs.getString("Address");
	 String contactno = rs.getString("ContactNo");
	 String email = rs.getString("Email"); 
	 
	 
	 // Add into the html table
	 
	 output += "<td>" + name + "</td>"; 
	 output += "<td>" + gender + "</td>"; 
	 output += "<td>" + address + "</td>"; 
	 output += "<td>" + contactno + "</td>";
	 output += "<td>" + email + "</td>";	 
	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
	 + "<td><form method='post' action='items.jsp'>"
	 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
	 + "<input name='BuyerId' type='hidden' value='" + buyerId
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
	public String updateDetails(String id, String name, String gender, String address, String contactno, String email)
	{
		String output = ""; 
		 try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 {return "Error while connecting to the database for updating."; } 
		 // create a prepared statement
		 String query = "UPDATE items SET Name=?,Gender=?,Address=?,ContactNo=?, Email=? WHERE BuyerID=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 // binding values
		 preparedStmt.setString(1, id); 
		 preparedStmt.setString(2, name); 
		 preparedStmt.setString(3, gender); 
		 preparedStmt.setString(4, address); 
		 preparedStmt.setString(5, contactno); 
		 preparedStmt.setString(6, email); 
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Updated successfully"; 
		 } 
		 catch (Exception e) 
		 { 
		 output = "Error while updating the item."; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 
		public String deleteDetails(String id) 
		 { 
		 String output = ""; 
		 try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 {return "Error while connecting to the database for deleting."; } 
		 // create a prepared statement
		 String query = "delete from items where BuyerID=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 // binding values
		 preparedStmt.setString(1, id);
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Deleted successfully"; 
		 } 
		 catch (Exception e) 
		 { 
		 output = "Error while deleting the item."; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 
	
	

}
