package model;

public class Band {

	private int idband;
	private String nume;
	private float pret;
	private boolean disp;
	public Band(int idband, String nume, float pret, boolean disp) {
		
		this.idband = idband;
		this.nume = nume;
		this.pret = pret;
		this.disp = disp;
	}
	public Band()
	{
		
	}
	public int getIdband() {
		return idband;
	}
	public void setIdband(int idband) {
		this.idband = idband;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public float getPret() {
		return pret;
	}
	public void setPret(float pret) {
		this.pret = pret;
	}
	public boolean isDisp() {
		return disp;
	}
	public void setDisp(boolean disp) {
		this.disp = disp;
	}
	@Override
	public String toString() {
		return "Band [idband=" + idband + ", nume=" + nume + ", pret=" + pret + ", disp=" + disp + "]";
	}
	
	
}
