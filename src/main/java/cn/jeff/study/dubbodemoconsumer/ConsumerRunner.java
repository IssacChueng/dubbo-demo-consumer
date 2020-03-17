package cn.jeff.study.dubbodemoconsumer;

import cn.jeff.study.dubbodemoprovider.HelloService;

/**
 * @author swzhang
 * @date 2020/03/11
 */
public class ConsumerRunner implements Runnable {

    private HelloService helloService;

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public void run() {

        long start = System.currentTimeMillis();
        int i = 0;
        while (true) {
            i++;
            helloService.getStudent();
            if (i > 10000) {
                break;
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("fastjson used " + (end - start) + "ms");
    }

}
