/* Program to implement a Generic method.
@Shyam James
Roll no: 54
Date: 05-01-2026
*/

class Program36{
    public static <E> void printArray(E[] e){
        for(int i=0;i<e.length;i++){
            System.out.println(e[i]);
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {1,2,3,4,5};
        Double[] doubleArray = {1.1,2.2,3.3,4.4,5.5};
        Character[] charArray = {'H','E','L','L','O'};

        System.out.println("Integer Array Contains:");
        printArray(intArray);

        System.out.println("Double Array Contains:");
        printArray(doubleArray);

        System.out.println("Character Array Contains:");
        printArray(charArray);
    }
}
