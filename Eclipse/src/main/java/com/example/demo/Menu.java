package com.example.demo;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {
	 private int mid;
	    private String mitem;
	    private double mprice;
	    private int mcalories;
	    private String mspeciality;
	    
	    @Id
		public int getMid() {
			return mid;
		}
		public void setMid(int mid) {
			this.mid = mid;
		}
		public String getMitem() {
			return mitem;
		}
		public void setMitem(String mitem) {
			this.mitem = mitem;
		}
		public double getMprice() {
			return mprice;
		}
		public void setMprice(double mprice) {
			this.mprice = mprice;
		}
		public int getMcalories() {
			return mcalories;
		}
		public void setMcalories(int mcalories) {
			this.mcalories = mcalories;
		}
		public String getMspeciality() {
			return mspeciality;
		}
		public void setMspeciality(String mspeciality) {
			this.mspeciality = mspeciality;
		}
	    
	    
}
