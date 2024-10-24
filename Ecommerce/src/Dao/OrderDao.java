package Dao;

import java.util.List;

import Pojo.OrderPojo;

public interface OrderDao {
public boolean placeOrder(OrderPojo orderPojo);
public List<OrderPojo> seeOrderDetails(String email);
}
