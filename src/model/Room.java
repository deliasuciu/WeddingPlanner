package model;

public class Room {
	private int idRoom;
	private String nume;
	private int nrLoc;
	private float pret;
	private boolean disponibil;
	public Room(int idRoom, String nume, int nrLoc, float pret, boolean disponibil) {
		
		this.idRoom = idRoom;
		this.nume = nume;
		this.nrLoc = nrLoc;
		this.pret = pret;
		this.disponibil = disponibil;
	}
	public Room(){
		
	}
	public int getIdRoom() {
		return idRoom;
	}
	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getNrLoc() {
		return nrLoc;
	}
	public void setNrLoc(int nrLoc) {
		this.nrLoc = nrLoc;
	}
	public float getPret() {
		return pret;
	}
	public void setPret(float pret) {
		this.pret = pret;
	}
	public boolean isDisponibil() {
		return disponibil;
	}
	public void setDisponibil(boolean disponibil) {
		this.disponibil = disponibil;
	}
	@Override
	public String toString() {
		return "Room [idRoom=" + idRoom + ", nume=" + nume + ", nrLoc=" + nrLoc + ", pret=" + pret + ", disponibil="
				+ disponibil + "]";
	}
	
	
}
