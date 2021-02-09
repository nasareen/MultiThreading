package com.nasareen;

public class DeadLock {

	Object key1 = new Object();
	Object key2 = new Object();
	
	void A() {
		synchronized (key1) {
			System.out.println("Inside A");
			B();
		}
		
	}

	 void B() {
		// TODO Auto-generated method stub
		synchronized (key2) {
			System.out.println("Inside B");
			C();
		}
	}

	 void C() {
		// TODO Auto-generated method stub
		 synchronized (key1) {
			System.out.println("Inside C");
		}
		
	}
	
	
}
