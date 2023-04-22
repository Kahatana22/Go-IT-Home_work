package Modul11.Task4;

import java.util.stream.Stream;

public class RandomAlgorithm {

    public static void main(String[] args) {

         long a = 25214903917l;
         long m = (long) Math.pow(2, 48);
         int c = 11;

        Stream.iterate(0.0, seed -> (a * seed + c) % m)
                .forEach(x -> {
                    System.out.println(x);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }
}
