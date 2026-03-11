package com.BWA.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long acnum;
	private String acholdername;
	private int acholderage;
	private String acholderaddress;
	private long acholderaadharnum;
	private String acholdergender;
	private long acholdermobile;
	private double acbalance;
	public long getAcnum() {
		return acnum;
	}
	public void setAcnum(long acnum) {
		this.acnum = acnum;
	}
	public String getAcholdername() {
		return acholdername;
	}
	public void setAcholdername(String acholdername) {
		this.acholdername = acholdername;
	}
	public int getAcholderage() {
		return acholderage;
	}
	public void setAcholderage(int acholderage) {
		this.acholderage = acholderage;
	}
	public String getAcholderaddress() {
		return acholderaddress;
	}
	public void setAcholderaddress(String acholderaddress) {
		this.acholderaddress = acholderaddress;
	}
	public long getAcholderaadharnum() {
		return acholderaadharnum;
	}
	public void setAcholderaadharnum(long acholderaadharnum) {
		this.acholderaadharnum = acholderaadharnum;
	}
	public String getAcholdergender() {
		return acholdergender;
	}
	public void setAcholdergender(String acholdergender) {
		this.acholdergender = acholdergender;
	}
	public long getAcholdermobile() {
		return acholdermobile;
	}
	public void setAcholdermobile(long acholdermobile) {
		this.acholdermobile = acholdermobile;
	}
	public double getAcbalance() {
		return acbalance;
	}
	public void setAcbalance(double acbalance) {
		this.acbalance = acbalance;
	}
	public Account(long acnum, String acholdername, int acholderage, String acholderaddress, long acholderaadharnum,
			String acholdergender, long acholdermobile, double acbalance) {
		super();
		this.acnum = acnum;
		this.acholdername = acholdername;
		this.acholderage = acholderage;
		this.acholderaddress = acholderaddress;
		this.acholderaadharnum = acholderaadharnum;
		this.acholdergender = acholdergender;
		this.acholdermobile = acholdermobile;
		this.acbalance = acbalance;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [acnum=" + acnum + ", acholdername=" + acholdername + ", acholderage=" + acholderage
				+ ", acholderaddress=" + acholderaddress + ", acholderaadharnum=" + acholderaadharnum
				+ ", acholdergender=" + acholdergender + ", acholdermobile=" + acholdermobile + ", acbalance="
				+ acbalance + "]";
	}
	

}
