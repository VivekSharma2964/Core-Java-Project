package Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dao.ProfileDao;
import Helper.Connect;
import Pojo.ProfilePojo;

public class ProfileDaoimpl implements ProfileDao {
	Connection con=Connect.getConnection();
	PreparedStatement ps;
	@Override
	public boolean addProfile(ProfilePojo profilePojo) {
		try {
			String q="insert into profile(name,contactno,address,email) values(?,?,?,?)";
			ps=con.prepareStatement(q);
			ps.setString(1,profilePojo.getName());
			ps.setString(2,profilePojo.getContactno());
			ps.setString(3,profilePojo.getAddress());
			ps.setString(4,profilePojo.getEmail());
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
	public List<ProfilePojo> showProfile(String email) {
		List<ProfilePojo> l=new ArrayList<ProfilePojo>();
		try {
			String q="select * from profile where email=?";
			ps=con.prepareStatement(q);
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ProfilePojo p=new ProfilePojo();
				p.setPid(rs.getInt("pid"));
				p.setName(rs.getString("name"));
				p.setContactno(rs.getString("contactno"));
				p.setAddress(rs.getString("address"));
				p.setEmail(rs.getString("email"));
				l.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;
	}

}
