package testcode.samples.classes.interfacessample.cartitemsample;

public class Book extends Product {

    public Book(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculatePrice() {
        return price;
    }
}
