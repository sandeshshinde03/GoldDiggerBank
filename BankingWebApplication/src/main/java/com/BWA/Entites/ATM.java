package com.BWA.Entites;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class ATM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cardno;
	private int pin;
	private String name;
	private long acno;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date validFrom;
	@Temporal(TemporalType.DATE)
	private Date expUpTo;
	private String bankname;
	public long getCardno() {
		return cardno;
	}
	public void setCardno(long cardno) {
		this.cardno = cardno;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAcno() {
		return acno;
	}
	public void setAcno(long acno) {
		this.acno = acno;
	}
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public Date getExpUpTo() {
		return expUpTo;
	}
	public void setExpUpTo(Date expUpTo) {
		this.expUpTo = expUpTo;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	@Override
	public String toString() {
		return "ATM [cardno=" + cardno + ", pin=" + pin + ", name=" + name + ", acno=" + acno + ", validFrom="
				+ validFrom + ", expUpTo=" + expUpTo + ", bankname=" + bankname + "]";
	}
	public ATM(long cardno, int pin, String name, long acno, Date validFrom, Date expUpTo, String bankname) {
		super();
		this.cardno = cardno;
		this.pin = pin;
		this.name = name;
		this.acno = acno;
		this.validFrom = validFrom;
		this.expUpTo = expUpTo;
		this.bankname = bankname;
	}
	public ATM() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
