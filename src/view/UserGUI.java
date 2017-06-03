package view;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UserGUI {

JFrame frameU;
	
	JButton searchByNameB;
	JButton searchByNameR;
	JButton resR;
	JButton resB;
	JButton viewR;
	JButton viewB;
	JButton addRez;
	JButton viewRez;
	
	JTextField idR;
	JTextField numeR;
	JTextField idB;
	JTextField numeB;
	JTextField idroom;
	JTextField idband;
	JTextField data;
	
	
	JLabel idRL;
	JLabel numeRL;
	JLabel idBL;
	JLabel numeBL;
	JLabel idbandL;
	JLabel idroomL;
	JLabel dataL;
	
	private DefaultTableModel tabel1;
	private JTable t1;
	private JScrollPane scroll1;
	
	private DefaultTableModel tabel2;
	private JTable t2;
	private JScrollPane scroll2;
	
	private DefaultTableModel tabel3;
	private JTable t3;
	private JScrollPane scroll3;
	String username;
	Checkbox disponibilR;
	Checkbox disponibilB;
	public UserGUI(){
		initialize();
	}
	
	public UserGUI(String username){
		this.username = username;
	}
	public JFrame initialize(){
		
		if (frameU == null) {
			frameU = new JFrame("User");
			frameU.getContentPane().setBackground(Color.pink);
			frameU.setBackground(Color.PINK);
			frameU.setBounds(100, 100, 814, 816);
			frameU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameU.setVisible(true);
			frameU.getContentPane().setLayout(null);
		
			
			tabel1= new DefaultTableModel(null, new Object[] {"idSala","Nume","Nr loc","Pret","Disponibilitate"});
			t1 = new JTable(tabel1);
			scroll1 = new JScrollPane(t1);
			
			scroll1.setBounds(10, 40, 400, 150);
			scroll1.setVisible(true);
			frameU.add(scroll1);  
			
			tabel2= new DefaultTableModel(null, new Object[] {"idTrupa","Nume","Pret","Disponibilitate"});
			t2 = new JTable(tabel2);
			scroll2 = new JScrollPane(t2);
			
			scroll2.setBounds(10, 210, 400, 150);
			scroll2.setVisible(true);
			frameU.add(scroll2);  
			
			tabel3= new DefaultTableModel(null, new Object[] {"idRez","idSala","idTrupa","Data"});
			t3 = new JTable(tabel3);
			scroll3 = new JScrollPane(t3);
			
			scroll3.setBounds(10, 430, 400, 150);
			scroll3.setVisible(true);
			frameU.add(scroll3);  
	
	
			searchByNameR = new JButton();
			searchByNameR.setText("Search room");
			searchByNameR.setBounds(600, 50, 150, 20);
			frameU.add(searchByNameR);
			
						
			searchByNameB = new JButton();
			searchByNameB.setText("Search band");
			searchByNameB.setBounds(600, 80, 150, 20);
			frameU.add(searchByNameB);
			
			resB = new JButton();
			resB.setText("Reserve band");
			resB.setBounds(600, 20, 150, 20);
			frameU.add(resB);
			
			resR = new JButton();
			resR.setText("Reserve room");
			resR.setBounds(605, 110, 150, 20);
			frameU.add(resR);
			
			viewB = new JButton();
			viewB.setText("View bands");
			viewB.setBounds(605, 260, 150, 20);
			frameU.add(viewB);
			
			viewR = new JButton();
			viewR.setText("View rooms");
			viewR.setBounds(605, 210, 150, 20);
			frameU.add(viewR);
			
			viewRez = new JButton();
			viewRez.setText("View rez");
			viewRez.setBounds(605, 290, 150, 20);
			frameU.add(viewRez);
			
			addRez = new JButton();
			addRez.setText("Add rez");
			addRez.setBounds(605, 320, 150, 20);
			frameU.add(addRez);
			
			
			idR = new JTextField();
			idR.setBounds(480, 20, 100, 20);
			frameU.add(idR);
			
			idroom = new JTextField();
			idroom.setBounds(480, 220, 100, 20);
			frameU.add(idroom);
			
			idband = new JTextField();
			idband.setBounds(480, 250, 100, 20);
			frameU.add(idband);
			
			data = new JTextField();
			data.setBounds(480, 280, 100, 20);
			frameU.add(data);
			
			numeR = new JTextField();
			numeR.setBounds(480, 50, 100, 20);
			frameU.add(numeR);
			
			idB = new JTextField();
			idB.setBounds(480, 80, 100, 20);
			frameU.add(idB);
			
			numeB = new JTextField();
			numeB.setBounds(510, 150, 100, 20);
			frameU.add(numeB);
			
			//titleS = new JTextField();
		///	titleS.setBounds(480, 180, 100, 20);
			//frameU.add(titleS);
			
			idRL = new JLabel();
			idRL.setText("IDR:");
			idRL.setBounds(430, 20, 120,20);
			frameU.add(idRL);
			
			numeRL = new JLabel();
			numeRL.setText("NameR:");
			numeRL.setBounds(430, 50, 120,20);
			frameU.add(numeRL);
			
			idBL = new JLabel();
			idBL.setText("idB:");
			idBL.setBounds(430, 80, 120,20);
			frameU.add(idBL);
			
			numeBL = new JLabel();
			numeBL.setText("NameB:");
			numeBL.setBounds(450, 180, 120,20);
			frameU.add(numeBL);
			
			idroomL = new JLabel();
			idroomL.setText("IDRoom:");
			idroomL.setBounds(430, 220, 120,20);
			frameU.add(idroomL);
			
			idbandL = new JLabel();
			idbandL.setText("IDBand:");
			idbandL.setBounds(430, 250, 120,20);
			frameU.add(idbandL);
			
			dataL = new JLabel();
			dataL.setText("Data:");
			dataL.setBounds(430, 280, 120,20);
			frameU.add(dataL);
			
			
			//quantityL = new JLabel();
		//	quantityL.setText("Quantity:");
		//	quantityL.setBounds(450, 150, 120,20);
		//	frameU.add(quantityL);
			disponibilB = new Checkbox("Trupa Disponibila");
			disponibilB.setFont(new Font("Yu Gothic Medium", Font.BOLD,10));
			disponibilB.setBounds(400, 520, 150, 25);
			disponibilB.setVisible(true);
			//frameU.add(disponibilB);
			
			disponibilR = new Checkbox("Sala disponibila");
			disponibilR.setFont(new Font("Yu Gothic Medium", Font.BOLD,10));
			disponibilR.setBounds(400, 550, 150, 25);
			disponibilR.setVisible(true);
			//frameU.add(disponibilR );
			
		}
		return frameU;
	}
	
	public String getNumeBand(){
		return numeB.getText();
	}
	public String getNumeRoom(){
		return numeR.getText();
	}
	
	public int getIDRoom(){
		return Integer.parseInt(idR.getText());
	}
	public int getIDBand(){
		return Integer.parseInt(idB.getText());
	}
	public DefaultTableModel getRoomTable(){
		return tabel1;
	}
	public DefaultTableModel getBandTable(){
		return tabel2;
	}
	public boolean getDispBand(){
		return disponibilB.getState();
	}
	public boolean getDispRoom(){
		return disponibilR.getState();
	}
	public DefaultTableModel getRezTable(){
		return tabel3;
	}
	
	public int getIdRoomR(){
		return Integer.parseInt(idroom.getText());
	}
	public int getIdBandR(){
		return Integer.parseInt(idband.getText());
	}
	public Date getData(){
		return Date.valueOf(data.getText());
	}
	public void searchByIDRoomListener(ActionListener searchRoomListener){
		this.searchByNameR.addActionListener(searchRoomListener);
	}
	public void searchByIDBandListener(ActionListener searchBandListener){
		this.searchByNameB.addActionListener(searchBandListener);
	}
	public void viewRListener(ActionListener viewRoomListener){
		this.viewR.addActionListener(viewRoomListener);
	}
	public void viewBListener(ActionListener viewBandListener){
		this.viewB.addActionListener(viewBandListener);
	}
	public void resRListener(ActionListener resRoomListener){
		this.resR.addActionListener(resRoomListener);
	}
	public void resBListener(ActionListener resBandListener){
		this.resB.addActionListener(resBandListener);
	}
	public void viewRezListener(ActionListener wiewRezListener){
		this.viewRez.addActionListener(wiewRezListener);
	}
	public void addRezListener(ActionListener addRezListener){
		this.addRez.addActionListener(addRezListener);
	}
}
