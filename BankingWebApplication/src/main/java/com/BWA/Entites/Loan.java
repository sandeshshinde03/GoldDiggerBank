package com.BWA.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loanId;
	private String applicantname;
	private int applicantage;
	private String applicantgender;
	private String applicantaddress;
	private long applicantaadharnum;
	private long applicantmobile;
	private String gname;
	private long gadharnum;
	private String grelation;
	private String loanType;
	private double examt;
	private String status;
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public String getApplicantname() {
		return applicantname;
	}
	public void setApplicantname(String applicantname) {
		this.applicantname = applicantname;
	}
	public int getApplicantage() {
		return applicantage;
	}
	public void setApplicantage(int applicantage) {
		this.applicantage = applicantage;
	}
	public String getApplicantgender() {
		return applicantgender;
	}
	public void setApplicantgender(String applicantgender) {
		this.applicantgender = applicantgender;
	}
	public String getApplicantaddress() {
		return applicantaddress;
	}
	public void setApplicantaddress(String applicantaddress) {
		this.applicantaddress = applicantaddress;
	}
	public long getApplicantaadharnum() {
		return applicantaadharnum;
	}
	public void setApplicantaadharnum(long applicantaadharnum) {
		this.applicantaadharnum = applicantaadharnum;
	}
	public long getApplicantmobile() {
		return applicantmobile;
	}
	public void setApplicantmobile(long applicantmobile) {
		this.applicantmobile = applicantmobile;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public long getGadharnum() {
		return gadharnum;
	}
	public void setGadharnum(long gadharnum) {
		this.gadharnum = gadharnum;
	}
	public String getGrelation() {
		return grelation;
	}
	public void setGrelation(String grelation) {
		this.grelation = grelation;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public double getExamt() {
		return examt;
	}
	public void setExamt(double examt) {
		this.examt = examt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Loan(int loanId, String applicantname, int applicantage, String applicantgender, String applicantaddress,
			long applicantaadharnum, long applicantmobile, String gname, long gadharnum, String grelation,
			String loanType, double examt, String status) {
		super();
		this.loanId = loanId;
		this.applicantname = applicantname;
		this.applicantage = applicantage;
		this.applicantgender = applicantgender;
		this.applicantaddress = applicantaddress;
		this.applicantaadharnum = applicantaadharnum;
		this.applicantmobile = applicantmobile;
		this.gname = gname;
		this.gadharnum = gadharnum;
		this.grelation = grelation;
		this.loanType = loanType;
		this.examt = examt;
		this.status = status;
	}
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", applicantname=" + applicantname + ", applicantage=" + applicantage
				+ ", applicantgender=" + applicantgender + ", applicantaddress=" + applicantaddress
				+ ", applicantaadharnum=" + applicantaadharnum + ", applicantmobile=" + applicantmobile + ", gname="
				+ gname + ", gadharnum=" + gadharnum + ", grelation=" + grelation + ", loanType=" + loanType
				+ ", examt=" + examt + ", status=" + status + "]";
	}
	

}
