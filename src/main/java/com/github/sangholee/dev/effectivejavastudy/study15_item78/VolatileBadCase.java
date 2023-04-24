package com.github.sangholee.dev.effectivejavastudy.study15_item78;

public class VolatileBadCase {

    private volatile int nextSerialNumber = 0;

    public int generateSerialNumber() {
        return nextSerialNumber++;
    }

    // ++ 연산자는 필드에 두번 접근함
    // 값을 읽고 -> 증가시킨 값을 저장
    // 만약 이 때 다른 쓰레드가 값을 읽어 가면 문제가 발생 -> 안전 실패
    // ** 안전 실패 -> 보호기능이 동작하지 않아 위협이 발생함
    // 올바르게 사용하기 어려울 수 있음

    public static void main(String[] args) {
        VolatileBadCase badCase = new VolatileBadCase();

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
