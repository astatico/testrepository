package testcode.oop.encapsulation;

public class Car {
    private String brand; // Приватное поле, доступное только внутри класса Car
    private int year;     // Приватное поле, доступное только внутри класса Car

    protected String model; // Защищенное поле, доступное внутри класса Car и его подклассов

    String color; // Пакетное поле (по умолчанию), доступное только внутри того же пакета
    // Эквивалентно объявлению без модификатора доступа

    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }
}
