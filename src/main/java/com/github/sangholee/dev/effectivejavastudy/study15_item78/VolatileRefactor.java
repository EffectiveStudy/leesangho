package com.github.sangholee.dev.effectivejavastudy.study15_item78;

public class VolatileRefactor {

    private int nextSerialNumber = 0;

    public synchronized int generateSerialNumber() {
        return nextSerialNumber++;
    }

    public static void main(String[] args) {
        VolatileRefactor badCase = new VolatileRefactor();

        Thread first = new Thread(() -> {
            for (int i = 0; i < 300; i++) {
                System.out.printf("1번 쓰레드: %s\n", badCase.generateSerialNumber());
            }
        });

        Thread second = new Thread(() -> {
            for (int i = 0; i < 300; i++) {
                System.out.printf("2번 쓰레드: %s\n", badCase.generateSerialNumber());
            }
        });

        Thread third = new Thread(() -> {
            for (int i = 0; i < 300; i++) {
                System.out.printf("3번 쓰레드: %s\n", badCase.generateSerialNumber());
            }
        });

        first.start();
        second.start();
        third.start();
    }
}
