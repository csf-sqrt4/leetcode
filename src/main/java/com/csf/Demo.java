package com.csf;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo implements Serializable {

    public static void main(String[] args) {
        String a = "1";
        System.out.println(System.identityHashCode(a));
        a = a + "1";
        System.out.println(System.identityHashCode(a));
        String b = a;
        System.out.println(System.identityHashCode(b));
        b = b + "1";
        System.out.println(System.identityHashCode(b));

        ThreadLocalDemo1 threadLocalDemo = new ThreadLocalDemo1();
        Integer m = new Integer(10);
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                threadLocalDemo.setA(m);
                System.out.println(threadLocalDemo.getA());
            }).start();
        }
    }
}

class ThreadLocalDemo1 {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    private Integer a;

    public Integer getA() {
        return threadLocal.get();
    }

    public void setA(Integer a) {
        threadLocal.set(a);
    }
}


class ThreadLocalDemo {
    private ThreadLocal<Demo1> threadLocal = new ThreadLocal<>();

    private Demo1 a;

    public Demo1 getA() {
        return threadLocal.get();
    }

    public void setA(Demo1 a) {
        threadLocal.set(a);
    }
}

class Demo1 {
    private Integer a;

    public Demo1(Integer a) {
        this.a = a;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }
}

