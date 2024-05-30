package testcode.samples.classes.personsample;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Алексей", 25);
        Person person2 = new Person("Елена", 30);

        // Вызов метода displayInfo() для объекта person1
        person1.displayInfo();

        // Вызов метода displayInfo() для объекта person2
        person2.displayInfo();
    }
}
