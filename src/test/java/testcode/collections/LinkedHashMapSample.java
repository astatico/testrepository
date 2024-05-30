package testcode.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapSample {

    public static void main(String[] args) {
        Map<Integer, String> myMap = new LinkedHashMap<>();
        myMap.put(1, "Красный");
        myMap.put(2, "Зеленый");
        myMap.put(3, "Синий");

        System.out.println("Значения по ключам:");
        for (int key : myMap.keySet()) {
            System.out.println(key + ": " + myMap.get(key));
        }
    }
}
