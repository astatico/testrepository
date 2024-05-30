package testcode.samples.classes.finalpersonsample;

// Определение класса "Человек"
public class Person {

    // Поля класса
    String name;
    int age;

    // Конструктор класса
    public Person(String name, int age) {
        this.name = name; // Инициализация поля name
        this.age = age; // Инициализация поля age
    }

    // Метод для вывода информации о человеке
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    // Метод для изменения возраста
    public void setAge(int newAge) {
        age = newAge;
    }

    // Метод для получения имени
    public String getName() {
        return name;
    }

    // Метод для получения возраста
    public int getAge() {
        return age;
    }

    // Метод для проверки совершеннолетия
    public boolean isAdult() {
        return age >= 18;
    }
}



