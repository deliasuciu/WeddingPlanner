package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RezervariGateway {

	private static final String addRezervareStatement = "insert into rezervari (idrezervari, idroom, idband,data) values (?,?,?,?)";
	private static final String viewRezervareStatement = "select * from rezervari ";
	
	
	public void add(Rezervari rez) {
		Connection c;
		try {
			c = Driver.getDBConnection();
			PreparedStatement statement = c.prepareStatement(addRezervareStatement);
			statement.setInt(1, rez.getIdrezervari());
			statement.setInt(2, rez.getIdroom());
			statement.setInt(3, rez.getIdband());
			statement.setDate(4, rez.getData());
			statement.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
	
	public ArrayList<Rezervari> getAll(){
		ArrayList<Rezervari> list = new ArrayList<>();
		try{
		Statement myStmt = null;
		ResultSet myRes = null;
		Connection c = Driver.getDBConnection();
			
			myStmt = c.createStatement();
			myRes = myStmt.executeQuery(viewRezervareStatement);
			
			while(myRes.next()){
				Rezervari rezervari = convertRow(myRes);
				list.add(rezervari);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Rezervari convertRow(ResultSet myResult) throws SQLException{

		int idrez = myResult.getInt("idrezervari");
		int idroom = myResult.getInt("idroom");
		int idband = myResult.getInt("idband");
		Date data = myResult.getDate("data");
		Rezervari rez = new Rezervari(idrez,idroom,idband,data);
		

	return rez;	
	}
}
