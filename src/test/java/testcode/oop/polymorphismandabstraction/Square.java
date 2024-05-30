package testcode.oop.polymorphismandabstraction;

public class Square extends AbstractShape {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}
