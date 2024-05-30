package testcode.collections;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetSample {

    public static void main(String[] args) {
        Set<String> mySet = new TreeSet<>();
        mySet.add("banana");
        mySet.add("apple");
        mySet.add("orange");

        System.out.println("Уникальные элементы (отсортировано):");
        for (String fruit : mySet) {
            System.out.println(fruit);
        }
    }
}
