package Modul11.Task1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortedNamesOnIndex {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("John", "Ira", "Petro", "Anna", "Ivan", "Natasha", "Sergiy", "Svetlana", "Bill");

        String result = IntStream.range(0, names.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> i + "." + names.get(i))
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}
