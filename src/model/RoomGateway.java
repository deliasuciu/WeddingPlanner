package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RoomGateway {

	private static String addRoomStatement = "insert into room (idroom, nume,nrLoc,pret, disponibilitate) values (?, ?, ?,?,?)";
	private static String deleteRoomStatement = "delete from room where idroom = ?";
	private static String updateRoomStatement = "update room set nume = ?, nrLoc = ?, pret = ?, disponibilitate =? where idroom = ?";
	private static String allRoomsStatement = "select * from room ";
	private static String searchRoomStatement = "select * from room where idroom like ?";
	private static String reserveBandStatement = "update room set disponibilitate = ? where idroom like ?";
	private static String findIdStatement = "select * from room where idroom = ?";
	
	
	public void add(Room room) {
		Connection c;
		try {
			c = Driver.getDBConnection();
			PreparedStatement statement = c.prepareStatement(addRoomStatement);
			statement.setInt(1, room.getIdRoom());
			statement.setString(2, room.getNume());
			statement.setInt(3, room.getNrLoc());
			statement.setFloat(4,room.getPret());
			statement.setBoolean(5, room.isDisponibil());
			statement.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
	
	public void delete(Room r) {
		try{
		Connection c = Driver.getDBConnection();
		
		PreparedStatement statement = c.prepareStatement(deleteRoomStatement);
		statement.setInt(1, r.getIdRoom());
		statement.executeUpdate();
	
	}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void update(Room room){
		try{
		Connection c = Driver.getDBConnection();
		
		PreparedStatement statement = c.prepareStatement(updateRoomStatement);
		statement.setInt(5, room.getIdRoom());
		statement.setString(1, room.getNume());
		statement.setInt(2, room.getNrLoc());
		statement.setFloat(3, room.getPret());
		statement.setBoolean(4, room.isDisponibil());
		statement.executeUpdate();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	public ArrayList<Room> getAll(){
		ArrayList<Room> list = new ArrayList<>();
		try{
		Statement myStmt = null;
		ResultSet myRes = null;
		Connection c = Driver.getDBConnection();
			
			myStmt = c.createStatement();
			myRes = myStmt.executeQuery(allRoomsStatement);
			
			while(myRes.next()){
				Room room = convertRow(myRes);
				list.add(room);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Room searchByID(Room room){
		Room r = null;
		try{
			Connection c = Driver.getDBConnection();
			PreparedStatement statement = null;
			ResultSet rs = null;
			
			statement = c.prepareStatement(searchRoomStatement);
			statement.setInt(1, room.getIdRoom());
			
			rs = statement.executeQuery();
			
			if(rs != null && rs.next()){
				r = new Room(room.getIdRoom(), rs.getString("nume"), rs.getInt("nrLoc"),rs.getFloat("pret"),rs.getBoolean("disponibilitate"));
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return r;
	}
	
	public void reserve(Room room){
		try{
		Connection c = Driver.getDBConnection();
		
		PreparedStatement statement = c.prepareStatement(reserveBandStatement);
		statement.setInt(2, room.getIdRoom());
		statement.setBoolean(1, room.isDisponibil());
		statement.executeUpdate();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	

public Room searchID(int id){
	Room room = null;
	try{
	Connection c = Driver.getDBConnection();
	PreparedStatement statement = null;
	ResultSet rs = null;
	
	statement = c.prepareStatement(findIdStatement);
	statement.setInt(1, id);
	rs = statement.executeQuery();
	if(rs != null && rs.next()){
		room = new Room(rs.getInt("idroom"), rs.getString("nume"), rs.getInt("nrLoc"),rs.getFloat("pret"),rs.getBoolean("disponibilitate"));
	}
	}
	catch(Exception e1){
		
	}
	return room;
	
}
public Room convertRow(ResultSet myResult) throws SQLException{

	int idroom = myResult.getInt("idroom");
	String nume = myResult.getString("nume");
	int nrLoc = myResult.getInt("nrLoc");
	float pret = myResult.getFloat("pret");
	boolean disp = myResult.getBoolean("disponibilitate");
	Room room = new Room(idroom,nume,nrLoc,pret,disp);
	

return room;	
}
}
