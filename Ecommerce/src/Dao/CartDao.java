package Dao;

import java.util.List;

import Pojo.CartPojo;

public interface CartDao {
public boolean addCart(CartPojo cartPojo);
public List<CartPojo> getCartByEmail(String email);
public boolean checkCartByPid(int pid,String email);
public int getQuantityByPid(int pid,String email);
public boolean updateQuantityByOne(int pid,String email);
public boolean updateCartQuantity(int cid,int quantity);
public boolean deleteAllCartItem(String email);
public boolean deleteCartById(int cid);
public List<CartPojo> getCartByCid(int cid);

}
