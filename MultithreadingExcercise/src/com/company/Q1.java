package com.company;

// 1) Create and Run a Thread using Runnable Interface and Thread class and show usage of sleep and join methods in the created threads.

class q1Thread1 implements Runnable
{
    
    @Override
    public void run() 
    {
        System.out.println("q1Thread1: Thread1 got invoked at: "+ CurrentTime.getCurrentTime()); 
        try{
            Thread.sleep(1000);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
        
        System.out.println("q1Thread1: Thread1 got executed successfully at: "+ CurrentTime.getCurrentTime());       
    }
}

class q1Thread2 extends Thread
{
    @Override
    public void run() 
    {
        System.out.println("q1Thread2: Thread2 got invoked at: "+ CurrentTime.getCurrentTime()); 
        System.out.println("q1Thread2: Thread2 got executed successfully at: "+ CurrentTime.getCurrentTime());
    }
}

public class Q1 {
    public static void main(String args[])
    {   
        Thread t1=new Thread( new q1Thread1());
        Thread t2=new q1Thread2();
        t1.start();
        t2.start();
    }
}