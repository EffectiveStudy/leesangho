package com.github.sangholee.dev.effectivejavastudy.study16_item81;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class Synchronizer {

    public static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                // 타이머에게 준비됨을 알림
                ready.countDown();;

                try {
                    // 모든 작업자 스레드가 준비될 때까지 대기
                    start.await();
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();;
                } finally {
                    // 타이머에게 완료됨을 알림
                    done.countDown();;
                }
            });
        }

        // 모든 작업자 준비 될때까지 대기
        ready.await();
        long startNanos = System.nanoTime();
        // 작업자들을 깨움
        start.countDown();
        // 모든 작업자가 일 끝날때 까지 대기
        done.await();
        return System.nanoTime() - startNanos;
    }


    public static void main(String[] args) {
    }
}
