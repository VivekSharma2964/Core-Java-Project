package Test;

import java.util.List;
import java.util.Scanner;

import Daoimpl.AdminDaoimpl;
import Daoimpl.UserDaoimpl;
import Pojo.ProductPojo;
import Pojo.UserPojo;

public class AdminTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------WELCOME ADMIN PAGE------");
		System.out.println("ADMIN LOGIN");
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER EMAIL");
		String email=sc.next();
		System.out.println("ENTER PASSWORD");
		String password=sc.next();
		
		AdminDaoimpl aimpl=new AdminDaoimpl();
		UserDaoimpl uimpl=new UserDaoimpl();
		if(aimpl.adminLogin(email, password)) {
			System.out.println("LOGIN SUCCESSFULLY!!!");
			boolean f=true;
			while(f) {
			System.out.println("1.ADD USER");
			System.out.println("2.DELETE USER");
			System.out.println("3.GET ALL USER LIST");
			System.out.println("4.ADD PRODUCT");
			System.out.println("5.GET ALL PRODUCT List");
			System.out.println("6.LOGOUT");

			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("ENTER USERNAME");
				String username=sc.next();
				System.out.println("ENTER EMAIL");
				String email1=sc.next();
				System.out.println("ENTER PASSWORD");
				String password1=sc.next();
				
				UserPojo userPojo =new UserPojo(username, email1, password1);
				if(uimpl.register(userPojo)) {
					System.out.println("USER ADDED SUCCESSFULLY!!");
				}
				else {
					System.out.println("USER NOT ADDED!!");
				}
				
				break;
			case 2:
				System.out.println("------------USER LIST-------------");
				List<UserPojo>l=aimpl.getAllUser();
				for(UserPojo u:l) {
					System.out.println(u);
				}
				System.out.println();
				System.out.println();
				System.out.println("ENTER THE USER ID WHOSE YOU WANT TO DELETE");
				int id=sc.nextInt();
				if(aimpl.deleteUser(id)) {
					System.out.println("USER DELETED SUCCESSFULLY!!");
				}
				else {
					System.out.println("USER NOT DELETED!!");
				}
				break;
			case 3:
				System.out.println("------------USER LIST-------------");
			List<UserPojo>l1=aimpl.getAllUser();
			for(UserPojo u:l1) {
				System.out.println(u);
			}
				break;
			case 4:
				System.out.println("ADD PRODUCT");
				System.out.println("ENTER NAME");
				String name=sc.next();
				System.out.println("ENTER DESCRIPTION");
				String desc=sc.next();
				System.out.println("ENTER PRICE");
				int price=sc.nextInt();
				System.out.println("ENTER DISCOUNT");
				int discount=sc.nextInt();
				System.out.println("ENTER QUANTITY");
				int quantity=sc.nextInt();
				ProductPojo productPojo=new ProductPojo(name, desc, price, discount, price, quantity);
				if(aimpl.addProduct(productPojo)) {
					System.out.println("PRODUCTS ADDED SUCCESSFULLY!!");
				}
				else {
					System.out.println("PRODUCT NOT ADDED");
				}
				
				break;
			case 5:
				System.out.println("------------PRODUCT LIST-------------");
				List<ProductPojo> li=uimpl.getAllProductList();
				for(ProductPojo p:li) {
					System.out.println(p);
				}
				break;
			case 6:
				System.out.println("Are you Sure Want to Logout?");
				System.out.println("please enter yes or no");
				String choice2=sc.next();
				if(choice2.trim().equalsIgnoreCase("yes")) {
					System.out.println("Logout Successfully!!");
					f=false;
				}
				else {
					
				}
				break;
			}
			}
			
			
			
			
		}
		else {
			System.out.println("SOMETHING WENT WRONG!!");
		}
	}

}
