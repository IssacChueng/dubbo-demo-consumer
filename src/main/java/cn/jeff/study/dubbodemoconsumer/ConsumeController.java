package cn.jeff.study.dubbodemoconsumer;

import cn.jeff.study.dubbodemoprovider.HelloService;
import cn.jeff.study.dubbodemoprovider.Student;
import com.alibaba.fastjson.JSON;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swzhang
 * @date 2020/02/22
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ConsumeController {

    @Reference(check = false, timeout = 600000)
    private HelloService helloService;

    @GetMapping(value = "/consume")
    public ResponseEntity<Student> read() {
        Student student = helloService.getStudent();
        System.out.println(JSON.toJSONString(student));
        return ResponseEntity.ok(student);
    }
}
