package com.csf;

import java.util.concurrent.CyclicBarrier;

public class TestTrans {

    public static void main(String[] args) throws Exception {
        A a = new B();
        test(a);
        a.clone();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        cyclicBarrier.await();
    }

    public static void test(A a) {
        System.out.println("test A");
        a.whoAmI();
    }

    public static void test(B b) {
        System.out.println("test B");
        b.whoAmI();
    }
}

class A implements Cloneable{
    public void whoAmI() {
        System.out.println("I'm A");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class B extends A {
    public void whoAmI() {
        System.out.println("I'm B");
    }
}
