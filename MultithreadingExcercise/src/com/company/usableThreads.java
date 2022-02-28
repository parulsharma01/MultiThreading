package com.company;

class UsableThread extends Thread
{
    static int threadNumber=0;

    @Override
    public void run() 
    {
        Long duration = (long) (Math.random() * 10 * Math.random() *200) ;
        System.out.println(threadNumber+" : UsableThread got invoked at: "+ CurrentTime.getCurrentTime()); 

        try{
            Thread.sleep(duration);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }

        System.out.println(threadNumber+" : UsableThread got executed successfully at: "+ CurrentTime.getCurrentTime());
    }
}
