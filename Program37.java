/* Program to implement a Generic Class.
@Shyam James
Roll no: 54
Date: 05-01-2026
*/

class Box<T>{
    private T item;

    public void setItem(T item){
        this.item = item;
    }

    public T getItem(){
        return item;
    }
}

class Program37{
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.setItem(100);
        System.out.println(intBox.getItem());

        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello!");
        System.out.println(stringBox.getItem());
    }
}