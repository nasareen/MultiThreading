package com.nasareen;

public class Increment {

	private long increment;
	Object key = new Object();
	
	public Increment(long l) {
		this.increment=l;
	}
	
	void incrementValue() {
		synchronized (key) {
			increment++;
		}
		//++;
	}
	
	 long getIncement() {
		return increment;
	}
}
