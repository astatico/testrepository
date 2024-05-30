package testcode.samples.classes.personsample;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Метод для вывода информации о человеке
    public void displayInfo() {
        System.out.println("Имя: " + name + ", Возраст: " + age);
    }
}
