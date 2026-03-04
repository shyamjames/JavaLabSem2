import java.io.*;
class Student implements Serializable
{
    int rollno;
    String name;
    Student(int rollno,String name)
    {
        this.rollno=rollno;
        this.name=name;
    }
    public void disp(){
        System.out.println("Rollno:"+rollno);
        System.out.println("Name:"+name);
    }
}  