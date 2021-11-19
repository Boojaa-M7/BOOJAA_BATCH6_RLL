package com.example.demo;
import javax.persistence.Entity;

import javax.persistence.Id;
@Entity
public class Wallet {
	private int CUS_ID;
	private int WAL_ID;
	private int WAL_AMOUNT;
	private String WAL_SOURCE;
	@Id
	public int getCUS_ID() {
		return CUS_ID;
	}
	public void setCUS_ID(int cUS_ID) {
		CUS_ID = cUS_ID;
	}
	public int getWAL_ID() {
		return WAL_ID;
	}
	public void setWAL_ID(int wAL_ID) {
		WAL_ID = wAL_ID;
	}
	public int getWAL_AMOUNT() {
		return WAL_AMOUNT;
	}
	public void setWAL_AMOUNT(int wAL_AMOUNT) {
		WAL_AMOUNT = wAL_AMOUNT;
	}
	public String getWAL_SOURCE() {
		return WAL_SOURCE;
	}
	public void setWAL_SOURCE(String wAL_SOURCE) {
		WAL_SOURCE = wAL_SOURCE;
	}

	
}
