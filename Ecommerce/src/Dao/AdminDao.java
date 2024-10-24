package Dao;

import java.util.List;

import Pojo.ProductPojo;
import Pojo.UserPojo;

public interface AdminDao {
public boolean adminLogin(String email,String password);
public boolean deleteUser(int id);
public List<UserPojo> getAllUser();
public boolean addProduct(ProductPojo productPojo);
public int getQuantityByPid(int pid);

}
