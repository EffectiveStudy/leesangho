package com.github.sangholee.dev.effectivejavastudy.study15_item78;

import java.util.concurrent.TimeUnit;

public class StopThreadVolatile {

    // volatile 한정자는 배타적 수행과 관계없이 가장 최근 기록값을 읽는 것을 보장
    // 반복문에서 매번 동기화 하는것보다 속도가 더 빠름

    // ** 배타적 수행 -> 오직 하나의 프로세스, 쓰레드, 코어 등이 해당 자원을 사용하는 것
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        final Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
