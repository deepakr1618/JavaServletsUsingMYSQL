package database;

import java.sql.*;

public class connectDB {
	Connection con;
	public connectDB() throws Exception {
		String pass = "pYmq9h5vmY";
		Class.forName("com.mysql.jdbc.Driver");
		this.con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/1iNMJ6j1QB","1iNMJ6j1QB" , pass);
		System.out.println("Connected to DB");
	}
	public String getFullName(String username , String password) throws Exception {
		String pass="";
		PreparedStatement ps = this.con.prepareStatement("select fullname , password from users where username = ?");
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			if(password.equals(rs.getString(2))) {
				return rs.getString(1);
			}
		}
		return pass;
	}
	
}
