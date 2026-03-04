/* Program to De-Serialize selected attributes of an object using Transient keyword.
@Shyam James
Roll no: 54
Date: 09-02-2026
*/

import java.io.*;
import java.util.Scanner;

class Employee implements Serializable {
	int id;
	String name;
	transient int age;

	Employee(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
}

class Program57 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter id: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.print("Enter age: ");
		int age = sc.nextInt();

		Employee e1 = new Employee(id, name, age);
		System.out.println("\nBefore serialization -> id: " + e1.id + ", name: " + e1.name + ", age: " + e1.age);

		FileOutputStream fos = new FileOutputStream("emp57.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(e1);
		oos.close();
		fos.close();

		FileInputStream fis = new FileInputStream("emp57.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Employee e2 = (Employee) ois.readObject();
		ois.close();
		fis.close();

		System.out.println("After deserialization  -> id: " + e2.id + ", name: " + e2.name + ", age: " + e2.age);

		sc.close();
	}
}
