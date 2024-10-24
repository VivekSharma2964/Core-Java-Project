package Pojo;

public class ProfilePojo {
private int pid;
private String name;
private String contactno;
private String address;
private String email;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public ProfilePojo(String name, String contactno, String address, String email) {
	super();
	this.name = name;
	this.contactno = contactno;
	this.address = address;
	this.email = email;
}
public ProfilePojo() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "ProfilePojo [pid=" + pid + ", name=" + name + ", contactno=" + contactno + ", address=" + address
			+ ", email=" + email + "]";
}

}
