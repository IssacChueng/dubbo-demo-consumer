package cn.jeff.study.dubbodemoconsumer;

import cn.jeff.study.dubbodemoprovider.HelloService;

/**
 * @author swzhang
 * @date 2020/03/17
 */
public class WordRunner implements Runnable {

    private HelloService helloService;

    private int i;

    @Override
    public void run() {

        long start = System.currentTimeMillis();
        int i = 0;
        while (i < 10000) {
            helloService.getOneWord(i);
            i++;
        }

        long end = System.currentTimeMillis();

        System.out.println("fastjson used " + (end - start) + "ms");
    }
}
