package com.github.sangholee.dev.effectivejavastudy.study15_item78;

import java.util.concurrent.TimeUnit;

public class StopThreadSynchronized {

    private static boolean stopRequested;

    // 동기화 쓰기
    private static synchronized void requestStop() {
        stopRequested = true;
    }

    // 동기화 읽기
    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    // 배타적 수행과 스레드 간 통신 중 통신 목적으로 사용

    public static void main(String[] args) throws InterruptedException {
        final Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested()) {
                i++;
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
