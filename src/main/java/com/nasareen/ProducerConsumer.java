package com.nasareen;

public class ProducerConsumer {
	private static int count;
	private static int[] buffer;
	private static Object lock = new Object();

	static class Producer {

		void produce() {
			synchronized (lock) {
				if (isFull(buffer)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				buffer[count++] = 1;
				lock.notify();
			}
		}
	}

	static class Consumer {
		public void consume() {

			synchronized (lock) {
				if (isEmpty()) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				buffer[--count] = 0;
				lock.notify();
			}
		}
	}

	static boolean isFull(int[] buffer) {
		return count == buffer.length;
	}

	static boolean isEmpty() {
		return count == 0;
	}

	public static void main(String... strings) {
		buffer = new int[10];
		count = 0;

		Consumer c = new Consumer();
		Producer p = new Producer();

		Runnable pr = () -> {
			for (int i = 0; i < 50; i++) {
				p.produce();
			}
		};

		Runnable cr = () -> {
			for (int i = 0; i < 50; i++) {
				c.consume();
			}
		};
		
		Thread pt = new Thread(pr);
		Thread ct = new Thread(cr);
		
		pt.start();
		ct.start();
		
		try {
			pt.join();
			ct.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Data left "+ count);

	}

}
