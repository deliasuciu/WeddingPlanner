package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserGateway {

	private static String addUserStatement = "insert into user (username, password, isAdmin) values (?, ?, ?)";
	private static String deleteUserStatement = "delete from user where username = ?";
	private static String updateUserStatement = "update user set password = ?, isAdmin = ? where username = ?";
	private static String allUsersStatement = "select * from user ";
	private static String searchUserStatement = "select * from user where username like ?";

	
	
	
	public void add(User user) {
		Connection c;
		try {
			c = Driver.getDBConnection();
			PreparedStatement statement = c.prepareStatement(addUserStatement);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setBoolean(3, user.isAdmin());
			statement.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
	
	public void delete(User u) {
		try{
		Connection c = Driver.getDBConnection();
		
		PreparedStatement statement = c.prepareStatement(deleteUserStatement);
		statement.setString(1, u.getUsername());
		statement.executeUpdate();
	
	}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void update(User user){
		try{
		Connection c = Driver.getDBConnection();
		
		PreparedStatement statement = c.prepareStatement(updateUserStatement);
		statement.setString(3, user.getUsername());
		statement.setString(1, user.getPassword());
		statement.setBoolean(2, user.isAdmin());
		statement.executeUpdate();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	public ArrayList<User> getAll(){
		ArrayList<User> list = new ArrayList<>();
		try{
		Statement myStmt = null;
		ResultSet myRes = null;
		Connection c = Driver.getDBConnection();
			
			myStmt = c.createStatement();
			myRes = myStmt.executeQuery(allUsersStatement);
			
			while(myRes.next()){
				User user = convertRow(myRes);
				list.add(user);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	public User searchByUsername(User us){
		User user = null;
		try{
			Connection c = Driver.getDBConnection();
			PreparedStatement statement = null;
			ResultSet rs = null;
			
			statement = c.prepareStatement(searchUserStatement);
			statement.setString(1, us.getUsername());
			
			rs = statement.executeQuery();
			
			if(rs != null && rs.next()){
				user = new User(us.getUsername(), rs.getString("password"), rs.getBoolean("isAdmin"));
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
	
public User login(String username,String password){
		
		UserGateway user = new UserGateway();
		User usernou = new User(username,password,false);
		User us = user.searchByUsername(usernou);
		if(us == null){
			return null;
		}
		String userPass = us.getPassword();
		if(userPass != null && userPass.equals(password)){
			return us;
		}
		return null;
	}

public User convertRow(ResultSet myResult) throws SQLException{

	String username = myResult.getString("username");
	String password  = myResult.getString("password");
	Boolean isAdmin  = myResult.getBoolean("isAdmin");
	
	User user = new User(username, password, isAdmin);
	

return user;	
}
}
