package testcode.collections;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapSample {

    public static void main(String[] args) {
        Map<Integer, String> myMap = new TreeMap<>();
        myMap.put(3, "Красный");
        myMap.put(1, "Зеленый");
        myMap.put(2, "Синий");

        System.out.println("Значения по ключам (отсортировано):");
        for (int key : myMap.keySet()) {
            System.out.println(key + ": " + myMap.get(key));
        }
    }
}
