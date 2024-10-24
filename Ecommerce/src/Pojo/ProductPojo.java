package Pojo;

public class ProductPojo {
private int pid;
private String name;
private String desc;
private int price;
private int discount;
private int actualprice;
private int quantity;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getDiscount() {
	return discount;
}
public void setDiscount(int discount) {
	this.discount = discount;
}
public int getActualprice() {
	return actualprice;
}
public void setActualprice(int actualprice) {
	this.actualprice = actualprice;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public ProductPojo( String name, String desc, int price, int discount, int actualprice, int quantity) {
	super();

	this.name = name;
	this.desc = desc;
	this.price = price;
	this.discount = discount;
	this.actualprice = actualprice;
	this.quantity = quantity;
}
public ProductPojo() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "ProductPojo [pid=" + pid + ", name=" + name + ", desc=" + desc + ", price=" + price + ", discount="
			+ discount + ", actualprice=" + actualprice + ", quantity=" + quantity + "]";
}




}
