/* Program to implement StringBuffer class.
@Shyam James
Roll no: 54
1Date: 12-01-2026
*/

class Program39{
    public static void main(String[] args) {
        StringBuffer strb = new StringBuffer("Hello");
        System.out.println(strb);
        System.out.println("Appending World:");
        strb.append("World");
        System.out.println(strb);
        System.out.println("Inserting at position 5");
        strb.insert(5, " Java ");
        System.out.println(strb);
        System.out.println("Removing from position 5 to 11");
        strb.delete(6, 11);
        System.out.println(strb);
        System.out.println("Replacing from position 0 to 5");
        strb.replace(0, 5, "Javac");
        System.out.println(strb);
        System.out.println("Reversing:");
        strb.reverse();
        System.out.println(strb);
        System.out.println("Converting to String");
        String str = strb.toString();
        System.out.println(str);
    }
}