package cn.jeff.study.dubbodemoconsumer;

import cn.jeff.study.dubbodemoprovider.HelloService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author swzhang
 * @date 2020/03/23
 */
@Data
@Slf4j
public class WordRunnerConcurrent {

    private int word;

    private int concurrent;

    private HelloService helloService;

    public void readWord() {
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(concurrent);
        for (int i = 0; i < concurrent; i++) {
            new Thread(() -> {
                try {
                    start.await();
                    helloService.getOneWord(word);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                } finally {
                    end.countDown();
                }
            }).start();
        }

        start.countDown();
        long nowStart = System.currentTimeMillis();
        try {
            log.info("end await");
            end.await();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        long nowEnd = System.currentTimeMillis();
        log.info("{} word {} concurrent cost {} seconds", word, concurrent, TimeUnit.MILLISECONDS.toSeconds(nowEnd - nowStart));
    }
}
