package com.github.sangholee.dev.effectivejavastudy.study15_item78;

import java.util.concurrent.TimeUnit;

public class StopThread {

    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        final Thread backgroundThread = new Thread(() -> {
            int i = 0;

            // 백그라운드 쓰레드에서 값을 읽음
            while (!stopRequested) {
                i++;
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);

        // 메인 쓰레드에서 값을 변경함
        stopRequested = true;
    }

    // VM 죄적화
//    public static void main(String[] args) throws InterruptedException {
//        final Thread backgroundThread = new Thread(() -> {
//            int i = 0;
//            if (!stopRequested)
//                while (true)
//                    i++;
//        });
//
//        backgroundThread.start();
//
//        TimeUnit.SECONDS.sleep(1);
//        stopRequested = true;
//    }
}
