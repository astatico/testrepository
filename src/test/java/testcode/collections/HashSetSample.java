package testcode.collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetSample {

    public static void main(String[] args) {
        Set<String> mySet = new HashSet<>();
        mySet.add("apple");
        mySet.add("banana");
        mySet.add("apple"); // Этот элемент не будет добавлен

        System.out.println("Уникальные элементы:");
        for (String fruit : mySet) {
            System.out.println(fruit);
        }
    }
}
