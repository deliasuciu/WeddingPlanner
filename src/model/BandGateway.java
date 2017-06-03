package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BandGateway {

	private static String addBandStatement = "insert into band (idband, nume,pret, disponibilitate) values (?, ?,?,?)";
	private static String deleteBandStatement = "delete from band where idband = ?";
	private static String updateBandStatement = "update band set nume = ?,  pret = ?, disponibilitate =? where idband = ?";
	private static String allBandsStatement = "select * from band ";
	private static String searchBandStatement = "select * from band where idband like ?";
	private static String searchBNameStatement = "select * from band where nume = ?";
	private static String reserveBStatement = "update band set disponibilitate = ? where idband = ?";
	private static String findIdStatement = "select * from band where idband = ?";
	
	
	
	public void add(Band band) {
		Connection c;
		try {
			c = Driver.getDBConnection();
			PreparedStatement statement = c.prepareStatement(addBandStatement);
			statement.setInt(1, band.getIdband());
			statement.setString(2, band.getNume());
			statement.setFloat(3,band.getPret());
			statement.setBoolean(4, band.isDisp());
			statement.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
	
	public void delete(Band b) {
		try{
		Connection c = Driver.getDBConnection();
		
		PreparedStatement statement = c.prepareStatement(deleteBandStatement);
		statement.setInt(1, b.getIdband());
		statement.executeUpdate();
	
	}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void update(Band band){
		try{
		Connection c = Driver.getDBConnection();
		
		PreparedStatement statement = c.prepareStatement(updateBandStatement);
		statement.setInt(4, band.getIdband());
		statement.setString(1, band.getNume());
		statement.setFloat(2, band.getPret());
		statement.setBoolean(3, band.isDisp());
		statement.executeUpdate();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void reserve(Band band){
		try{
		Connection c = Driver.getDBConnection();
		
		PreparedStatement statement = c.prepareStatement(reserveBStatement);
		statement.setInt(2, band.getIdband());
		statement.setBoolean(1, band.isDisp());
		statement.executeUpdate();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	public ArrayList<Band> getAll(){
		ArrayList<Band> list = new ArrayList<>();
		try{
		Statement myStmt = null;
		ResultSet myRes = null;
		Connection c = Driver.getDBConnection();
			
			myStmt = c.createStatement();
			myRes = myStmt.executeQuery(allBandsStatement);
			
			while(myRes.next()){
				Band band = convertRow(myRes);
				list.add(band);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Band searchByID(Band band){
		Band b = null;
		try{
			Connection c = Driver.getDBConnection();
			PreparedStatement statement = null;
			ResultSet rs = null;
			
			statement = c.prepareStatement(searchBandStatement);
			statement.setInt(1, band.getIdband());
			
			rs = statement.executeQuery();
			
			if(rs != null && rs.next()){
				b = new Band(band.getIdband(), rs.getString("nume"),rs.getFloat("pret"),rs.getBoolean("disponibilitate"));
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	
	public ArrayList<Band> searchByName(Band b){
		ArrayList<Band> list = new ArrayList<>();
		try{
		Statement myStmt = null;
		ResultSet myRes = null;
		Connection c = Driver.getDBConnection();
			
			myStmt = c.createStatement();
			myRes = myStmt.executeQuery(searchBandStatement);
			
			while(myRes.next()){
				Band band = convertRow(myRes);
				list.add(band);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return list;
	}

	public Band searchID(int id){
		Band band = null;
		try{
		Connection c = Driver.getDBConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		statement = c.prepareStatement(findIdStatement);
		statement.setInt(1, id);
		rs = statement.executeQuery();
		if(rs != null && rs.next()){
			band = new Band(rs.getInt("idband"), rs.getString("nume"),rs.getFloat("pret"),rs.getBoolean("disponibilitate"));
		}
		}
		catch(Exception e1){
			
		}
		return band;
		
	}
	

public Band convertRow(ResultSet myResult) throws SQLException{

	int idband = myResult.getInt("idband");
	String nume = myResult.getString("nume");
	float pret = myResult.getFloat("pret");
	boolean disp = myResult.getBoolean("disponibilitate");
	Band band = new Band(idband,nume,pret,disp);
	

return band;	
}
}
