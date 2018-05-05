package com.byzoro;

/**
 * Hello world!
 */
public class MyThread {
    public static void main(String[] args) {
        Thread thread1 = new Thread(MyThread::print1);
        Thread thread2 = new Thread(MyThread::print2);

        thread1.start();
        thread2.start();
    }

    public static void print1() {
        for (int i = 1; i <= 500; i++) {
            System.out.println("guotou");
        }
    }

    public static void print2() {
        for (int i = 1; i <= 500; i++) {
            System.out.println("123456");
        }
    }
}
