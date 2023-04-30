package Modul12.Task2;

import java.util.ArrayList;
import java.util.List;

public class NumberThreadTest {
    public static void main(String[] args) {
        NumberThread num = new NumberThread(50);

        NumberThread fizzBuzz = new NumberThread((n) -> {
            if (n % 15 == 0) {
                System.out.print("fizzbuzz, ");
            }
        });

        NumberThread fizz = new NumberThread((n) -> {
            if (n % 3 == 0 && n % 15 != 0) {
                System.out.print("fizz, ");
            }
        });

        NumberThread buzz = new NumberThread((n) -> {
            if (n % 5 == 0 && n % 15 != 0) {
                System.out.print("buzz, ");
            }
        });

        NumberThread number = new NumberThread((n) -> {
            if (n%3 != 0 && n%5 != 0) {
                System.out.print(n + ", ");
            }
        });

        List<NumberThread> threads = new ArrayList<>();
        threads.add(fizzBuzz);
        threads.add(fizz);
        threads.add(buzz);
        threads.add(number);

        for (NumberThread thread : threads) {
            thread.start();
        }

        for (int i = 1; i < num.getNumber(); i++) {
            for (NumberThread thread : threads) {
                thread.process(i);
            }
            while (true) {
                int processedCount = 0;
                for (NumberThread thread : threads) {
                    if (thread.isProcessed()) {
                        processedCount++;
                    }
                }
                if (processedCount == threads.size()) {
                    break;
                }
            }
        }
    }
}
