package cn.jeff.study.dubbodemoprovider;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private static final long serialVersionUID = -840925298992117036L;
    private String name;

    private Teacher teacher;
}
