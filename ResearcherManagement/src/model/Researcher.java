package model;

import java.sql.*; 

public class Researcher {
	
	//A common method to connect to the DB
	private Connection connect() 
	 { 
			 Connection con = null; 
			 
			 try
			 { 
				 Class.forName("com.mysql.jdbc.Driver"); 
			 
				 //Provide the correct details: DBServer/DBName, username, password 
				 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Localhost", "root", ""); 
			 } 
			 catch (Exception e) 
			 {e.printStackTrace();} 
			 
			 return con; 
	 } 
	
	public String insertUser(String r_name, String r_surname, String r_email, String r_gender, String r_productType, String r_phoneNo) 
	 { 
			 String output = ""; 
			 try
			 { 
					 Connection con = connect(); 
					 
					 if (con == null) 
					 {return "Error while connecting to the database for inserting."; } 
	 
					 // create a prepared statement
					 String query = " insert into items (`userID`,`name`,`surname`,`email`,`gender`,'productType','phoneNo')"
							 		+ " values (?, ?, ?, ?, ?, ?, ?)"; 
					 
					 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
					 // binding values
					 preparedStmt.setInt(1, 0); 
					 preparedStmt.setString(2, r_name); 
					 preparedStmt.setString(3, r_surname); 
					 preparedStmt.setString(4, r_email); 
					 preparedStmt.setString(5, r_gender); 
					 preparedStmt.setString(6, r_productType);  
					 preparedStmt.setString(7, r_phoneNo); 
					 
					 
					// execute the statement3
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
	
	 public String readUsers() 
	 { 
		 
			 String output = ""; 
			 
			 try
			 { 
				 
				 	Connection con = connect(); 
				 	
					if (con == null) 
					{return "Error while connecting to the database for reading."; } 
	 
					// Prepare the html table to be displayed
					output = "<table border='1'><tr><th>User name</th><th>Users Surname</th>" +
							 "<th>E-mail address</th>" + 
							 "<th>Gender</th>" +
							 "<th>Product Type</th>" +
							 "<th>Phone Number</th>" +
							 "<th>Update</th><th>Remove</th></tr>"; 
	 
					 String query = "select * from items"; 
					 Statement stmt = con.createStatement(); 
					 ResultSet rs = stmt.executeQuery(query); 
					 
					 // iterate through the rows in the result set
					 while (rs.next()) 
					 { 
							 String r_userID = Integer.toString(rs.getInt("userID")); 
							 String r_name = rs.getString("name"); 
							 String r_surname = rs.getString("surname"); 
							 String r_email = rs.getString("email"); 
							 String r_gender = rs.getString("gender"); 
							 String r_productType = rs.getString("productType");  
							 String r_phoneNumber = rs.getString("phoneNo"); 
							 
							 // Add into the html table
							 output += "<tr><td>" + r_name + "</td>"; 
							 output += "<td>" + r_surname + "</td>"; 
							 output += "<td>" + r_email + "</td>"; 
							 output += "<td>" + r_gender + "</td>"; 
							 output += "<td>" + r_productType + "</td>"; 
							 output += "<td>" + r_phoneNumber + "</td>"; 
							 
							 // buttons
							 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
							 + "<td><form method='post' action='items.jsp'>"+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
							 + "<input name='itemID' type='hidden' value='" + r_userID 
							 + "'>" + "</form></td></tr>"; 
							 
					 } 
					 con.close(); 
					 
					 // Complete the html table
					 output += "</table>"; 
					 
			} 
			 catch (Exception e) 
			 { 
					 output = "Error while reading users"; 
					 System.err.println(e.getMessage()); 
			 } 
			 return output; 
	 }
	 
	 public String updateUsers(String id, String r_name, String r_surname, String r_email, String r_gender, String r_productType, String r_phoneNo)
	 { 
			 String output = ""; 
			 
			 try
			 {
				 
					 Connection con = connect(); 
					 
					 if (con == null) 
					 {return "Error while connecting to the database for updating."; } 
					 
					 // create a prepared statement
					 String query = "UPDATE items SET name=?,surname=?,email=?,gender=?,productType=?,phoneNo=? WHERE itemID=?"; 
					 
							 
					 PreparedStatement preparedStmt = con.prepareStatement(query); 
					 
					 // binding values
					 preparedStmt.setString(1, id);
					 preparedStmt.setString(2, r_name); 
					 preparedStmt.setString(3, r_surname); 
					 preparedStmt.setString(4, r_email); 
					 preparedStmt.setString(5, r_gender); 
					 preparedStmt.setString(6, r_productType);
					 preparedStmt.setString(7, r_phoneNo); 
					 
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
	public String deleteItem(String id) 
	 { 
			 String output = ""; 
			 
			 try
			 { 
					 Connection con = connect(); 
					 if (con == null) 
					 {return "Error while connecting to the database for deleting."; } 
					 
					 // create a prepared statement
					 String query = "delete from items where userID=?"; 
					 
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
	

