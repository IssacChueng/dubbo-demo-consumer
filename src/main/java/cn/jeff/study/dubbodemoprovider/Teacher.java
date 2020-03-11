package cn.jeff.study.dubbodemoprovider;

import lombok.Data;

import java.io.Serializable;

@Data
public class Teacher implements Serializable {

    private static final long serialVersionUID = -2631479634097896232L;
    private String name;
}
