package com.nasareen;
public class ThreadExample {

    public static void main(String[] args){
        System.out.println("Main!");
        
        Runnable runnable = ()->{
        	
        	System.out.println(Thread.currentThread().getName());
        };
        
        Thread t1 = new Thread(runnable);
        t1.start();
    }
}
