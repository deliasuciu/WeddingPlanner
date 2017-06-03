package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Main;
import model.User;
import model.UserGateway;
import view.AdminGUI;
import view.UserGUI;
import view.WeddingGUI;

public class WeddingController {
	private UserGUI user;
	private AdminGUI admin;
	private WeddingGUI wed;
	
	public WeddingController(WeddingGUI wed){
		this.wed = wed;
		
		this.wed.addListener(new LoginListener());
	}
	


	class LoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
			String username = wed.getNume();
			String password = wed.getParola();
			User usernou = new User();
			UserGateway ug = new UserGateway();
			try{
				usernou = ug.login(username, password);
				if(usernou != null){
					System.out.println("LOGOUT");
				if(usernou.isAdmin()){
					Main.openAdmin();
					
					
				}
				else
				{
						Main.openUser();
						
					}
				}
					else{
						wed.setLabel("Contul sau parola incorecte!!");
					}
			
					
			}catch(Exception ex){
				ex.printStackTrace();
		}
		}
}
}
