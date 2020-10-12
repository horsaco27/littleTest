package com.horsacode.littletest.threads.java_threads.runnables;

public class Task implements Runnable {

    private final long countUntil;

    public Task(long countUntil) {
        this.countUntil = countUntil;
    }

    @Override
    public void run() {
        long sum = 0;
        for (long i = 1; i < countUntil; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

}