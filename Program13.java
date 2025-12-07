/* Program for String operations: Read, Display, Compare, Add, and Concatenate.
@Shyam James
Roll no: 54
Date: 02-12-2025
*/
import java.util.*;

class CString {
    String str;

    public void read() {
        Scanner s = new Scanner(System.in);
        str = s.nextLine();
    }

    public void display() {
        System.out.println(str);
    }

    public boolean compare(CString s) {
        return str.equals(s.str);
    }

    public void add(CString s) {
        System.out.println("Addition Result:");
        System.out.println(str + s.str);
    }

    public void concat(CString obj) {
        System.out.println("Concatenation Result:");
        str = str + obj.str;
        display();
    }
}

public class Program13 {
    public static void main(String args[]) {
        CString a = new CString();
        CString b = new CString();

        System.out.println("Enter a string:");
        a.read();
        System.out.println("Enter another string:");
        b.read();

        System.out.println("First String:");
        a.display();
        System.out.println("Second String:");
        b.display();

        System.out.println("Comparison Result: " + a.compare(b));
        a.add(b);
        a.concat(b);
    }
}
