package Modul10.Tasks.Task3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {

        FileReader file = new FileReader("src/main/java/Modul10/Resource/words.txt");
        BufferedReader bf = new BufferedReader(file);
        String line = bf.readLine();
        String str = "";
        while (line != null) {
            str += line + " ";
            line = bf.readLine();
        }
        bf.close();
        System.out.println("str = " + str);

        String[] array = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i += 1) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        System.out.println("map = " + map);
        map.entrySet().stream().
                sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).
                forEach(System.out::println);
    }
}
