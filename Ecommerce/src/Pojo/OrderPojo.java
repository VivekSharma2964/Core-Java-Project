package Pojo;

public class OrderPojo {
private int oid;
private String pname;
private int quantity;
private int price;
private String email;
private String name;
private String contactno;
private String address;
private String order_date;
private String delivery_date;
private String order_status;
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getContactno() {
	return contactno;
}
public void setContactno(String contactno) {
	this.contactno = contactno;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getOrder_date() {
	return order_date;
}
public void setOrder_date(String order_date) {
	this.order_date = order_date;
}
public String getDelivery_date() {
	return delivery_date;
}
public void setDelivery_date(String delivery_date) {
	this.delivery_date = delivery_date;
}
public String getOrder_status() {
	return order_status;
}
public void setOrder_status(String order_status) {
	this.order_status = order_status;
}
public OrderPojo(String pname, int quantity, int price, String email, String name, String contactno, String address,
		String order_status) {
	super();
	this.pname = pname;
	this.quantity = quantity;
	this.price = price;
	this.email = email;
	this.name = name;
	this.contactno = contactno;
	this.address = address;
	this.order_status = order_status;
}
public OrderPojo() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "OrderPojo [oid=" + oid + ", pname=" + pname + ", quantity=" + quantity + ", price=" + price + ", email="
			+ email + ", name=" + name + ", contactno=" + contactno + ", address=" + address + ", order_date="
			+ order_date + ", delivery_date=" + delivery_date + ", order_status=" + order_status + "]";
}


}
