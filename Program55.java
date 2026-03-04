/* Program to implement IS A Serialization and De-Serialization.
@Shyam James
Roll no: 54
Date: 07-02-2026
*/

import java.io.*;
import java.util.Scanner;

//parent class
class Person implements Serializable {
	String name;
	int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

//child class (IS A relationship)
class Student extends Person {
	int rollno;
	String course;
	
	Student(String name, int age, int rollno, String course) {
		super(name, age);
		this.rollno = rollno;
		this.course = course;
	}
	
	void display() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Roll No: " + rollno);
		System.out.println("Course: " + course);
	}
}

class Program55 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.print("Enter age: ");
		int age = sc.nextInt();
		System.out.print("Enter roll no: ");
		int rollno = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter course: ");
		String course = sc.nextLine();
		
		Student s1 = new Student(name, age, rollno, course);
		
		//serialization
		FileOutputStream fos = new FileOutputStream("student.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.close();
		fos.close();
		System.out.println("\nSerialization successful!");
		
		//de-serialization
		FileInputStream fis = new FileInputStream("student.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student s2 = (Student) ois.readObject();
		ois.close();
		fis.close();
		System.out.println("\nDe-serialization successful!");
		
		System.out.println("\nDe-serialized Student Details:");
		s2.display();
		
		sc.close();
	}
}
