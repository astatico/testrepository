package testcode.samples.classes.interfacessample.cartitemsample;

public class Clothing extends Product {

    private double discount;

    public Clothing(String name, double price, double discount) {
        super(name, price);
        this.discount = discount;
    }

    @Override
    public double calculatePrice() {
        return price * (1 - discount);
    }
}
