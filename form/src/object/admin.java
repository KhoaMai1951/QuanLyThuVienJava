package object;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import bussiness.QLCSDL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class admin {
	public String Username;
	public String Password;
	 
	public void Admin() 
	{
	}
	 
	public void Admin(String Username, String Password) 
	{
	 this.Username = Username;
	 this.Password = Password;
	}
	 
	public String getUsername() 
	{
	 return Username;
	}
	
	public void setUsername(String Username) 
	{
	 this.Username = Username;
	}
	 
	public String getPassword() 
	{
	 return Password;
	}
	 
	public void setPassword(String Password) 
	{
	 this.Password = Password;
	 }

	public static admin timUser(String username, String password) throws SQLException, ClassNotFoundException
	{
	 admin admin = null;
	 
	 Connection conn = QLCSDL.connect();
	 java.sql.Statement statement = ((java.sql.Connection) conn).createStatement();
	 String sql = "SELECT * FROM quan_tri WHERE username like '" + username + "' and Password like '" + password + "'";
	 ResultSet resultSet = statement.executeQuery(sql);
	 while (resultSet.next()) 
	 {
	 admin = new admin();
	 admin.setUsername(resultSet.getString("username"));
	 admin.setUsername(resultSet.getString("password"));
	 break;
	 }
	 
	 return admin;
	}
}
