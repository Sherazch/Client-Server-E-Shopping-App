package eshop_Client;

//Sheraz Ahmed (BS-20 B)

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import eshop_server.*;

public class Client_Implementation {
		ArrayList<ProductImplementation> productlist=new ArrayList<>();
		Scanner s=new Scanner(System.in);
		ServiceInterface service;
		private int cus_ID,pro_ID,ord_ID,total=0,count=0;
		CustomerImplementation custom;
		public Client_Implementation(ServiceInterface service){
			this.service=service;
			cus_ID=service.getAllCustomers().size();
			pro_ID=service.getAllProducts().size();
			
		}
		public void setMenu(){
			System.out.println("Please make your choice : ");
			System.out.println("1) Add new Customer");
			System.out.println("2) Add new Product");
			System.out.println("3) Add new Order");
			System.out.println("4) Search Order by ID");
			System.out.println("5) View All Products");
			System.out.println("6) View All Customers");
			System.out.println("7) Exit");
			performAction(s.nextInt()); 
		}
		public void performAction(int num){
			switch(num){
				case 1:
					addCustomer();
					break;
				case 2:
					addProduct();
					break;
				case 3:
					addOrder();
					break;
				case 4:
					searchOrderbyID();
					break;
				case 5:
					viewAllProducts();
					break;
				case 6:
					ViewAllCustomers();
					break;	
				case 7:
					System.exit(0);
				default:
					System.out.println("\n\n\nInvalid command!!!\n\n\n");
			}
			setMenu();
		}
	private void addOrder() {
			System.out.println("\n\n*** Make an Order ***");
			if(count==0){
				System.out.println("1) Choose a product");
				count++;
			}else{
				System.out.println("1) Choose a product");
				System.out.println("2) Checkout");
				System.out.println("3) Cancel the Order");
			}
			
			int choice=s.nextInt();
			if(choice==1){
				viewAllProducts();
				ProductImplementation p=getProduct();
				productlist.add(p);
				addOrder();
			}else if(choice==2){
				ord_ID+=1;
				OrderImplementation order=new OrderImplementation();
				order.setId(ord_ID);
				List<CustomerImplementation> cus=service.getAllCustomers();
				for(CustomerImplementation customer:cus){
					if(customer.getId()==cus_ID){
						custom=customer;
					}
				 }
				order.setCustomer(custom);
				for(ProductImplementation pro:productlist){
					order.setProduct(pro);
					total+=pro.getPrice();
				}
				order.setTotal(total);
				service.addOrder(order);
				productlist.clear();
				count=0;
				total=0;
			}else if(choice==3){
				return;
			}else{
				System.out.println("\n\n\nInvalid Command!!!\n\n\n");
				productlist.clear();
				count=0;
				total=0;
				addOrder();
			}
			
		}
	private void ViewAllCustomers() {
		List<CustomerImplementation> cus=service.getAllCustomers();
		 for(CustomerImplementation p:cus){
			 System.out.println("Customer ID :"+p.getId());
			 System.out.println("Customer Name :"+p.getName()+"\n");
		 }
		}
	private void viewAllProducts() {
		List<ProductImplementation> pro=service.getAllProducts();
		 for(ProductImplementation p:pro){
			 System.out.println("Product ID :"+p.getId());
			 System.out.println("Product Name :"+p.getName());
			 System.out.println("Product Price :"+p.getPrice()+"\n");
		 }
			
		}
	private void searchOrderbyID() {
			System.out.println("\n\n*** Search Order by ID ***");
			System.out.println("\nPlease enter ID : ");
			int id=s.nextInt();
			OrderImplementation order=service.getOrderbyID(id);
			if(order!=null){
				System.out.println("Order ID : "+order.getId());
				System.out.println("Total : "+order.getTotal());
				CustomerImplementation customer=order.getCustomer();
				System.out.println("Placed by : "+customer.getName());
			}
			System.out.println("\n\n\n");
		}
	private void addProduct() {
		System.out.println("\n\n*** Add Product ***");
		System.out.println("\nPlease enter Product Name : ");
		String name=s.next();
		System.out.println("Please enter Product Price : ");
		double price=s.nextDouble();
		pro_ID+=1;
		ProductImplementation product=new ProductImplementation();
		product.setId(pro_ID);
		product.setName(name);
		product.setPrice(price);
		service.addProduct(product);
		System.out.println("\n\n\n");
	}
	private void addCustomer() {
		System.out.println("\n\n*** Add Customer ***");
		System.out.println("Please enter Customer Name : ");
		String name=s.next();
		cus_ID+=1;
		CustomerImplementation customer=new CustomerImplementation();
		customer.setId(cus_ID);
		customer.setName(name);
		service.addCustomer(customer);
		System.out.println("\n\n\n");
	}
	
	
	public ProductImplementation getProduct(){
		System.out.println("Choose a product by ID");
		int id=s.nextInt();
		List<ProductImplementation> pro=service.getAllProducts();
		 for(ProductImplementation p:pro){
			 if(p.getId()==id){
				 return p;
			 }
		 }
		 return null;
	}
	
	public static void main(String[] args) {
		 try{
			 ServiceInterface service=new ServiceImplementationService().getServiceImplementationPort();
			 Client_Implementation c=new Client_Implementation(service);
			 c.setMenu();
		 }catch(Exception e){
			 System.out.println("Server is Down!!!");
		 }
		 
	}
}
