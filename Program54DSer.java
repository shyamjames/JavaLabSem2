/* Program to implement Serialization and De-Serialization.
--- De-Serialization ---
@Shyam James
Roll no: 54
Date: 07-02-2026
*/

import java.io.*;

class Program54DSer{
    public static void main(String[] args) {
        try {
            // Open the file containing the serialized object
            FileInputStream fin = new FileInputStream("student.txt");
            ObjectInputStream in = new ObjectInputStream(fin);

            // Read the object
            Student s1 = (Student) in.readObject();

            in.close();
            fin.close();

            // Display the object data
            System.out.println("Object deserialized");
            System.out.println("Student ID: " + s1.rollno);
            System.out.println("Student Name: " + s1.name);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
