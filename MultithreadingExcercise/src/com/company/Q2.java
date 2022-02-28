package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


// 2) Use a singleThreadExecutor, newCachedThreadPool() and newFixedThreadPool() to submit a list of tasks and wait for completion of all tasks.

public class Q2 {
    public static void main(String gg[])
    {
        ExecutorService singleThreadExecutor= Executors.newSingleThreadExecutor();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        try {
            singleThreadExecutor.submit(new UsableThread());

            cachedThreadPool.submit(new UsableThread());
            cachedThreadPool.submit(new UsableThread());
            cachedThreadPool.submit(new UsableThread());
            
            fixedThreadPool.submit(new UsableThread());
            fixedThreadPool.submit(new UsableThread());
            fixedThreadPool.submit(new UsableThread());
            fixedThreadPool.submit(new UsableThread());

            

            singleThreadExecutor.shutdown();
            singleThreadExecutor.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("Shutdown singleThreadExecutor");


            cachedThreadPool.shutdown();
            cachedThreadPool.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("Shutdown cachedThreadPool");


            fixedThreadPool.shutdown();
            fixedThreadPool.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("Shutdown fixedThreadPool");


         } catch (InterruptedException e) {
            System.err.println("-------Tasks interrupted-------");
            e.printStackTrace();
         } 

    }
}

