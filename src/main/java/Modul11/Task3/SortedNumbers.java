package Modul11.Task3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortedNumbers {

    public static void main(String[] args) {

        String[] numbers = new String[]{"1, 2, 0", "4, 10"};

        String result = Arrays.stream(numbers)
                .flatMap(i -> Arrays.stream(i.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}
