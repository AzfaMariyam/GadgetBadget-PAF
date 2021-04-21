package model;

import java.sql.*;

public class funder {
	

	//A common method to connect to the DB
	private Connection connect() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget","root", "");
			
			//for testing
			System.out.println("Successfully connected");
		}
		catch(Exception e) {
			e.printStackTrace();

		}
		
		return con;
	}
	
	
	
	
	//READING
		
	//Reading the projects that are completed
	public String readFunders() {
		
		String output = "";
		
		try {
			
			Connection con = connect();
			
			if(con == null) {
				
				return "Error while connecting to the database for the reading";
				
			}
			//,funderName,funderAddress,funderTel,funderEmail,funderGender,funderFund,funderTime,funderDes
			//prepare the HTML table to be displayed
			output = "<table border='1'><tr><th>Funder Code</th>"
					+ "<th>Funder Name</th>"
					+ "<th>Funder Address</th>"
					+ "<th>Funder Tel</th>"
					+ "<th>Funder Email</th>"
					+ "<th>Funder Gender</th>"
					+ "<th>Funder Fund</th>"
					+ "<th>Funder Time</th>"
					+ "<th>Funder Description</th>"
					+ "<th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from funders";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			//iterate through the rows in the result set
			while(rs.next()) {
				
				String funderID = Integer.toString(rs.getInt("funderID"));
				String funderCode = rs.getString("funderCode");
				String funderName = rs.getString("funderName");
				String funderAddress = rs.getString("funderAddress");
				String funderTel = rs.getString("funderTel");
				String funderEmail = rs.getString("funderEmail");
				String funderGender = rs.getString("funderGender");
				String funderFund = Double.toString(rs.getDouble("funderFund"));
				String funderTime = rs.getString("funderTime");
				String funderDes = rs.getString("funderDes");
				
				
				//Add a row into the HTML table
				output += "<tr><td>" + funderCode + "</td>";
				output += "<td>" + funderName + "</td>";
				output += "<td>" + funderAddress + "</td>";
				output += "<td>" + funderTel + "</td>";
				output += "<td>" + funderEmail + "</td>";
				output += "<td>" + funderGender + "</td>";
				output += "<td>" + funderFund + "</td>";
				output += "<td>" + funderTime + "</td>";
				output += "<td>" + funderDes + "</td>";
				
				//buttons
				output += "<td><form method='post' action='funders.jsp'>"
						+ "<input name='btnUpdate' "
						+ " type='submit' value='Update'>"
						+ "<input name='funderID' type='hidden' "
						+ " value='" + funderID + "'>" + "</form></td>"
						
						+ "<td><form method='post' action='funders.jsp'>"
						+ "<input name='btnRemove'"
						+ " type='submit' value='Remove'>"
						+ "<input name='funderID' type='hidden' "
						+ " value='" + funderID + "'>" + "</form></td></tr>";
			}
			con.close();
			
			//Complete the HTML table
			output += "</table>";
		}
		catch(Exception e) {
			
			output = "Error while reading.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	
	
	
	
	

	
}
