package Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dao.CartDao;
import Helper.Connect;
import Pojo.CartPojo;

public class CartDaoimpl implements CartDao {
	Connection con=Connect.getConnection();
	PreparedStatement ps;
	@Override
	public boolean addCart(CartPojo cartPojo) {
		try {
			String q="insert into cart(pid,pname,price,quantity,email)values(?,?,?,?,?)";
			ps=con.prepareStatement(q);
			ps.setInt(1,cartPojo.getPid());
			ps.setString(2,cartPojo.getPname());
			ps.setInt(3,cartPojo.getPrice());
			ps.setInt(4,cartPojo.getQuantity());
			ps.setString(5,cartPojo.getEmail());
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
	public List<CartPojo> getCartByEmail(String email) {
		List<CartPojo> l=new ArrayList<CartPojo>();
		try {
			String q="select * from cart where email=?";
			ps=con.prepareStatement(q);
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CartPojo c=new CartPojo();
				c.setCid(rs.getInt("cid"));
				c.setPid(rs.getInt("pid"));
				c.setPname(rs.getString("pname"));
				c.setPrice(rs.getInt("price"));
				c.setQuantity(rs.getInt("quantity"));
				c.setTotalprice(rs.getInt("totalprice"));
				l.add(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;
	}
	@Override
	public boolean checkCartByPid(int pid,String email) {
		try {
			String q="select * from cart where pid=? and email=?";
			ps=con.prepareStatement(q);
			ps.setInt(1, pid);
			ps.setString(2,email);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
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
	public int getQuantityByPid(int pid,String email) {
		int quantity=0;
		try {
			String q="select quantity from cart where pid=? and email=?";
			ps=con.prepareStatement(q);
			ps.setInt(1, pid);
			ps.setString(2,email);
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
	@Override
	public boolean updateQuantityByOne( int pid,String email) {
		// TODO Auto-generated method stub
		int newQunatity=getQuantityByPid(pid,email)+1;
		try {
			String q="update cart set quantity=? where pid=? and email=?";
			ps=con.prepareStatement(q);
			ps.setInt(1, newQunatity);
			ps.setInt(2,pid);
			ps.setString(3,email);
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
	public boolean updateCartQuantity(int cid,int quantity) {
		try {
			String q="update cart set quantity=? where cid=?";
			ps=con.prepareStatement(q);
			ps.setInt(1, quantity);
			ps.setInt(2, cid);
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
	public boolean deleteAllCartItem(String email) {
		try {
			String q="delete from cart where email=?";
			ps=con.prepareStatement(q);
			ps.setString(1,email);
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
	public boolean deleteCartById(int cid) {
		try {
			String q="delete from cart where cid=?";
			ps=con.prepareStatement(q);
			ps.setInt(1, cid);
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
	public List<CartPojo> getCartByCid(int cid) {
		List<CartPojo> l=new ArrayList<CartPojo>();
		try {
			String q="select * from cart where cid=?";
			ps=con.prepareStatement(q);
			ps.setInt(1, cid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				CartPojo c=new CartPojo();
				c.setCid(rs.getInt("cid"));
				c.setPid(rs.getInt("pid"));
				c.setPname(rs.getString("pname"));
				c.setPrice(rs.getInt("price"));
				c.setQuantity(rs.getInt("quantity"));
				c.setTotalprice(rs.getInt("totalprice"));
				c.setEmail(rs.getString("email"));
				l.add(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;
	}
	
	
}
