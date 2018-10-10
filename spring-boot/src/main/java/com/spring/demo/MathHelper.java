package com.spring.demo;


import org.springframework.stereotype.Component;

@Component
public  class MathHelper {
    public MathHelper() {

    }
    public static Integer add (Integer num1, Integer num2) {
        return num1 + num2;
    }

    public static Integer subtract (Integer num1, Integer num2) {
        return num1 - num2;
    }

    public static Integer product (Integer num1, Integer num2) {
        return num1 * num2;
    }

    public static Integer square (Integer num1) {
        return num1*num1;
    }
}
