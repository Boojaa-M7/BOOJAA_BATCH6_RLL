package com.example.demo;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity	
public class Orders {
	private int oid;
	private int ocid;
	private int ovid;
	private String wal_source;
	private int omid;
	private Date ord_date;
	private int ord_quantity;
	private int ord_billamount;
	private String ord_status;
	private String ord_comments;
	@Id
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getOcid() {
		return ocid;
	}
	public void setOcid(int ocid) {
		this.ocid = ocid;
	}
	public int getOvid() {
		return ovid;
	}
	public void setOvid(int ovid) {
		this.ovid = ovid;
	}
	public String getWal_source() {
		return wal_source;
	}
	public void setWal_source(String wal_source) {
		this.wal_source = wal_source;
	}
	public int getOmid() {
		return omid;
	}
	public void setOmid(int omid) {
		this.omid = omid;
	}
	public Date getOrd_date() {
		return ord_date;
	}
	public void setOrd_date(Date ord_date) {
		this.ord_date = ord_date;
	}
	public int getOrd_quantity() {
		return ord_quantity;
	}
	public void setOrd_quantity(int ord_quantity) {
		this.ord_quantity = ord_quantity;
	}
	public int getOrd_billamount() {
		return ord_billamount;
	}
	public void setOrd_billamount(int ord_billamount) {
		this.ord_billamount = ord_billamount;
	}
	public String getOrd_status() {
		return ord_status;
	}
	public void setOrd_status(String ord_status) {
		this.ord_status = ord_status;
	}
	public String getOrd_comments() {
		return ord_comments;
	}
	public void setOrd_comments(String ord_comments) {
		this.ord_comments = ord_comments;
	}
	
}
