package Pojo;

public class CartPojo {
private int cid;
private int pid;
private String pname;
private int price;
private int quantity;
private int totalprice;
private String email;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getTotalprice() {
	return totalprice;
}
public void setTotalprice(int totalprice) {
	this.totalprice = totalprice;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public CartPojo(int pid, String pname, int price, int quantity, int totalprice, String email) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.price = price;
	this.quantity = quantity;
	this.totalprice = totalprice;
	this.email = email;
}
public CartPojo() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "CartPojo [cid=" + cid + ", pid=" + pid + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity
			+ ", totalprice=" + totalprice + "]";
}



}
