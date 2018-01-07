package eshop_Server;

//Sheraz Ahmed (BS-20 B)

import javax.xml.ws.Endpoint;

public class Publisher_Implementation {
	public static void main(String[] args) {
		try{
			Endpoint service=Endpoint.publish("http://localhost:8080/EShoppingService", new Service_Implementation());
			System.out.println("Service has been Published");
		}catch(Exception e){
			System.out.println("Server is not UP!!!");
		}
		
	}
}
