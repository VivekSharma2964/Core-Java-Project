package Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dao.AdminDao;
import Helper.Connect;
import Pojo.ProductPojo;
import Pojo.UserPojo;

public class AdminDaoimpl implements AdminDao{
	Connection  con=Connect.getConnection();
	PreparedStatement ps;
	@Override
	public boolean adminLogin(String email, String password) {
		try {
			String q="select * from admin where email=? and password=?";
			ps=con.prepareStatement(q);
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public boolean deleteUser(int id) {
		try {
			String q="delete from Register where id=?";
			ps=con.prepareStatement(q);
			ps.setInt(1, id);
			int x=ps.executeUpdate();
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<UserPojo> getAllUser() {
		List<UserPojo> l=new ArrayList<UserPojo>();
		try {
			String q="select * from Register";
			ps=con.prepareStatement(q);
			ResultSet r=ps.executeQuery();
			while(r.next()) {
				UserPojo userPojo=new UserPojo();
				userPojo.setId(r.getInt("id"));
				userPojo.setUsername(r.getString("username"));
				userPojo.setEmail(r.getString("email"));
				userPojo.setPassword(r.getString("password"));
				l.add(userPojo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;
	}
	@Override
	public boolean addProduct(ProductPojo productPojo) {
		try {
			String q="insert into product(name,description,price,discount,quantity) values(?,?,?,?,?)";
			ps=con.prepareStatement(q);
			ps.setString(1,productPojo.getName());
			ps.setString(2,productPojo.getDesc());
			ps.setInt(3,productPojo.getPrice());
			ps.setInt(4,productPojo.getDiscount());
			ps.setInt(5,productPojo.getQuantity());
			int x=ps.executeUpdate();
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public int getQuantityByPid(int pid) {
		int quantity=0;
		try {
			String q="select quantity from product where pid=?";
			ps=con.prepareStatement(q);
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				quantity=rs.getInt("quantity");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return quantity;
	}

}
