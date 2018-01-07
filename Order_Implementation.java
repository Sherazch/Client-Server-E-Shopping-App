package eshop_Server;

//Sheraz Ahmed (BS-20 B)


import java.util.ArrayList;

public class Order_Implementation {
	int id;
	double total;
	Customer_Implementation customer;
	ArrayList<Product_Implementation> product=new ArrayList<Product_Implementation>();
	Product_Implementation pro;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Customer_Implementation getCustomer() {
		return customer;
	}

	public void setCustomer(Customer_Implementation customer) {
		this.customer = customer;
	}

	public void setProduct(Product_Implementation product) {
		pro=product;
		this.product.add(pro);
	}

	public void purcaseProduct(Product_Implementation product){
		
	}
	
	public void removeProduct(Product_Implementation product){
		
	}
	
	public ArrayList<Product_Implementation> getAllProduct(){
		if(!this.product.isEmpty())
			return this.product;
		return null;
	}
	
	public Product_Implementation getProduct(){
		return this.pro;
	}
}

