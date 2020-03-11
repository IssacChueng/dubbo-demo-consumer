package cn.jeff.study.dubbodemoconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;

@SpringBootApplication
public class DubboDemoConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboDemoConsumerApplication.class, args);
    }


    @Bean
    public TaskExecutor taskExecutor(TaskExecutorBuilder taskExecutorBuilder) {
        return taskExecutorBuilder.corePoolSize(2)
                .maxPoolSize(2).build();
    }
}
