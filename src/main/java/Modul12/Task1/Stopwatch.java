package Modul12.Task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Stopwatch extends Thread {

    public AtomicInteger counter = new AtomicInteger();

    @Override
    public void run() {
        while (true) {
            System.out.println(counter);
            try {
                Thread.sleep(1000);
                counter.getAndIncrement();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Stopwatch sw = new Stopwatch();
        sw.start();

        while (true) {
            Thread.sleep(5000);
            System.out.println("Минуло 5 секунд");
        }
    }
}
