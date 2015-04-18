// Properly synchronized cooperative thread termination - Page 261
package org.effectivejava.examples.chapter10.item66.fixedstopthread1;

import java.util.concurrent.TimeUnit;

public class StopThread {
	private static boolean stopRequested;

	private static synchronized void setRequestStop() {
		stopRequested = true;
	}

	private static synchronized boolean readStopRequested() {
		return stopRequested;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				long start = System.currentTimeMillis();
				int i = 0;
				while (!readStopRequested())
					i++;
				System.out.println("thread end:"+(System.currentTimeMillis()-start));
			}
		});
		backgroundThread.start();

		TimeUnit.SECONDS.sleep(1);
		setRequestStop();
	}
}
