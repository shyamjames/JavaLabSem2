/* Program to implement HAS A Serialization and De-Serialization.
@Shyam James
Roll no: 54
Date: 07-02-2026
*/

import java.io.*;
import java.util.Scanner;

class Address implements Serializable {
	String street;
	String city;
	int pincode;
	
	Address(String street, String city, int pincode) {
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}
}

class Employee implements Serializable {
	String name;
	int empid;
	Address address;
	
	Employee(String name, int empid, Address address) {
		this.name = name;
		this.empid = empid;
		this.address = address;
	}
	
	void display() {
		System.out.println("Name: " + name);
		System.out.println("Emp ID: " + empid);
		System.out.println("Street: " + address.street);
		System.out.println("City: " + address.city);
		System.out.println("Pincode: " + address.pincode);
	}
}

class Program56 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.print("Enter emp id: ");
		int empid = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter street: ");
		String street = sc.nextLine();
		System.out.print("Enter city: ");
		String city = sc.nextLine();
		System.out.print("Enter pincode: ");
		int pincode = sc.nextInt();
		
		Address addr = new Address(street, city, pincode);
		Employee e1 = new Employee(name, empid, addr);
		
		FileOutputStream fos = new FileOutputStream("employee.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(e1);
		oos.close();
		fos.close();
		System.out.println("\nSerialization successful!");
		
		FileInputStream fis = new FileInputStream("employee.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Employee e2 = (Employee) ois.readObject();
		ois.close();
		fis.close();
		System.out.println("\nDe-serialization successful!");
		
		System.out.println("\nDe-serialized Employee Details:");
		e2.display();
		
		sc.close();
	}
}
