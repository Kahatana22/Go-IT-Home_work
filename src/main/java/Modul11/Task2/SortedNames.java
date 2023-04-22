package Modul11.Task2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortedNames {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("John", "Ira", "Petro", "Anna", "Ivan", "Natasha", "Sergiy", "Svetlana", "Bill");

        List<String> list = names.stream()
                .sorted(Collections.reverseOrder())
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(list);
    }
}
