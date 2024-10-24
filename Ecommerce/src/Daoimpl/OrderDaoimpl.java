package Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dao.OrderDao;
import Helper.Connect;
import Pojo.OrderPojo;

public class OrderDaoimpl implements OrderDao{
	Connection con=Connect.getConnection();
	PreparedStatement ps;
	@Override
	public boolean placeOrder(OrderPojo orderPojo) {
		try {
			String q="insert into orders(pname,quantity,price,email,name,contactno,address,ddate,ostatus)values(?,?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(q);
			ps.setString(1,orderPojo.getPname());
			ps.setInt(2,orderPojo.getQuantity());
			ps.setInt(3,orderPojo.getPrice());
			ps.setString(4,orderPojo.getEmail());
			ps.setString(5,orderPojo.getName());
			ps.setString(6,orderPojo.getContactno());
			ps.setString(7,orderPojo.getAddress());
			ps.setString(8,orderPojo.getDelivery_date());
			ps.setString(9,"pending");
			
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
	public List<OrderPojo> seeOrderDetails(String email) {
		List<OrderPojo> l=new ArrayList<OrderPojo>();
		try {
			String q="select * from orders where email=?";
			ps=con.prepareStatement(q);
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				OrderPojo orderPojo=new OrderPojo();
				orderPojo.setOid(rs.getInt("oid"));
				orderPojo.setPname(rs.getString("pname"));
				orderPojo.setQuantity(rs.getInt("quantity"));
				orderPojo.setPrice(rs.getInt("price"));
				orderPojo.setEmail(rs.getString("email"));
				orderPojo.setName(rs.getString("name"));
				orderPojo.setContactno(rs.getString("contactno"));
				orderPojo.setAddress(rs.getString("address"));
				orderPojo.setOrder_date(rs.getString("odate"));
				orderPojo.setDelivery_date(rs.getString("ddate"));
				orderPojo.setOrder_status(rs.getString("ostatus"));
				l.add(orderPojo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;
	}

}
