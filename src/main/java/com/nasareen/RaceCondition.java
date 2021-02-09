package com.nasareen;

public class RaceCondition {
	public static void main(String[] args) {
		
	
	
	Increment inc = new Increment(0L);
	
	
	Runnable r = () ->{
		for(int i=0;i<1000;i++) {
			inc.incrementValue();
		}
	};
	
	Thread[] threads = new Thread[1000];
	for(int i=0;i<1000;i++) {
		threads[i] = new Thread(r);
		threads[i].start();
	}
	
	for(int i=0;i<1000;i++) {
		try {
			threads[i].join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	System.out.println(inc.getIncement());

}
}
