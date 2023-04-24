package com.github.sangholee.dev.effectivejavastudy.study15_item78;

import java.util.concurrent.atomic.AtomicLong;

public class VolatileAtomic {

    private static final AtomicLong nexSerialNum = new AtomicLong();

    public static long generateSerialNumber() {
        return nexSerialNum.getAndIncrement();
    }

    // java.util.concurrent.atomic 패키지는 락없이도 안전한 쓰레드 프로그래밍 지원
    // volatile 과 다르게 배타적 실행 까지 지원
    // 성능도 동기화 버전보다 우수

    public static void main(String[] args) {
        Thread first = new Thread(() -> {
            for (int i = 0; i < 300; i++) {
                System.out.printf("1번 쓰레드: %s\n", VolatileAtomic.generateSerialNumber());
            }
        });

        Thread second = new Thread(() -> {
            for (int i = 0; i < 300; i++) {
                System.out.printf("2번 쓰레드: %s\n", VolatileAtomic.generateSerialNumber());
            }
        });

        Thread third = new Thread(() -> {
            for (int i = 0; i < 300; i++) {
                System.out.printf("3번 쓰레드: %s\n", VolatileAtomic.generateSerialNumber());
            }
        });

        first.start();
        second.start();
        third.start();
    }
}
