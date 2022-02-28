package com.company;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// 4) WAP to show usage of Callable and demonstrate how it is different from Runnable

class runnableExample implements Runnable
{

    @Override
    public void run() {
        Integer duration = Integer.valueOf((int) (Math.random() * 100 * Math.random() *200)) ;
        System.out.println("Thread from runnable example got invoked at: "+ CurrentTime.getCurrentTime()); 

        try{
            Thread.sleep(duration);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }

        System.out.println("Thread from runnable example got executed successfully at: "+ CurrentTime.getCurrentTime());
        
    }

}

class callableExample implements Callable
{

    @Override
    public Integer call() throws Exception {

        Integer duration = Integer.valueOf((int) (Math.random() * 100 * Math.random() *200)) ;
        System.out.println("Thread from Callable example got invoked at: "+ CurrentTime.getCurrentTime()); 

        try{
            Thread.sleep(duration);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }

        System.out.println("Thread from Callable example got executed successfully at: "+ CurrentTime.getCurrentTime());

        return duration;
    }
    
}


public class Q4 {
    public static void main(String args[]) throws Exception
    {
        runnableExample t1=new runnableExample();
        callableExample c1= new callableExample();
        ExecutorService executorService= Executors.newFixedThreadPool(2);


        Future<Integer> future=executorService.submit(c1);
        executorService.submit(t1);
   //     executorService.awaitTermination(10, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println(future);

    }
}
