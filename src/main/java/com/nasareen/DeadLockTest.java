package com.nasareen;

public class DeadLockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DeadLock d = new DeadLock();
		Runnable r = () ->{
			System.out.println(Thread.currentThread().getName());
		};
		
		Thread t1 =new Thread(() -> {
			d.A();
		});
		Thread t2 =new Thread(() -> {
			d.B();
		});
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
