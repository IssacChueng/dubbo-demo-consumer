package cn.jeff.study.dubbodemoconsumer;

import cn.jeff.study.dubbodemoprovider.HelloService;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.config.TaskExecutorFactoryBean;

import java.util.concurrent.TimeUnit;

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
