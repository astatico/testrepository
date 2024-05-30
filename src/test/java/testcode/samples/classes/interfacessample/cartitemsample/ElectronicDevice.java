package testcode.samples.classes.interfacessample.cartitemsample;

public class ElectronicDevice extends Product {

    private double taxRate;

    public ElectronicDevice(String name, double price, double taxRate) {
        super(name, price);
        this.taxRate = taxRate;
    }

    @Override
    public double calculatePrice() {
        return price * (1 + taxRate);
    }
}
