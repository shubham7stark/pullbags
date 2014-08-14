package com.example.pullbags;

public class CustomListItem {

	long id;
	String name;
	String brief;
	int stock;
	Double price;
	String detail;
	String imageurl;
	int qty;
	
	public void setid(long id){
		this.id = id;
	}
	public void setname(String name){
	this.name = name;
	}	
	public void setbrief(String name){
		this.name = brief;
	}	
	public void setstock(int stock){
		this.stock = stock;
	}	
	public void setprice(Double price){
		this.price = price;
	}
	public void setdetail(String detail){
		this.detail = detail;
	}
	public void setqty(int qty){
		this.qty = qty;
	}
	public void setimageurl(String imageurl){
		this.imageurl = imageurl;
	}
	
	    public String getname(){
		return name;
		}
	    public long getid(){
			return id;
		}
		public String getbrief(){
        return brief;
		}
		public int getstock(){
			return stock;
		}
		public Double getprice(){
			return price;
		}
		public String getdetail(){
			return detail;
		}
		public int getqty(){
			return qty;
		}
		public String getimageurl(){
			return imageurl;
		}
}
