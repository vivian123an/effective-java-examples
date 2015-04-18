// Cooperative thread termination with a volatile field
package org.effectivejava.examples.chapter10.item66.fixedstopthread2;

import java.util.concurrent.TimeUnit;

public class StopThread {
	private static volatile boolean stopRequested;

	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				long start = System.currentTimeMillis();
				int i = 0;
				while (!stopRequested)
					i++;
				System.out.println("thread end:"+(System.currentTimeMillis()-start));
			}
		});
		backgroundThread.start();

		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}
}
