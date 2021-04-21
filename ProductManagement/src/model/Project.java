package model;

import java.sql.*;

public class Project {

	
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
						
					String query = "select * from projects";
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
