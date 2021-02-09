package com.nasareen;

public class OddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OddEvenGenerator generator = new OddEvenGenerator(100);
		Thread t1 = new Thread(
				() ->  {
			generator.printOdd();
		});
		
		Thread t2 = new Thread(
				() ->  {
			generator.printEven();
		});

		t1.start();
		t2.start();
	}

}


class OddEvenGenerator{
	
	private int count=0;
	
	private int n;
	
	public OddEvenGenerator(int n) {
		this.n = n;
	}
	
	public void printOdd() {
		
		synchronized(this) {
			while(count <n) {
				if( n %2 == 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println("Odd "+ count);
				count ++;
				notify();
			}
		}
	}
	
	public void printEven() {
		synchronized (this) {
			
			while(count < n) {
				
				if(count % 2 == 1) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println("Even "+ count);
				count++;
				notify();
				
			}
			
		}
	}



}