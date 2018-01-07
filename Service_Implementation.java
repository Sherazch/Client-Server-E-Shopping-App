package eshop_Server;

//Sheraz Ahmed (BS-20 B)

import java.util.ArrayList;

import javax.jws.WebService;


@WebService(endpointInterface="eshop_Server.Service_Interface")
public class Service_Implementation implements Service_Interface{
	Customer_Implementation customer;
	Product_Implementation product;
    Order_Implementation order;
    ArrayList<Customer_Implementation> customer_list=new ArrayList<>();
    ArrayList<Product_Implementation> product_list=new ArrayList<>();
    ArrayList<Order_Implementation> order_list=new ArrayList<>();
	@Override
	public Order_Implementation getOrderbyID(int id) {
		if(!this.order_list.isEmpty()){
			for(Order_Implementation order:order_list){
				if(order.getId()==id){
					return order;
				}
			}
		}
			return null;
	}

	@Override
	public ArrayList<Product_Implementation> getAllProducts() {
		if(!this.product_list.isEmpty()){
			return product_list;
		}else{
			return null;
		}
	}

	@Override
	public ArrayList<Customer_Implementation> getAllCustomers() {
		if(!this.customer_list.isEmpty()){
			return customer_list;
		}else{
			return null;
		}
	}

	@Override
	public void addCustomer(Customer_Implementation customer) {
		this.customer=customer;
		this.customer.setId(customer.getId());
		this.customer.setName(customer.getName());
		this.customer_list.add(this.customer);
	}

	@Override
	public void addProduct(Product_Implementation product) {
		this.product=product;
		this.product.setId(product.getId());
		this.product.setName(product.getName());
		this.product.setPrice(product.getPrice());
		this.product_list.add(this.product);
		
	}

	@Override
	public void addOrder(Order_Implementation order) {
		this.order=order;
		this.order.setId(order.getId());
		this.order.setCustomer(order.getCustomer());
		this.order.setProduct(order.getProduct());
		this.order.setTotal(order.getTotal());
		this.order_list.add(this.order);
	}

	@Override
	public ArrayList<Order_Implementation> getAllOrders() {
		if(!this.order_list.isEmpty()){
			return order_list;
		}else{
			return null;
		}
	}



}
