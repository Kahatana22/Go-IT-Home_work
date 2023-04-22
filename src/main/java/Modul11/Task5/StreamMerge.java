package Modul11.Task5;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMerge {

    public static void main(String[] args) {

        Stream<String> numbers = Stream.of("1", "2", "3", "4", "5");
        Stream<String> names = Stream.of("Svetlana", "Ivan", "Anna", "Petro", "Mariya");

        zip(numbers, names).peek(System.out::println).collect(Collectors.toSet());
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {

        List<String> result = new ArrayList<>();

        Iterator<String> iteratorFirst = (Iterator<String>) first.iterator();
        Iterator<String> iteratorSecond = (Iterator<String>) second.iterator();

        while (iteratorFirst.hasNext() && iteratorSecond.hasNext()) {
            result.add(iteratorFirst.next());
            result.add(iteratorSecond.next());
        }
        return (Stream<T>) result.stream();
    }
}
