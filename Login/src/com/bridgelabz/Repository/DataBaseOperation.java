package com.bridgelabz.Repository;

import java.sql.*;
import com.bridgelabz.Model.RegistrationModel;

public class DataBaseOperation 
{
      static Connection con=null;
      
	 static 
	 {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Registration","lokesh","lokesh");
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	 }
	 public static void insertToTable(Object obj) throws SQLException
	 {
		String query="insert into users values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, ((RegistrationModel)obj).getFirstName());
		ps.setString(2, ((RegistrationModel)obj).getLastName());
		ps.setString(3, ((RegistrationModel)obj).getPassword());
		ps.setString(4, ((RegistrationModel)obj).getGender());
		ps.setString(5, ((RegistrationModel)obj).getPhone());
		ps.setString(6, ((RegistrationModel)obj).getGmail());
		ps.executeUpdate();
	 }
	 public static ResultSet getDetails(String username,String password) throws SQLException
	 {
		String query="select * from users where FirstName=? and Password=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,username);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		return rs;
	 }
  
}
