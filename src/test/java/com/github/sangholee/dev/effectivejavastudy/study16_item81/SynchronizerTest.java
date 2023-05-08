package com.github.sangholee.dev.effectivejavastudy.study16_item81;

import ch.qos.logback.core.util.ExecutorServiceUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Lazy;

@Slf4j
class SynchronizerTest {

    @Test
    void time() throws InterruptedException {
        final long time = Synchronizer.time(Executors.newFixedThreadPool(7),
                10, () -> log.info("test"));
        log.info("{}ns", time);
    }
}
