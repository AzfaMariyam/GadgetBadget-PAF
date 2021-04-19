package model;

import java.sql.*;

public class funder {
	

	//A common method to connect to the DB
	private Connection connect() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lab_3.1","root", "");
			
			//for testing
			System.out.println("Successfully connected");
		}
		catch(Exception e) {
			e.printStackTrace();

		}
		
		return con;
	}
	
	
	
	
	
	
	public String insertFunderDetails(String code , String name , String price , String desc) {
		
		String output = "";
		
		try {
			
			Connection con = connect();
			
			if(con == null) {
				return "Error while connecting to the database for inserting";
			}
			
			//create a prepared statement
			String query = " insert into items(itemID,itemCode,itemName,itemPrice,itemDesc)" 
			+ " values(?,?,?,?,?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			//binding values
			preparedStmt.setInt(1,0);
			preparedStmt.setString(2,code);
			preparedStmt.setString(3,name);
			preparedStmt.setDouble(4,Double.parseDouble(price));
			preparedStmt.setString(5,desc);
			
			//execute the statement
			preparedStmt.execute();
			con.close();
			
			output = "Inserted successfully";
		}
		catch(Exception e) {
			
			output = "Error while inserting";
			System.err.println(e.getMessage());
			
		}
		
		return output;
		
	}
	
	
	
	
	
	
	public String readFunderDetails() {
		
		String output = "";
		
		try {
			
			Connection con = connect();
			
			if(con == null) {
				
				return "Error while connecting to the database for the reading";
				
			}
			
			//prepare the html table to be displayed
			output = "<table border='1'><tr><th>Item Code</th>"
					+ "<th>Item Name</th><th>Item Price</th>"
					+ "<th>Item Description</th>"
					+ "<th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from items";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			//iterate through the rows in the result set
			while(rs.next()) {
				
				String itemID = Integer.toString(rs.getInt("itemID"));
				String itemCode = rs.getString("itemCode");
				String itemName = rs.getString("itemName");
				String itemPrice = Double.toString(rs.getDouble("itemPrice"));
				String itemDesc = rs.getString("itemDesc");
				
				//Add a row into the html table
				output += "<tr><td>" + itemCode + "</td>";
				output += "<td>" + itemName + "</td>";
				output += "<td>" + itemPrice + "</td>";
				output += "<td>" + itemDesc + "</td>";
				
				//buttons
				output += "<td><form method='post' action='items.jsp'>"
						+ "<input name='btnUpdate' "
						+ " type='submit' value='Update'>"
						+ "<input name='itemID' type='hidden' "
						+ " value='" + itemID + "'>" + "</form></td>"
						
						+ "<td><form method='post' action='items.jsp'>"
						+ "<input name='btnRemove'"
						+ " type='submit' value='Remove'>"
						+ "<input name='itemID' type='hidden' "
						+ " value='" + itemID + "'>" + "</form></td></tr>";
			}
			con.close();
			
			//Complete the html table
			output += "</table>";
		}
		catch(Exception e) {
			
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	
	
	
	
	
	
	
	
	public String updateFunderDetails(String ID, String code, String name, String price, String desc)
	 { 
		 String output = ""; 
		 try
		 { 
			 Connection con = connect();
			 
			 if (con == null) 
			 
			 {return "Error while connecting to the database for updating."; } 
		 
			 // create a prepared statement
			 String query = "UPDATE items SET itemCode=?,itemName=?,itemPrice=?,itemDesc=?"
			 		+ " WHERE itemID=?";
			 
			 	
			 		 		
			 
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 // binding values
			 
			 preparedStmt.setString(1, code); 
			 preparedStmt.setString(2, name); 
			 preparedStmt.setDouble(3, Double.parseDouble(price)); 
			 preparedStmt.setString(4, desc); 
			 preparedStmt.setInt(5, Integer.parseInt(ID)); 
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
	
	
	
	
	
	
	
	
	
	
	public String removeFunderDetails(String Id) {
		
		String output = "";
		
		try {
			
			Connection con = connect();
			
			if(con == null) {
				return "Error while connecting to the database for removing";
			}
			
			//create a prepared statement
			String query = " delete from items where itemID = " 
			+ " ? ";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			//binding values
			preparedStmt.setString(1,Id);
			
			
			//execute the statement
			preparedStmt.executeUpdate();
			con.close();
			
			output = "Removed successfully";
		}
		catch(Exception e) {
			
			output = "Error while removing";
			System.err.println(e.getMessage());
			
		}
		
		return output;
		
	}
	
	
	
	
	
	
	
	
	
	public String[] getFunderDetails(String id ) {
		
		String[] item = {"","","",""};
		
		try {
			
			Connection con = connect();
			
			if(con == null) {
				//return "Error while connecting to the database for updating";
			}
			
			//create a prepared statement
			String query = " select * from items where itemID = " + id;
			
			//PreparedStatement preparedStmt = con.prepareStatement(query);
			
			//binding values
			//preparedStmt.setString(1,id);
			Statement stmt = con.createStatement();
			
			
			//execute the statement
			ResultSet rs = stmt.executeQuery(query);
			
			
			
			while(rs.next()) {
				
			item[0] = rs.getString("itemCode");
			item[1] = rs.getString("itemName");
			item[2] = Double.toString(rs.getDouble("itemPrice"));
			item[3] = rs.getString("itemDesc");
			
			}
			
			con.close();
			
			
		}
		catch(Exception e) {
			
			//output = "Error while updating";
			System.err.println(e.getMessage());
			
		}
		
		return item;
		
	}
	
	
	
	
	

	
}
