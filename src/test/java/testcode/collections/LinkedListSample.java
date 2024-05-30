package testcode.collections;

import java.util.LinkedList;
import java.util.List;

public class LinkedListSample {

    public static void main(String[] args) {
        List<String> myList = new LinkedList<>();
        myList.add("Java");
        myList.add("Python");
        myList.add("C++");

        System.out.println("Элементы списка:");
        for (String language : myList) {
            System.out.println(language);
        }
    }
}
