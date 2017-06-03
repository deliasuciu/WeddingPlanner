package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class WeddingGUI {
	public JFrame frame;
	private JButton login;
	private JPanel panel;
	private JLabel numeL;
	private JLabel parolaL;
	private JLabel text;
	
	public JTextField nume;
	private JPasswordField parola;

	
	public WeddingGUI() {
		
		frame = new JFrame("Logare");
		frame.getContentPane().setBackground(Color.pink);
		frame.setBackground(Color.pink);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 950, 900);
		panel.setVisible(true);
		this.frame.add(this.panel);
		
		login = new JButton();
		login.setText("Login");
		login.setBounds(180, 300, 90, 20);
		login.setVisible(true);
		panel.add(login);
	
		numeL = new JLabel();
		numeL.setText("Username");
		numeL.setBounds(80, 90, 120,20);
		panel.add(numeL);
		
		parolaL = new JLabel();
		parolaL.setText("Password");
		parolaL.setBounds(80,120,120,20);
		panel.add(parolaL);
		
		nume = new JTextField();
		nume.setBounds(160, 90, 150, 20);
		nume.setVisible(true);
		panel.add(nume);
		
		parola = new JPasswordField();
		parola.setBounds(160,120,150,20);
		parola.setVisible(true);
		panel.add(parola);
		
		text = new JLabel();
		text.setText("");
		text.setBounds(30, 160, 250, 27);
		text.setVisible(true);
		panel.add(text);
		
		
			
	}
	
	public String getNume(){
		return nume.getText();
	}

	public String getParola(){
		return parola.getText();
	}
	
	public void setLabel(String s){
		this.text.setText(s);
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	
	
	public void addListener(ActionListener addL){
		login.addActionListener(addL);
	}
	
	//mesaj pt erori
		 void displayErrorMessage(String errorMessage){
			 JOptionPane.showMessageDialog(this.frame, errorMessage);
		 }
}
