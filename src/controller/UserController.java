package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Band;
import model.BandGateway;
import model.Rezervari;
import model.RezervariGateway;
import model.Room;
import model.RoomGateway;
import view.UserGUI;

public class UserController {

	private UserGUI usergui;
	
	public UserController(UserGUI usergui){
		this.usergui = usergui;
		this.usergui.searchByIDBandListener(new SearchBListener());
		this.usergui.searchByIDRoomListener(new SearchRListener());
		
		this.usergui.viewBListener(new ViewBListener());
		this.usergui.viewRListener(new ViewRListener());
		this.usergui.resBListener(new ReserveBandListener());
		this.usergui.resRListener(new ReserveRoomListener());
		this.usergui.viewRezListener(new ViewRezListener());
		this.usergui.addRezListener(new AddRezListener());
	}
	
	class SearchBListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//String nume = usergui.getNumeBand();
			int idband = usergui.getIDBand();
			Band band = new Band(idband,"",0,false);
			BandGateway bgateway = new BandGateway();
			try{
				 Band bd =   bgateway.searchByID(band);
				
					for(int i = usergui.getBandTable().getRowCount()-1;i>-1;i--){
						usergui.getBandTable().removeRow(i);
				    
				}
			 
					
					Object dataRow [] = {bd.getIdband(),bd.getNume(),bd.getPret(),bd.isDisp()};
					usergui.getBandTable().addRow(dataRow);
	
			}
			catch(Exception e1){
				
			}
		}
		}
	class SearchRListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//String nume = usergui.getNumeBand();
			int idroom = usergui.getIDRoom();
			Room room = new Room(idroom,"",0,0,false);
			RoomGateway rgateway = new RoomGateway();
			try{
				 Room r =   rgateway.searchByID(room);
				
					for(int i = usergui.getRoomTable().getRowCount()-1;i>-1;i--){
						usergui.getRoomTable().removeRow(i);
				    
				}
			 
					
					Object dataRow [] = {r.getIdRoom(),r.getNume(),r.getNrLoc(),r.getPret(),r.isDisponibil()};
					usergui.getRoomTable().addRow(dataRow);
	
			}
			catch(Exception e1){
				
			}
		}
		}
	
	class ViewBListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Band band = new Band();
			BandGateway bgateway = new BandGateway();
			try{
				List<Band> bands = bgateway.getAll();
				
					for(int i = usergui.getBandTable().getRowCount()-1;i>-1;i--){
						usergui.getBandTable().removeRow(i);
				    
				}
			 for(Band bd : bands){
					
					Object dataRow [] = {bd.getIdband(),bd.getNume(),bd.getPret(),bd.isDisp()};
					usergui.getBandTable().addRow(dataRow);
			}		
			}
			catch(Exception e1){
				
			}
		}

		
	}
	class ViewRListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Room room = new Room();
			RoomGateway rgateway = new RoomGateway();
			try{
				List<Room> rooms = rgateway.getAll();
				
					for(int i = usergui.getRoomTable().getRowCount()-1;i>-1;i--){
						usergui.getRoomTable().removeRow(i);
				    
				}
			 for(Room rm : rooms){
					
					Object dataRow [] = {rm.getIdRoom(),rm.getNume(),rm.getNrLoc(),rm.getPret(),rm.isDisponibil()};
					usergui.getRoomTable().addRow(dataRow);
			}		
			}
			catch(Exception e1){
				
			}
		}
		
	}
	class ReserveBandListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int idband = usergui.getIDBand();
			String nume = usergui.getNumeBand();
			boolean isDisp = usergui.getDispBand();
			List<Band> bd = null;
			Band b = new Band(idband,nume,0,isDisp);
			BandGateway bg = new BandGateway();
			try{
				bg.reserve(b);
				bd = bg.getAll();
				for(int i = usergui.getBandTable().getRowCount() - 1; i > -1;i--){
					usergui.getBandTable().removeRow(i);
				}
					for(Band band : bd){
				Object dataRow[] = {band.getIdband(),band.getNume(),band.getPret(),band.isDisp()};
				usergui.getBandTable().addRow(dataRow);}
			}catch(Exception e1){
				
			}
		}
	}
		
	class ReserveRoomListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int idroom = usergui.getIDRoom();
			String nume = usergui.getNumeRoom();
			boolean isDisp = usergui.getDispRoom();
			List<Room> rm = null;
			Room r = new Room(idroom,"",0,0,isDisp);
			RoomGateway rg = new RoomGateway();
			try{
				rg.reserve(r);
				rm = rg.getAll();
				for(int i = usergui.getRoomTable().getRowCount() - 1; i > -1;i--){
					usergui.getRoomTable().removeRow(i);
				}
					for(Room room : rm){
				Object dataRow[] = {room.getIdRoom(),room.getNume(),room.getNrLoc(),room.getPret(),room.isDisponibil()};
				usergui.getRoomTable().addRow(dataRow);}
			}catch(Exception e1){
				
			}
		}
	}
	
	class ViewRezListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Rezervari rez = new Rezervari();
		RezervariGateway rgateway = new RezervariGateway();
		try{
			List<Rezervari> rezervari = rgateway.getAll();
			
				for(int i = usergui.getRezTable().getRowCount()-1;i>-1;i--){
					usergui.getRezTable().removeRow(i);
			    
			}
		 for(Rezervari rz: rezervari){
				
				Object dataRow [] = {rz.getIdrezervari(),rz.getIdroom(),rz.getIdband(),rz.getData()};
				usergui.getRezTable().addRow(dataRow);
		}		
		}
		catch(Exception e1){
			
		}
	}
		
	}
	class AddRezListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int idroom = usergui.getIdRoomR();
			int idband = usergui.getIdBandR();
			Date data = usergui.getData();
			boolean isDispR = usergui.getDispRoom();
			boolean isDispB = usergui.getDispBand();
			Rezervari rez = new Rezervari(0,idroom,idband,data);
			RezervariGateway r = new RezervariGateway();
			RoomGateway room = new RoomGateway();
			BandGateway band = new BandGateway();
			ArrayList<Rezervari> rezervari = new ArrayList<>();
			try{
				Room rm =room.searchID(idroom);
				Band bn = band.searchID(idband);
				System.out.println(rm);
				System.out.println(bn);
				if( rm.isDisponibil()== true && bn.isDisp() == true){
					
					r.add(rez);
					rm = new Room(idroom,null,0,0,isDispR);
					bn = new Band(idband,null,0,isDispB);
					room.reserve(rm);
					band.reserve(bn);
					rezervari = r.getAll();
					for(Rezervari rz : rezervari){
					Object dataRow[] = {rz.getIdrezervari(),rz.getIdroom(),rz.getIdband(),rz.getData()};
					usergui.getRezTable().addRow(dataRow);
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Sala sau trupa sunt rezervate!");
				}
				
				
			}catch(Exception e1){
				
			}
		}
		
	}
	
}

