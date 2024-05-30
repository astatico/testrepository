package testcode.samples.classes.finalpersonsample;

public class Main {
    public static void main(String[] args) {
        // Создание объекта класса Person с использованием конструктора
        Person person1 = new Person("John", 30);

        // Вывод информации о созданном объекте
        person1.displayInfo();

        // Изменение возраста с использованием метода setAge
        person1.setAge(35);

        // Вывод информации после изменения возраста
        person1.displayInfo();

        // Проверка совершеннолетия с использованием метода isAdult
        if (person1.isAdult()) {
            System.out.println(person1.getName() + " is an adult.");
        } else {
            System.out.println(person1.getName() + " is not an adult.");
        }
    }
}
