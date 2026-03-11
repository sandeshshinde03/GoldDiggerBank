package com.BWA.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int cid;
		private String cname;
		private String cemail;
		private String cpass;
		private String role;
		private String cgender;
		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Customer(int cid, String cname, String cemail, String cpass, String role, String cgender) {
			super();
			this.cid = cid;
			this.cname = cname;
			this.cemail = cemail;
			this.cpass = cpass;
			this.role = role;
			this.cgender = cgender;
		}
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		public String getCemail() {
			return cemail;
		}
		public void setCemail(String cemail) {
			this.cemail = cemail;
		}
		public String getCpass() {
			return cpass;
		}
		public void setCpass(String cpass) {
			this.cpass = cpass;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public String getCgender() {
			return cgender;
		}
		public void setCgender(String cgender) {
			this.cgender = cgender;
		}
		@Override
		public String toString() {
			return "Customer [cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + ", cpass=" + cpass + ", role="
					+ role + ", cgender=" + cgender + "]";
		}
		
		
}
