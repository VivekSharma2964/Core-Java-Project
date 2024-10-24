package Dao;

import java.util.List;

import Pojo.ProductPojo;
import Pojo.UserPojo;

public interface UserDao {
public boolean register(UserPojo userPojo); 
public boolean login(String email,String password);
public List<ProductPojo> getAllProductList();
public List<ProductPojo> getAllProductListById(int pid);
	

}
