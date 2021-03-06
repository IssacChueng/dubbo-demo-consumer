package cn.jeff.study.dubbodemoconsumer;

import cn.jeff.study.dubbodemoprovider.HelloService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author swzhang
 * @date 2020/03/17
 */
@Data
@Slf4j
public class WordRunner implements Runnable {

    private HelloService helloService;

    private int word;

    @Override
    public void run() {

        long start = System.currentTimeMillis();
        int i = 0;
        while (i < 10000) {
            helloService.getOneWord(word);
            i++;
        }

        long end = System.currentTimeMillis();

        log.info("{} word 10000 times used {} seconds", word, (end - start)/ 1000);
    }
}
