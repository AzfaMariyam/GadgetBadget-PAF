package model;

import java.sql.*;

public class Product {
	
	//Making a connection to the database
	public Connection connect() {
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/product" , "root" , "");
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	
	//INSERTING
	
	//Inserting completed projects to the System 
	
	public String insertProduct(String pcode , String pname , String pdesc , String price) {
		
		String output = "";
		
		try {
			
			Connection con = connect();
			
			if(con == null) {
				return "Error while connecting to the database for inserting";
			}
			
			//create a prepared statement
			String query = " insert into products(productID,productCode,projectName,projectDesc,price)" 
			+ " values(?,?,?,?,?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			//binding values
			preparedStmt.setInt(1,0);
			preparedStmt.setString(2,pcode);
			preparedStmt.setString(3,pname);
			preparedStmt.setString(4,pdesc);
			preparedStmt.setDouble(5,Double.parseDouble(price));
			
			
			
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

	
	
	//Inserting pending projects to the System 
	
		public String insertProject(String prcode , String prname , String prdesc , String fund) {
			
			String output = "";
			
			try {
				
				Connection con = connect();
				
				if(con == null) {
					return "Error while connecting to the database for inserting";
				}
				
				//create a prepared statement
				String query = " insert into projects(projectID,projectCode,projectName,projectDesc,fundAmount)" 
				+ " values(?,?,?,?,?)";
				
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				//binding values
				preparedStmt.setInt(1,0);
				preparedStmt.setString(2,prcode);
				preparedStmt.setString(3,prname);
				preparedStmt.setString(4,prdesc);
				preparedStmt.setDouble(5,Double.parseDouble(fund));
				
				
				
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

	
	
	
	
	//READING
		
	//Reading the projects that are completed
	public String readProducts() {
		
		String output = "";
		
		try {
			
			Connection con = connect();
			
			if(con == null) {
				
				return "Error while connecting to the database for the reading";
				
			}
			
			//prepare the HTML table to be displayed
			output = "<table border='1'><tr><th>Product Code</th>"
					+ "<th>Project Name</th>"
					+ "<th>Project Description</th>"
					+ "<th>Price</th>"
					+ "<th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from products";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			//iterate through the rows in the result set
			while(rs.next()) {
				
				String productID = Integer.toString(rs.getInt("productID"));
				String productCode = rs.getString("productCode");
				String projectName = rs.getString("projectName");
				String projectDesc = rs.getString("projectDesc");
				String price = Double.toString(rs.getDouble("price"));
				
				//Add a row into the HTML table
				output += "<tr><td>" + productCode + "</td>";
				output += "<td>" + projectName + "</td>";
				output += "<td>" + projectDesc + "</td>";
				output += "<td>" + price + "</td>";
				
				//buttons
				output += "<td><form method='post' action='products.jsp'>"
						+ "<input name='btnUpdate' "
						+ " type='submit' value='Update'>"
						+ "<input name='productID' type='hidden' "
						+ " value='" + productID + "'>" + "</form></td>"
						
						+ "<td><form method='post' action='products.jsp'>"
						+ "<input name='btnRemove'"
						+ " type='submit' value='Remove'>"
						+ "<input name='productID' type='hidden' "
						+ " value='" + productID + "'>" + "</form></td></tr>";
			}
			con.close();
			
			//Complete the HTML table
			output += "</table>";
		}
		catch(Exception e) {
			
			output = "Error while reading the products.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	
	
	
	
	//Reading the projects that are pending
		public String readProjects() {
			
			String output = "";
			
			try {
				
				Connection con = connect();
				
				if(con == null) {
					
					return "Error while connecting to the database for the reading";
					
				}
				
				//prepare the HTML table to be displayed
				output = "<table border='1'><tr><th>Project Code</th>"
						+ "<th>Project Name</th>"
						+ "<th>Project Description</th>"
						+ "<th>Fund Amount</th>"
						+ "<th>Update</th><th>Remove</th></tr>";
				
				String query = "select * from ptojects";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				//iterate through the rows in the result set
				while(rs.next()) {
					
					String projectID = Integer.toString(rs.getInt("projectID"));
					String projectCode = rs.getString("projectCode");
					String projectName = rs.getString("projectName");
					String projectDesc = rs.getString("projectDesc");
					String fundAmount = Double.toString(rs.getDouble("fundAmount"));
					
					//Add a row into the HTML table
					output += "<tr><td>" + projectCode + "</td>";
					output += "<td>" + projectName + "</td>";
					output += "<td>" + projectDesc + "</td>";
					output += "<td>" + fundAmount + "</td>";
					
					//buttons
					output += "<td><form method='post' action='projects.jsp'>"
							+ "<input name='btnUpdate' "
							+ " type='submit' value='Update'>"
							+ "<input name='projectID' type='hidden' "
							+ " value='" + projectID + "'>" + "</form></td>"
							
							+ "<td><form method='post' action='projects.jsp'>"
							+ "<input name='btnRemove'"
							+ " type='submit' value='Remove'>"
							+ "<input name='projectID' type='hidden' "
							+ " value='" + projectID + "'>" + "</form></td></tr>";
				}
				con.close();
				
				//Complete the HTML table
				output += "</table>";
			}
			catch(Exception e) {
				
				output = "Error while reading the products.";
				System.err.println(e.getMessage());
			}
			
			return output;
		}
	
	
	
	
	
		
	//DELETING	
	
	//Delete a Completed Project
	public String deleteProduct(String productID) 
	 { 
		String output = ""; 
		
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{return "Error while connecting to the database for deleting."; } 
	 
			// create a prepared statement
			String query = "delete from products where productID=?"; 
			
			PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(productID)); 
	 
			// execute the statement
			preparedStmt.execute(); 
			con.close(); 
	 
			output = "Deleted successfully"; 
		} 
		catch (Exception e) 
		{ 
			output = "Error while deleting"; 
			System.err.println(e.getMessage()); 
		} 
		
		return output; 
	 } 
	
	
	
	//Delete a Pending Project
		public String deleteProject(String projectID) 
		 { 
			String output = ""; 
			
			try
			{ 
				Connection con = connect(); 
				if (con == null) 
				{return "Error while connecting to the database for deleting."; } 
		 
				// create a prepared statement
				String query = "delete from projects where projectID=?"; 
				
				PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(projectID)); 
		 
				// execute the statement
				preparedStmt.execute(); 
				con.close(); 
		 
				output = "Deleted successfully"; 
			} 
			catch (Exception e) 
			{ 
				output = "Error while deleting"; 
				System.err.println(e.getMessage()); 
			} 
			
			return output; 
		 } 
	
	
	
		
		
		
	//UPDATING	
		
	//Updating completed project details
	public String updateProduct(String pID , String pcode , String pname , String pdesc , String price)
	{ 
		String output = ""; 
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{return "Error while connecting to the database for updating."; } 
	 
			// create a prepared statement
			String query = "UPDATE products SET productCode=?,projectName=?,projectDesc=?,price=?WHERE productID=?"; 
	
			PreparedStatement preparedStmt = con.prepareStatement(query); 
	
			// binding values
			preparedStmt.setString(1, pcode); 
			preparedStmt.setString(2, pname); 
			preparedStmt.setString(3, pdesc);
			preparedStmt.setDouble(4, Double.parseDouble(price)); 
			preparedStmt.setInt(5, Integer.parseInt(pID)); 
	 
			// execute the statement
			preparedStmt.execute(); 
			con.close(); 
	 
			output = "Updated successfully"; 
		} 
		catch (Exception e) 
		{ 
			output = "Error while updating"; 
			System.err.println(e.getMessage()); 
		} 
		
		return output; 
	 } 
	
	
	//Updating pending project details
		public String updateProject(String prID , String prcode , String prname , String prdesc , String fund)
		{ 
			String output = ""; 
			try
			{ 
				Connection con = connect(); 
				if (con == null) 
				{return "Error while connecting to the database for updating."; } 
		 
				// create a prepared statement
				String query = "UPDATE projects SET projectCode=?,projectName=?,projectDesc=?,fundAmount=?WHERE projectID=?"; 
		
				PreparedStatement preparedStmt = con.prepareStatement(query); 
		
				// binding values
				preparedStmt.setString(1, prcode); 
				preparedStmt.setString(2, prname); 
				preparedStmt.setString(3, prdesc);
				preparedStmt.setDouble(4, Double.parseDouble(fund)); 
				preparedStmt.setInt(5, Integer.parseInt(prID)); 
		 
				// execute the statement
				preparedStmt.execute(); 
				con.close(); 
		 
				output = "Updated successfully"; 
			} 
			catch (Exception e) 
			{ 
				output = "Error while updating"; 
				System.err.println(e.getMessage()); 
			} 
			
			return output; 
		 } 
	
	
}
