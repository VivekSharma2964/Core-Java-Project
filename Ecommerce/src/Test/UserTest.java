package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Dao.CartDao;
import Daoimpl.AdminDaoimpl;
import Daoimpl.CartDaoimpl;
import Daoimpl.OrderDaoimpl;
import Daoimpl.ProfileDaoimpl;
import Daoimpl.UserDaoimpl;
import Pojo.CartPojo;
import Pojo.OrderPojo;
import Pojo.ProductPojo;
import Pojo.ProfilePojo;
import Pojo.UserPojo;

public class UserTest {
public static void main(String[] args) throws InterruptedException {
	System.out.println("-------WELCOME---------");
	boolean f=true;
	while(f) {
	System.out.println("1.REGISTER && 2.LOGIN");
	Scanner sc=new Scanner(System.in);
	int choice=sc.nextInt();
	UserDaoimpl uimpl=new UserDaoimpl();
	CartDaoimpl cimpl=new CartDaoimpl();
	ProfileDaoimpl pimpl=new ProfileDaoimpl();
	AdminDaoimpl aimpl=new AdminDaoimpl();
	OrderDaoimpl oimpl=new OrderDaoimpl();
	if(choice==1) {
		System.out.println("-------REGISTER HERE----------");
		System.out.println("ENTER USERNAME");
		String username=sc.next();
		System.out.println("ENTER EMAIL");
		String email=sc.next();
		System.out.println("ENTER PASSWORD");
		String password=sc.next();
	
		UserPojo userPojo=new UserPojo(username, email, password);
	
		if(uimpl.register(userPojo)) {
			System.out.println("Register Successfully!!!!");
		}
		else {
			System.out.println("Something went wrong!!!!");
		}
	}
	else {
		System.out.println("-------LOGIN HERE----------");
		System.out.println("ENTER EMAIL");
		String email=sc.next();
		System.out.println("ENTER PASSWORD");
		String password=sc.next();
		if(uimpl.login(email, password)) {
			System.out.println("please wait...........");
			Thread.sleep(2000);
			System.out.println("Login Successfully!!");
			f=false;
			boolean b=true;
			while(b) {
				System.out.println("1.ADD PROFILE");
				System.out.println("2.SHOW PROFILE");
				System.out.println("3.UPDATE PROFILE");
				System.out.println("4.DELETE PROFILE");
			System.out.println("5.GET ALL PRODUCT LIST");
			System.out.println("6.ADD TO CART");
			System.out.println("7.SHOW CART");
			System.out.println("8.UPDATE CART");
			System.out.println("9.DELETE CART");
			System.out.println("10.PLACE ORDER");
			System.out.println("11.ORDER SUMMARY");
			System.out.println("12.LOGOUT");
			int choice1=sc.nextInt();
			switch(choice1) {
			case 1:
				System.out.println("-------------ADD PROFILE-------------");
				System.out.println("ENTER NAME");
				String name=sc.next();
				System.out.println("ENTER CONTACT NO");
				String cno=sc.next();
				System.out.println("ENTER ADDRESS");
				String address=sc.next();
				ProfilePojo profilePojo=new ProfilePojo(name, cno, address, email);
				if(pimpl.addProfile(profilePojo)) {
					System.out.println("PROFILE ADDED SUCCESSFULLY!!");
				}
				else {
					System.out.println("PROFILE NOT ADDED!!");
				}
				break;
			case 2:
				List<ProfilePojo> lp=pimpl.showProfile(email);
				for(ProfilePojo p:lp) {
					System.out.println(p);
				}
				break;
			case 5:
				List<ProductPojo> li=uimpl.getAllProductList();
				for(ProductPojo p:li) {
					System.out.println(p);
				}
				break;
			case 6:
				System.out.println("------------PRODUCT LIST----------");
				List<ProductPojo> li1=uimpl.getAllProductList();
				for(ProductPojo p:li1) {
					System.out.println(p);
				}
				System.out.println("-----------------------------------");
				
				System.out.println("ENTER PRODUCT ID WHOSE YOU WANT TO ADD TO CART");
				int pid=sc.nextInt();
				List<ProductPojo> l=uimpl.getAllProductListById(pid);
				CartPojo cartPojo=new CartPojo();
				for(ProductPojo p:l) {
					cartPojo.setPid(p.getPid());
					cartPojo.setPname(p.getName());
					cartPojo.setPrice(p.getActualprice());
					cartPojo.setQuantity(1);
					cartPojo.setEmail(email);
				}
				//System.out.println(cimpl.checkCartByPid(pid));
				if(cimpl.checkCartByPid(pid,email)) {
					if(cimpl.updateQuantityByOne(pid,email)) {
						System.out.println("quantity is increased!!");
					}
					else {
						System.out.println("something went wrong!!");
					}
				}
				else {
					if(cimpl.addCart(cartPojo)) {
						System.out.println("ADD TO CART SUCCESSFULLY!!");
					}
					else {
						System.out.println("SOMETHING WENT WRONG!!");
					}
				}
				
				
				break;
			case 7:
			List<CartPojo> lc=	cimpl.getCartByEmail(email);
			if(lc.isEmpty()) {
				System.out.println("YOUR CART IS EMPTY!!");
			}
			else {
			System.out.println("--------------YOUR CART--------------");
			for(CartPojo c:lc) {
				System.out.println(c);
			}
			}
				break;
			case 8:
				List<CartPojo> lc1=	cimpl.getCartByEmail(email);
				if(lc1.isEmpty()) {
					System.out.println("YOUR CART IS EMPTY!!");
				}
				else {
				System.out.println("--------------YOUR CART--------------");
				for(CartPojo c:lc1) {
					System.out.println(c);
				}
				}
				System.out.println("UPDATE CART QUANTITY");
				System.out.println("ENTER CART ID WHOSE YOU WANT TO UPDATE QUANTITY");
				int cid=sc.nextInt();
				System.out.println("ENTER NEW QUANTITY");
				int quantity=sc.nextInt();
				if(cimpl.updateCartQuantity(cid, quantity)) {
					System.out.println("quantity updated");
				}
				else {
					System.out.println("quantity not updated");
				}
				
				break;
			case 9:
				System.out.println("1.DELETE ALL CART ITEM");
				System.out.println("2.DELETE PARTICULAR CART ITEM");
				int c=sc.nextInt();
				if(c==1) {
					System.out.println("ARE YOU SURE WANT TO DELETE ALL CART ITEM");
					System.out.println("PLEASE ENETER YES OR NO");
					String ans=sc.next();
					if(ans.trim().equalsIgnoreCase("yes")) {
					if(cimpl.deleteAllCartItem(email)) {
						System.out.println("DELETE SUCCESSFULLY!!");
					}
					else {
						System.out.println("DELETE UNSUCCESSFULLY!!");
					}}
					else {
						System.out.println("CONTINUE SHOPPING......");
					}
				}
				else {
					List<CartPojo> lc2=	cimpl.getCartByEmail(email);
					if(lc2.isEmpty()) {
						System.out.println("YOUR CART IS EMPTY!!");
					}
					else {
					System.out.println("--------------YOUR CART--------------");
					for(CartPojo c1:lc2) {
						System.out.println(c1);
					}
					}
					System.out.println("ENTER CART ID WHOSE YOU WANT TO BE DELETE");
					int cid1=sc.nextInt();
					if(cimpl.deleteCartById(cid1)) {
						System.out.println("deleted succesfully!!");
					}
					else {
						System.out.println("DELETED UNSUCCESSFULLY!!");
					}
				}
				break;
			case 10:
				List<CartPojo> lc2=	cimpl.getCartByEmail(email);
				if(lc2.isEmpty()) {
					System.out.println("YOUR CART IS EMPTY!!");
				}
				else {
				System.out.println("--------------YOUR CART--------------");
				for(CartPojo c1:lc2) {
					System.out.println(c1);
				}
				}
				System.out.println("Are you sure want to palce order yes or no?");
				String ans=sc.next();
				if(ans.trim().equalsIgnoreCase("yes")) {
					System.out.println("Enter Cart Id");
					int cid1=sc.nextInt();
					List<CartPojo>lc3=cimpl.getCartByCid(cid1);
					String pname=lc3.get(0).getPname();
					int tprice=lc3.get(0).getTotalprice();
					int pid1=lc3.get(0).getPid();
					int cquantity=lc3.get(0).getQuantity();
					String cemail=lc3.get(0).getEmail();
					int pquantity=aimpl.getQuantityByPid(pid1);
					List<ProfilePojo> lp1=pimpl.showProfile(cemail);
					
				
				
				if(cquantity<=pquantity && !lp1.isEmpty() ) {
					String name1=lp1.get(0).getName();
					String cono=lp1.get(0).getContactno();
					String add=lp1.get(0).getAddress();
					OrderPojo orderPojo=new OrderPojo();
					orderPojo.setPname(pname);
					orderPojo.setQuantity(cquantity);
					orderPojo.setPrice(tprice);
					orderPojo.setEmail(cemail);
					orderPojo.setName(name1);
					orderPojo.setAddress(add);
					orderPojo.setContactno(cono);
					System.out.println("Select Payment type...");
					System.out.println("1.GPay");
					System.out.println("2.COD");
					int ptype=sc.nextInt();
					if(ptype==1) {
						System.out.println("please Enter "+tprice+" rs");
						String amount=sc.next();
						if(tprice==Integer.parseInt(amount.trim())) {
							
						
					if(oimpl.placeOrder(orderPojo)) {
						System.out.println("Orders Placed Successfully!!");
						cimpl.deleteCartById(cid1);
					}
					else {
						System.out.println("Order not placed!!");
					}
				}
				}
					else {
						if(oimpl.placeOrder(orderPojo)) {
							System.out.println("Orders Placed Successfully!!");
							cimpl.deleteCartById(cid1);
						}
						else {
							System.out.println("Order not placed!!");
						}
					}
				}
				else {
					System.out.println("you can't place order right now!!");
				}
				}
				
				else {
					System.out.println("Go and Keep Shoping......");
				}
				break;
			case 11:
				System.out.println("------------ORDER SUMMARY-------------");
				System.out.println();
			List<OrderPojo> lo=	oimpl.seeOrderDetails(email);
			for(OrderPojo o:lo) {
				System.out.println(o);
			}
			System.out.println();
				break;
			case 12:
				System.out.println("Are you Sure Want to Logout?");
				System.out.println("please enter yes or no");
				String choice2=sc.next();
				if(choice2.trim().equalsIgnoreCase("yes")) {
					System.out.println("Logout Successfully!!");
					f=true;
					b=false;
				}
				else {
					
				}
				break;
			
			}
		
		}
		}
		else {
			System.out.println("Login Unsuccessfully!!");
		}
	}
		
	}
	}
	
}
