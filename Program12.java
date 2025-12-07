/* Create a class complex having real and imaginary as data members and provide function for read, display, add and multiply.
@Shyam James
Roll no: 54
Date: 01-12-2025
*/
import java.util.*;

class Complex {
    private int real;
    private int imag;

    public void read() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter real part: ");
        real = s.nextInt();
        System.out.print("Enter imaginary part: ");
        imag = s.nextInt();
    }

    public void display() {
        if(imag >= 0)
            System.out.println(real + "+" + imag + "i");
        else
            System.out.println(real + "" + imag + "i");
    }

    public Complex add(Complex c) {
        Complex result = new Complex();
        result.real = this.real + c.real;
        result.imag = this.imag + c.imag;
        return result;
    }

    public Complex multiply(Complex c) {
        Complex result = new Complex();
        result.real = this.real * c.real - this.imag * c.imag;
        result.imag = this.real * c.imag + this.imag * c.real;
        return result;
    }
}

public class Program12 {
    public static void main(String[] args) {
        Complex c1 = new Complex();
        Complex c2 = new Complex();
        System.out.println("Enter first complex number:");
        c1.read();
        System.out.println("Enter second complex number:");
        c2.read();
        System.out.print("First complex number: ");
        c1.display();
        System.out.print("Second complex number: ");
        c2.display();
        Complex sum = c1.add(c2);
        System.out.print("Sum: ");
        sum.display();
        Complex product = c1.multiply(c2);
        System.out.print("Product: ");
        product.display();
    }
}
