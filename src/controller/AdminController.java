package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Band;
import model.BandGateway;
import model.Room;
import model.RoomGateway;
import model.User;
import model.UserGateway;
import view.AdminGUI;

public class AdminController {

	private AdminGUI admingui;
	
	
	public AdminController(AdminGUI admingui){
		this.admingui = admingui;
		this.admingui.addUserListener(new AddUListener());
		this.admingui.deleteUserListener(new DeleteUListener());
		this.admingui.viewUserListener(new ViewUListener());
		this.admingui.updateUserListener(new UpdateUListener());
		this.admingui.addRoomListener(new AddRListener());
		this.admingui.deleteRoomListener(new DeleteRListener());
		this.admingui.updateRoomListener(new UpdateRListener());
		this.admingui.viewRoomListener(new ViewRListener());
		this.admingui.addBandListener(new AddBListener());
		this.admingui.deleteBandListener(new DeleteBListener());
		this.admingui.updateBandListener(new UpdateBListener());
		this.admingui.viewBandListener(new ViewBandListener());
		
	}
	
	class AddUListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		
		try{
			String username = admingui.getNume();
			String password = admingui.getParola();
			boolean admin = admingui.isAdmin();
			UserGateway usgateway = new UserGateway();
			User u = new User(username,password,admin);
			usgateway.add(u);
			
			Object dataRow[] = {u.getUsername(),u.getPassword(),u.isAdmin()};
			admingui.getUserTable().addRow(dataRow);
			
		}catch(Exception e){
			
		}
	}
	}
	
	class DeleteUListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String username = admingui.getNume();
			String password = admingui.getParola();
			boolean admin = admingui.isAdmin();
			UserGateway usgateway = new UserGateway();
			User u = new User(username,password,admin);
			List<User> users = null;
			try{
				usgateway.delete(u);
				users = usgateway.getAll();
				
				for(int i = admingui.getUserTable().getRowCount() - 1;i > -1; i--){
					admingui.getUserTable().removeRow(i);
				}
				for(User us : users){
					Object[] dataRow = {us.getUsername(),us.getPassword(),us.isAdmin()};
					admingui.getUserTable().addRow(dataRow);
					
				}
			}catch(Exception e1){
				
			}
		}
		
	}
	class ViewUListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			User user1 = new User();
			UserGateway usgateway = new UserGateway();
			try{
				List<User> users = usgateway.getAll();
				
					for(int i = admingui.getUserTable().getRowCount()-1;i>-1;i--){
						admingui.getUserTable().removeRow(i);
				    
				}
			 for(User us : users){
					
					Object dataRow [] = {us.getUsername(),us.getPassword(),us.isAdmin()};
					admingui.getUserTable().addRow(dataRow);
			}		
			}
			catch(Exception e1){
				
			}
		}
		
	}
	class UpdateUListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			User user1 = new User();
			List<User> users = null;
			String username = admingui.getNume();
			String password = admingui.getParola();
			Boolean adminC = Boolean.valueOf(admingui.isAdmin());
			UserGateway usgateway = new UserGateway();
			User u = new User(username,password,adminC);
			try{
				
				usgateway.update(u);
				users = usgateway.getAll();
				
					for(int i = admingui.getUserTable().getRowCount()-1; i>-1;i--){
						admingui.getUserTable().removeRow(i);
					}	
				
				for(User us : users){
					Object[] dataRow = {us.getUsername(),us.getPassword(),us.isAdmin()};
					admingui.getUserTable().addRow(dataRow);
				
				}
			}
			catch(Exception e1){
				
			}
		}
		
	}
	class AddRListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int idroom = admingui.getIdRoom();
			String nume = admingui.getNameRoom();
			int nrloc = admingui.getNrLoc();
			float pret = admingui.getPretRoom();
			boolean isDisp = admingui.isDispRoom();
			
			Room room = new Room(idroom,nume,nrloc,pret,isDisp);
			RoomGateway rg = new RoomGateway();
			try{
				rg.add(room);
				Object dataRow[] = {room.getIdRoom(),room.getNume(),room.getNrLoc(),room.getPret(),room.isDisponibil()};
				admingui.getRoomTable().addRow(dataRow);
			}catch(Exception e1){
				
			}
		}
		
	}
	
	class DeleteRListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int idroom = admingui.getIdRoom();
			String nume = admingui.getNameRoom();
			int nrloc = admingui.getNrLoc();
			float pret = admingui.getPretRoom();
			boolean isDisp = admingui.isDispRoom();
			List<Room> rm = null;
			Room r = new Room(idroom,nume,nrloc,pret,isDisp);
			RoomGateway rg = new RoomGateway();
			try{
				rg.delete(r);
				rm = rg.getAll();
				for(int i = admingui.getRoomTable().getRowCount() - 1; i > -1;i--){
					admingui.getRoomTable().removeRow(i);
				}
					for(Room room : rm){
				Object dataRow[] = {room.getIdRoom(),room.getNume(),room.getNrLoc(),room.getPret(),room.isDisponibil()};
				admingui.getRoomTable().addRow(dataRow);}
			}catch(Exception e1){
				
			}
		}
		}
		
	
	class UpdateRListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int idroom = admingui.getIdRoom();
			String nume = admingui.getNameRoom();
			int nrloc = admingui.getNrLoc();
			float pret = admingui.getPretRoom();
			boolean isDisp = admingui.isDispRoom();
			List<Room> rm = null;
			Room r = new Room(idroom,nume,nrloc,pret,isDisp);
			RoomGateway rg = new RoomGateway();
			try{
				rg.update(r);
				rm = rg.getAll();
				for(int i = admingui.getRoomTable().getRowCount() - 1; i > -1;i--){
					admingui.getRoomTable().removeRow(i);
				}
					for(Room room : rm){
				Object dataRow[] = {room.getIdRoom(),room.getNume(),room.getNrLoc(),room.getPret(),room.isDisponibil()};
				admingui.getRoomTable().addRow(dataRow);}
			}catch(Exception e1){
				
			}
		}
		}
		
	class ViewRListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Room room = new Room();
			RoomGateway rgateway = new RoomGateway();
			try{
				List<Room> rooms = rgateway.getAll();
				
					for(int i = admingui.getRoomTable().getRowCount()-1;i>-1;i--){
						admingui.getRoomTable().removeRow(i);
				    
				}
			 for(Room rm : rooms){
					
					Object dataRow [] = {rm.getIdRoom(),rm.getNume(),rm.getNrLoc(),rm.getPret(),rm.isDisponibil()};
					admingui.getRoomTable().addRow(dataRow);
			}		
			}
			catch(Exception e1){
				
			}
		}
		}
	class AddBListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int idband = admingui.getIdBand();
			String nume = admingui.getNumeBand();
			float pret = admingui.getPretBand();
			boolean isDisp = admingui.getDispBand();
			
			Band band = new Band(idband,nume,pret,isDisp);
			BandGateway bg = new BandGateway();
			try{
				bg.add(band);
				Object dataRow[] = {band.getIdband(),band.getNume(),band.getPret(),band.isDisp()};
				admingui.getBandTable().addRow(dataRow);
			}catch(Exception e1){
				
			}
		}
		}
		
	class DeleteBListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int idband = admingui.getIdBand();
			String nume = admingui.getNumeBand();
			float pret = admingui.getPretBand();
			boolean isDisp = admingui.getDispBand();
			List<Band> band = null;
		    Band b= new Band(idband,nume,pret,isDisp);
			BandGateway bg = new BandGateway();
			try{
				bg.delete(b);
				band = bg.getAll();
				for(int i = admingui.getRoomTable().getRowCount() - 1; i > -1;i--){
					admingui.getRoomTable().removeRow(i);
				}
					for(Band bd : band){
				Object dataRow[] = {bd.getIdband(),bd.getNume(),bd.getPret(),bd.isDisp()};
				admingui.getBandTable().addRow(dataRow);}
			}catch(Exception e1){
				
			}
		}
		}
		
	class UpdateBListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int idband = admingui.getIdBand();
			String nume = admingui.getNumeBand();
			float pret = admingui.getPretBand();
			boolean isDisp = admingui.getDispBand();
			List<Band> bd = null;
			Band b = new Band(idband,nume,pret,isDisp);
			BandGateway bg = new BandGateway();
			try{
				bg.update(b);
				bd = bg.getAll();
				for(int i = admingui.getBandTable().getRowCount() - 1; i > -1;i--){
					admingui.getBandTable().removeRow(i);
				}
					for(Band band : bd){
				Object dataRow[] = {band.getIdband(),band.getNume(),band.getPret(),band.isDisp()};
				admingui.getBandTable().addRow(dataRow);}
			}catch(Exception e1){
				
			}
		}
		
	}
	
	class ViewBandListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Band band = new Band();
			BandGateway bgateway = new BandGateway();
			try{
				List<Band> bands = bgateway.getAll();
				
					for(int i = admingui.getBandTable().getRowCount()-1;i>-1;i--){
						admingui.getBandTable().removeRow(i);
				    
				}
			 for(Band bd : bands){
					
					Object dataRow [] = {bd.getIdband(),bd.getNume(),bd.getPret(),bd.isDisp()};
					admingui.getBandTable().addRow(dataRow);
			}		
			}
			catch(Exception e1){
				
			}
		}
		
	}
		
}
