package testcode.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSample {

    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("Java");
        myList.add("Python");
        myList.add("C++");

        System.out.println("Элементы списка:");
        for (String language : myList) {
            System.out.println(language);
        }
    }
}
