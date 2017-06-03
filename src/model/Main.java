package model;

import javax.swing.JFrame;

import controller.AdminController;
import controller.UserController;
import controller.WeddingController;
import view.AdminGUI;
import view.UserGUI;
import view.WeddingGUI;

public class Main {
	public static AdminController adminController;
	public static WeddingController weddingController;
	public static UserController userController;

	public static AdminGUI admingui;
	public static WeddingGUI weddinggui;
	public static UserGUI usergui;
	
	
	public static void main(String[] args){
		weddinggui = new WeddingGUI();
		weddingController = new WeddingController(weddinggui);
	}

	public static void openAdmin(){
		admingui = new AdminGUI();
		JFrame adminF = admingui.initialize();
		adminF.setVisible(true);
		adminController = new AdminController(admingui);
	}
	
	public static void openUser(){
		usergui = new UserGUI();
		JFrame employeeF = usergui.initialize();
		employeeF.setVisible(true);
		userController = new UserController(usergui);
	}
	
}
