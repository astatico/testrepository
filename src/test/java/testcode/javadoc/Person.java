package testcode.javadoc;

/**
 * Класс для представления человека.
 * Содержит основные атрибуты, такие как имя и возраст.
 */
public class Person {
    private String name;
    private int age;

    /**
     * Конструктор для создания нового объекта Person.
     *
     * @param name Имя человека.
     * @param age Возраст человека.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Получить имя человека.
     *
     * @return Имя человека.
     */
    public String getName() {
        return name;
    }

    /**
     * Установить новое имя человека.
     *
     * @param name Новое имя человека.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получить возраст человека.
     *
     * @return Возраст человека.
     */
    public int getAge() {
        return age;
    }

    /**
     * Установить новый возраст человека.
     *
     * @param age Новый возраст человека.
     */
    public void setAge(int age) {
        this.age = age;
    }
}
