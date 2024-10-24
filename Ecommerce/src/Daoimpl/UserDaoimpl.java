package Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dao.UserDao;
import Helper.Connect;
import Pojo.ProductPojo;
import Pojo.UserPojo;

public class UserDaoimpl implements UserDao{
	Connection con=Connect.getConnection();
	PreparedStatement ps;
	@Override
	public boolean register(UserPojo userPojo) {
		try {
			String q="insert into Register(username,email,password) values(?,?,?)";
			ps=con.prepareStatement(q);
			ps.setString(1,userPojo.getUsername());
			ps.setString(2,userPojo.getEmail());
			ps.setString(3,userPojo.getPassword());
		int x=	ps.executeUpdate();
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
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		try {
			String q="select * from Register where email=? and password=?";
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
	public List<ProductPojo> getAllProductList() {
		List<ProductPojo> l=new ArrayList<ProductPojo>();
		try {
			String q="select * from product";
			ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ProductPojo productPojo=new ProductPojo();
				productPojo.setPid(rs.getInt("pid"));
				productPojo.setName(rs.getString("name"));
				productPojo.setDesc(rs.getString("description"));
				productPojo.setPrice(rs.getInt("price"));
				productPojo.setDiscount(rs.getInt("discount"));
				productPojo.setActualprice(rs.getInt("actualprice"));
				productPojo.setQuantity(rs.getInt("quantity"));
				l.add(productPojo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;
	}
	@Override
	public List<ProductPojo> getAllProductListById(int pid) {
		List<ProductPojo> l=new ArrayList<ProductPojo>();
		try {
			String q="select * from product where pid=?";
			ps=con.prepareStatement(q);
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ProductPojo productPojo=new ProductPojo();
				productPojo.setPid(rs.getInt("pid"));
				productPojo.setName(rs.getString("name"));
				productPojo.setDesc(rs.getString("description"));
				productPojo.setPrice(rs.getInt("price"));
				productPojo.setDiscount(rs.getInt("discount"));
				productPojo.setActualprice(rs.getInt("actualprice"));
				productPojo.setQuantity(rs.getInt("quantity"));
				l.add(productPojo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;
	}

}
