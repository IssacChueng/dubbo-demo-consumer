package cn.jeff.study.dubbodemoprovider;

import lombok.Data;

import java.io.Serializable;

@Data
public class Teacher implements Serializable {

    private String name;
}
