package model;

import java.sql.*; 

public class Researcher {
	
	//method to connect to the DB
	
	private Connection connect() 
	 { 
			 Connection con = null; 
			 
			 try
			 { 
				 Class.forName("com.mysql.jdbc.Driver");  
				 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/researcher", "root", ""); 
				 System.out.println("Successfully connected");
			 } 
			
	
			 catch (Exception e) 
			 {e.printStackTrace();} 
			 
			 return con; 
	 } 
	
	//inserting researcher details
	
	public String insertUsers(String r_name, String r_surname, String r_email, String r_gender, String r_productType, String r_productID, String r_phoneNo) 
	 { 
			 String output = ""; 
			 
			 try
			 { 
					 Connection con = connect(); 
					 
					 if (con == null) 
					 {return "Error while connecting to the database for inserting."; } 
	 
					 // create a prepared statement
					 String query = " insert into researcher(`userID`,`name`,`surname`,`email`,`gender`,`productType`,`productID`,`phoneNo`)"
							 		+ " values (?, ?, ?, ?, ?, ?, ?, ?)"; 
					 
					 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
					 // binding values
					 preparedStmt.setInt(1, 0); 
					 preparedStmt.setString(2, r_name); 
					 preparedStmt.setString(3, r_surname); 
					 preparedStmt.setString(4, r_email); 
					 preparedStmt.setString(5, r_gender); 
					 preparedStmt.setString(6, r_productType); 
					 preparedStmt.setInt(7, Integer.parseInt(r_productID));
					 preparedStmt.setInt(8, Integer.parseInt(r_phoneNo)); 
					 
					 
					// execute the statement3
					 preparedStmt.execute(); 
					 con.close(); 
					 
					 output = "Researcher details Inserted successfully"; 
			 } 
			 catch (Exception e) 
			 { 
					 output = "Error while inserting the researchers details"; 
					 System.err.println(e.getMessage()); 
			 } 
			 
			 return output; 
	 } 
	
	 //reading researcher details
	
	 public String readUsers() 
	 { 
		 
			 String output = ""; 
			 
			 try
			 { 
				 
				 	Connection con = connect(); 
				 	
					if (con == null) 
					{return "Error while connecting to the database for reading."; } 
	 
					// Prepare the html table to be displayed
					output = "<table border='1'><tr><th>User name</th>" +
							 "<th>Users Surname</th>" +
							 "<th>E-mail address</th>" + 
							 "<th>Gender</th>" +
							 "<th>Product Type</th>" +
							 "<th>Product ID</th>" +
							 "<th>Phone Number</th>" +
							 "<th>Update</th><th>Remove</th></tr>"; 
	 
					 String query = "select * from researcher"; 
					 Statement stmt = con.createStatement(); 
					 ResultSet rs = stmt.executeQuery(query); 
					 
					 // iterate through the rows in the result set
					 while (rs.next()) 
					 { 
							 String userID = Integer.toString(rs.getInt("userID")); 
							 String name = rs.getString("name"); 
							 String surname = rs.getString("surname"); 
							 String email = rs.getString("email"); 
							 String gender = rs.getString("gender"); 
							 String productType = rs.getString("productType"); 
							 String productID = rs.getString("productID");
							 String phoneNumber = rs.getString("phoneNo"); 
							 
							 // Add into the html table
							 output += "<tr><td>" + name + "</td>"; 
							 output += "<td>" + surname + "</td>"; 
							 output += "<td>" + email + "</td>"; 
							 output += "<td>" + gender + "</td>"; 
							 output += "<td>" + productType + "</td>"; 
							 output += "<td>" + productID + "</td>"; 
							 output += "<td>" + phoneNumber + "</td>"; 
							 
							 // buttons
							 output += "<td><form method='post' action='researcher.jsp'>"
									 + "<input name='btnUpdate' "
									 + " type='submit' value='Update'>"
									 + "<input name='userID' type='hidden' "
									 + " value='" + userID + "'>" + "</form></td>"
									 
									 
									 + "<td><form method='post' action='researcher.jsp'>"
									 + "<input name='btnRemove'"
									 + " type='submit' value='Remove'>"
									 + "<input name='userID' type='hidden' "
									 + " value='" + userID + "'>" + "</form></td></tr>";
									 
					 } 
					 con.close(); 
					 
					 // Complete the html table
					 output += "</table>"; 
					 
			} 
			 catch (Exception e) 
			 { 
					 output = "Error while reading researcher details"; 
					 System.err.println(e.getMessage()); 
			 } 
			 return output; 
	 }
	 
	 //updating researcher details
	 
	 
	 public String updateUsers(String id, String r_name, String r_surname, String r_email, String r_gender, String r_productType, String r_productID, String r_phoneNo)
	 { 
			 String output = ""; 
			 
			 try
			 {
				 
					 Connection con = connect(); 
					 
					 if (con == null) 
					 {return "Error while connecting to the database for updating."; } 
					 
					 
					 // create a prepared statement
					 String query = "UPDATE researcher SET name=?,surname=?,email=?,gender=?,productType=?,productID=?,phoneNo=? WHERE userID=?";
					 
					 
					 PreparedStatement preparedStmt = con.prepareStatement(query); 
					 
					 // binding values
					 preparedStmt.setString(1, r_name); 
					 preparedStmt.setString(2, r_surname); 
					 preparedStmt.setString(3, r_email); 
					 preparedStmt.setString(4, r_gender); 
					 preparedStmt.setString(5, r_productType);
					 preparedStmt.setInt(6, Integer.parseInt(r_productID));
					 preparedStmt.setInt(7, Integer.parseInt(r_phoneNo)); 
					 preparedStmt.setInt(8, Integer.parseInt(id));
					 
			
					 
					 // execute the statement
					 preparedStmt.execute(); 
					 con.close(); 
					 
					 output = "Updated researcher details successfully"; 
			 } 
			 catch (Exception e) 
			 { 
					output = "Error while updating the researcher details."; 
					System.err.println(e.getMessage()); 
			 } 
					 
			 return output; 
	 } 
	 
	//deleting researcher details
	 
	 
	public String deleteUsers(String userID) 
	 { 
			 String output = ""; 
			 
			 try
			 { 
					 Connection con = connect(); 
					 if (con == null) 
					 {return "Error while connecting to the database for deleting."; } 
					 
					 // create a prepared statement
					 String query = "delete from researcher where userID=?"; 
					 
					 PreparedStatement preparedStmt = con.prepareStatement(query); 
					 
					 // binding values
					 preparedStmt.setInt(1, Integer.parseInt(userID));  
					 
					 // execute the statement
					 preparedStmt.execute(); 
					 con.close(); 
					 
					 output = "Deleted researcher details successfully"; 
			 } 
			 catch (Exception e) 
			 { 
					 output = "Error while deleting."; 
					 System.err.println(e.getMessage()); 
			 } 
			 
			 return output; 
	 } 

} 
	

