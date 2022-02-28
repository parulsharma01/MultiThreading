package com.company;// Explaining the usage of join()

import com.company.q1Thread1;
import com.company.q1Thread2;

public class Q1_2 {
    public static void main(String args[]) throws InterruptedException
    {   
        Thread t1=new Thread( new q1Thread1());
        Thread t2=new q1Thread2();
        t1.start();
        t1.join();
        t2.start();
    }
}
