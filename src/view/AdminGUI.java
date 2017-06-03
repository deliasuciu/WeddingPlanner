package view;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdminGUI {

JFrame frameA;
	
	JButton addUser;
	JButton deleteUser;
	JButton updateUser;
	JButton addBand;
	JButton deleteBand;
	JButton updateBand;
	JButton searchBand;
	JButton viewBand;
	JButton addRoom;
	JButton deleteRoom;
	JButton updateRoom;
	JButton viewRoom;
	JButton viewUser;
	JButton report;
	
	
	JLabel numeL;
	JLabel parolaL;
	JLabel idRL;
	JLabel numeRL;
	JLabel nrlocL;
	JLabel priceRL;
	JLabel idBL;
	JLabel numeBL;
	JLabel pretBL;
	
	
	JTextField nume;
	JTextField parola;
	JTextField idR;
	JTextField numeR;
	JTextField nrloc;
	JTextField pretR;
	JTextField idB;
	JTextField numeB;
	JTextField pretB;
	
	
	Checkbox admin;
	Checkbox disponibilR;
	Checkbox disponibilB;
	
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
	
	public AdminGUI(){
		initialize();
	}
	public AdminGUI(String username){
		this.username = username;
	}

	public JFrame initialize(){
	if (frameA == null) {
		frameA = new JFrame();
		frameA.getContentPane().setBackground(Color.pink);
		frameA.setBackground(Color.pink);
		frameA.setVisible(true);
		frameA.setBounds(100, 100, 1014, 1016);
		frameA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameA.getContentPane().setLayout(null);
		
		
		tabel1= new DefaultTableModel(null, new Object[] {"Username","Password","Administrator"});
		t1 = new JTable(tabel1);
		scroll1 = new JScrollPane(t1);
		
		scroll1.setBounds(10, 40, 400, 150);
		scroll1.setVisible(true);
		frameA.add(scroll1); 
		
		tabel2= new DefaultTableModel(null, new Object[] {"idSala","Nume","Nr loc","Pret","Disponibilitate"});
		t2 = new JTable(tabel2);
		scroll2 = new JScrollPane(t2);
		
		scroll2.setBounds(10, 340, 400, 150);
		scroll2.setVisible(true);
		frameA.add(scroll2); 
		
		tabel3= new DefaultTableModel(null, new Object[] {"idTrupa","Nume","Pret","Disponibilitate"});
		t3 = new JTable(tabel3);
		scroll3 = new JScrollPane(t3);
		
		scroll3.setBounds(460, 340, 400, 150);
		scroll3.setVisible(true);
		frameA.add(scroll3); 
		
		addUser = new JButton();
		addUser.setText("Add user");
		addUser.setBounds(430, 20, 100, 20);
		frameA.add(addUser);
		
		deleteUser = new JButton();
		deleteUser.setText("Delete user");
		deleteUser.setBounds(580, 20, 100, 20);
		frameA.add(deleteUser);
		
		updateUser = new JButton();
		updateUser.setText("Update user");
		updateUser.setBounds(430, 80, 120, 20);
		frameA.add(updateUser);
		

		//report = new JButton();
		//report.setText("Generate report");
	//	report.setBounds(600, 480, 150, 20);
	//	frameA.add(report);
		
		addBand = new JButton();
		addBand.setText("Add band");
		addBand.setBounds(670, 500, 100, 20);
		frameA.add(addBand);
		
		deleteBand = new JButton();
		deleteBand.setText("Delete band");
		deleteBand.setBounds(670, 530, 120, 20);
		frameA.add(deleteBand);
		
		updateBand = new JButton();
		updateBand.setText("Update band");
		updateBand.setBounds(670, 560, 120, 20);
		frameA.add(updateBand);
		
		viewBand = new JButton();
		viewBand.setText("View band");
		viewBand.setBounds(670, 590, 100, 20);
		frameA.add(viewBand);
		
		viewUser = new JButton();
		viewUser.setText("View users");
		viewUser.setBounds(570, 80, 100, 20);
		frameA.add(viewUser);
		
		addRoom = new JButton();
		addRoom.setText("Add room");
		addRoom.setBounds(160, 500, 100, 20);
		frameA.add(addRoom);
		
		deleteRoom = new JButton();
		deleteRoom.setText("Delete room");
		deleteRoom.setBounds(160, 530, 120, 20);
		frameA.add(deleteRoom);
		
		updateRoom = new JButton();
		updateRoom.setText("Update room");
		updateRoom.setBounds(160, 560, 120, 20);
		frameA.add(updateRoom);
		
		viewRoom = new JButton();
		viewRoom.setText("View room");
		viewRoom.setBounds(160, 590, 100, 20);
		frameA.add(viewRoom);
		
		numeL = new JLabel();
		numeL.setText("Username");
		numeL.setBounds(430,135,120,20);
		frameA.add(numeL);
		
		
		
		idRL = new JLabel();
		idRL.setText("ID:");
		idRL.setBounds(10,500,120,20);
		frameA.add(idRL);
		
		numeRL = new JLabel();
		numeRL.setText("Nume:");
		numeRL.setBounds(10, 530, 120,20);
		frameA.add(numeRL);
		
		nrlocL = new JLabel();
		nrlocL.setText("Nr loc:");
		nrlocL.setBounds(10, 560, 120,20);
		frameA.add(nrlocL);
		
		priceRL = new JLabel();
		priceRL.setText("Pret:");
		priceRL.setBounds(10, 590, 120, 20);
		frameA.add(priceRL);
		
		idBL = new JLabel();
		idBL.setText("ID:");
		idBL.setBounds(520, 500, 120, 20);
		frameA.add(idBL);

		numeBL = new JLabel();
		numeBL.setText("Nume:");
		numeBL.setBounds(520, 530, 120, 20);
		frameA.add(numeBL);
		
		pretBL = new JLabel();
		pretBL.setText("Pret:");
		pretBL.setBounds(520, 560, 120, 20);
		frameA.add(pretBL);
		
		nume = new JTextField();
		nume.setBounds(490,135,150,20);
		frameA.add(nume);
		
		parolaL = new JLabel();
		parolaL.setText("Password");
		parolaL.setBounds(430,190,120,20);
		frameA.add(parolaL);
		
		parola = new JTextField();
		parola.setBounds(490,190,150,20);
		frameA.add(parola);

		admin = new Checkbox("Administrator");
		admin.setFont(new Font("Yu Gothic Medium", Font.BOLD,15));
		admin.setBounds(430, 230, 150, 25);
		admin.setVisible(true);
		frameA.add(admin);
		
		disponibilB = new Checkbox("Trupa Disponibila");
		disponibilB.setFont(new Font("Yu Gothic Medium", Font.BOLD,10));
		disponibilB.setBounds(400, 520, 150, 25);
		disponibilB.setVisible(true);
		frameA.add(disponibilB);
		
		disponibilR = new Checkbox("Sala disponibila");
		disponibilR.setFont(new Font("Yu Gothic Medium", Font.BOLD,10));
		disponibilR.setBounds(400, 550, 150, 25);
		disponibilR.setVisible(true);
		frameA.add(disponibilR );
		
		
		idR = new JTextField();
		idR.setBounds(50, 500, 100, 20);
		frameA.add(idR);
		
		nrloc = new JTextField();
		nrloc.setBounds(50, 560, 100, 20);
		frameA.add(nrloc);
		
		numeR = new JTextField();
		numeR.setBounds(50, 530, 100, 20);
		frameA.add(numeR);
		
		pretR = new JTextField();
		pretR.setBounds(50,590,100,20);
		frameA.add(pretR);
		
		idB = new JTextField();
		idB.setBounds(560, 500, 100, 20);
		frameA.add(idB);
		
		numeB = new JTextField();
		numeB.setBounds(560, 530, 100, 20);
		frameA.add(numeB);
		
		pretB = new JTextField();
		pretB.setBounds(560,560,100,20);
		frameA.add(pretB);
		
	}
	return frameA;
}
	public String getNume(){
		return nume.getText();
	}
	public String getParola(){
		return parola.getText();
	}
	
	public boolean isAdmin(){
		return admin.getState();
	}
	
	public DefaultTableModel getUserTable(){
		return tabel1;
	}
	public int getIdRoom(){
		return Integer.parseInt(idR.getText());
	}
	public String getNameRoom(){
		return numeR.getText();
	}
	public int getNrLoc(){
		return Integer.parseInt(nrloc.getText());
	}
	public float getPretRoom(){
		return Float.parseFloat(pretR.getText());
	}
	public boolean isDispRoom(){
		return disponibilR.getState();
	}
	public int getIdBand(){
		return Integer.parseInt(idB.getText());
	}
	public String getNumeBand(){
		return numeB.getText();
	}
	public float getPretBand(){
		return Float.parseFloat(pretB.getText());
	}
	public boolean getDispBand(){
		return disponibilB.getState();
	}
	public DefaultTableModel getRoomTable(){
		return tabel2;
	}
	public DefaultTableModel getBandTable(){
		return tabel3;
	}
	public void addUserListener(ActionListener addListenU){
		this.addUser.addActionListener(addListenU);
	}
	
	public void deleteUserListener(ActionListener deleteListenU){
		this.deleteUser.addActionListener(deleteListenU);
	}
	public void updateUserListener(ActionListener updateListenU){
		this.updateUser.addActionListener(updateListenU);
	}
	public void viewUserListener(ActionListener viewListenU){
		this.viewUser.addActionListener(viewListenU);
	}
	
	public void addRoomListener(ActionListener addListenR){
		this.addRoom.addActionListener(addListenR);
	}
	
	public void deleteRoomListener(ActionListener deleteListenR){
		this.deleteRoom.addActionListener(deleteListenR);
	}
	
	public void updateRoomListener(ActionListener updateListenR){
		this.updateRoom.addActionListener(updateListenR);
	}
	public void viewRoomListener(ActionListener viewListenR){
		this.viewRoom.addActionListener(viewListenR);
	}
	public void addBandListener(ActionListener addListenB){
		this.addBand.addActionListener(addListenB);
	}
	public void deleteBandListener(ActionListener deleteListenB){
		this.deleteBand.addActionListener(deleteListenB);
	}
	public void updateBandListener(ActionListener updateBandListener){
		this.updateBand.addActionListener(updateBandListener);
	}
	public void viewBandListener(ActionListener viewBandListener){
		this.viewBand.addActionListener(viewBandListener);
	}
}
