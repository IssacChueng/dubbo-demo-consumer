package cn.jeff.study.dubbodemoconsumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class DubboDemoConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboDemoConsumerApplication.class, args);
    }

}
