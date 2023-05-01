package com.github.sangholee.dev.effectivejavastudy.study16_item81;

import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class SynchronizerTest {

    @Test
    void time() throws InterruptedException {
        final long time = Synchronizer.time(Executors.newFixedThreadPool(7),
                7, () -> log.info("test"));
        log.info("{}ns", time);
    }
}
