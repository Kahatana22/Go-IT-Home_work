package Modul12.Task2;

import java.util.concurrent.atomic.AtomicBoolean;

public class NumberThread extends Thread {
    private int number;
    private AtomicBoolean processed = new AtomicBoolean(true);
    private NumberProcessor processor;

    public int getNumber() {
        return number;
    }

    public NumberThread(int number) {
        this.number = number;
    }

    public NumberThread(NumberProcessor processor) {
        this.processor = processor;
    }

    public void process(int number) {
        this.number = number;
        processed.set(false);
    }

    public boolean isProcessed() {
        return processed.get();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (processed.get()) {
                break;
            }

            processor.process(number);
            processed.set(true);
        }
    }
}
