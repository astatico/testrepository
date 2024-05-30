package testcode.samples.classes.interfacessample.cartitemsample;

public class Main {

    public static void main(String[] args) {
        Book book = new Book("Java Programming", 30.0);
        ElectronicDevice laptop = new ElectronicDevice("Laptop", 1000.0, 0.1);
        Clothing shirt = new Clothing("T-shirt", 20.0, 0.15);

        System.out.println("Book price: $" + book.calculatePrice());
        System.out.println("Laptop price: $" + laptop.calculatePrice());
        System.out.println("Shirt price: $" + shirt.calculatePrice());
    }
}
