package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendor {
	private int vid;
	private String vname;
	private String vphno;
	private String vusername;
	private String vpassword;
	private String vemail;
	@Id
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVphno() {
		return vphno;
	}
	public void setVphno(String vphno) {
		this.vphno = vphno;
	}
	public String getVusername() {
		return vusername;
	}
	public void setVusername(String vusername) {
		this.vusername = vusername;
	}
	public String getVpassword() {
		return vpassword;
	}
	public void setVpassword(String vpassword) {
		this.vpassword = vpassword;
	}
	public String getVemail() {
		return vemail;
	}
	public void setVemail(String vemail) {
		this.vemail = vemail;
	}

}
