package com.company;// 3) Use Synchronize method and synchronize block to enable synchronization between multiple threads trying to access method at same time.

public class Q3 {
    private Integer integer = 0;
    private void increment() {
        try{
            Thread.sleep(10);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
        this.integer+=7;
        System.out.println("Incremented Integer: "+integer);
    }
    private synchronized void decrement() {
        try{
            Thread.sleep(10);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
        this.integer-=7;
        System.out.println("Decremented Integer: "+integer);
}

    public static void main(String[] args) throws InterruptedException {
        Q3 methods = new Q3();
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                synchronized(lock) {
                    methods.increment();
                }
            }
        }, "IncrementThread");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                synchronized (lock) {
                    methods.decrement();
                }
            }
        }, "DecrementThread");
        t1.start();
        t2.start();
        
        Thread.sleep(5000);
        System.out.println(methods.integer);
    }
}
