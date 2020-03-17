package cn.jeff.study.dubbodemoconsumer;

import cn.jeff.study.dubbodemoprovider.HelloService;
import cn.jeff.study.dubbodemoprovider.Student;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author swzhang
 * @date 2020/02/22
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ConsumeController {

    @Reference(check = false, timeout = 600000)
    private HelloService helloService;

    @Resource
    private TaskExecutor taskExecutor;

    @GetMapping(value = "/consume")
    public ResponseEntity<Student> read() {
        Student student = helloService.getStudent();
        ConsumerRunner consumerRunner = new ConsumerRunner();
        consumerRunner.setHelloService(helloService);
        taskExecutor.execute(consumerRunner);
        return ResponseEntity.ok(student);
    }

    /**
     * only 1, 2, 3
     * @param i
     * @return
     */
    @GetMapping(value = "/consume/{i}")
    public ResponseEntity<String> read1k(@PathVariable(name = "i") Integer i) {
        String word = helloService.getOneWord(i);
        WordRunner wordRunner = new WordRunner();
        wordRunner.setHelloService(helloService);
        wordRunner.setI(i);
        taskExecutor.execute(wordRunner);
        return ResponseEntity.ok(word);
    }
}
