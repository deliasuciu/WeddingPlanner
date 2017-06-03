package model;

import java.sql.Date;

public class Rezervari {

	private int idrezervari;
	private int idroom;
	private int idband;
	private Date data;
	
	public Rezervari(int idrezervari, int idroom, int idband, Date data) {
		
		this.idrezervari = idrezervari;
		this.idroom = idroom;
		this.idband = idband;
		this.data = data;
	}
	public Rezervari(){
		
	}
	public int getIdrezervari() {
		return idrezervari;
	}
	public void setIdrezervari(int idrezervari) {
		this.idrezervari = idrezervari;
	}
	public int getIdroom() {
		return idroom;
	}
	public void setIdroom(int idroom) {
		this.idroom = idroom;
	}
	public int getIdband() {
		return idband;
	}
	public void setIdband(int idband) {
		this.idband = idband;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Rezervari [idrezervari=" + idrezervari + ", idroom=" + idroom + ", idband=" + idband + ", data=" + data
				+ "]";
	}
	
	
}
