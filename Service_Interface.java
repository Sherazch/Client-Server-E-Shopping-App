package eshop_Server;

//Sheraz Ahmed (BS-20 B)

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Service_Interface {
	@WebMethod
	public Order_Implementation getOrderbyID(int id);
	@WebMethod
	public ArrayList<Product_Implementation> getAllProducts();
	@WebMethod
	public ArrayList<Order_Implementation> getAllOrders();
	@WebMethod
	public ArrayList<Customer_Implementation> getAllCustomers();
	@WebMethod
	public void addCustomer(Customer_Implementation customer);
	@WebMethod
	public void addProduct(Product_Implementation product);
	@WebMethod
	public void addOrder(Order_Implementation order);
}
