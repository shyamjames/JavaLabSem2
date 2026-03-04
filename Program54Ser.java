/* Program to implement Serialization and De-Serialization.
--- Serialization ---
@Shyam James
Roll no: 54
Date: 07-02-2026
*/

import java.io.*;

class Program54Ser{
    public static void main(String args[]){
        try{
            Student s1=new Student(100,"abcd");

            FileOutputStream fout=new FileOutputStream("student.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout);

            out.writeObject(s1);
            out.flush();
            out.close();

            System.out.println("Object serialized");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
