package com.icode.spring;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-11-15
 * Time: 上午10:18
 */
public class B extends A {

    public static void print() {
        System.out.println("B");
    }

    public static void main(String[] args) {
        A.print();
        B.print();
        C.print();
    }
}
