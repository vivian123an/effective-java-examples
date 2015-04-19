package jdk.thread;

public class SyncDemo {
	public static void main(String[] args) {  
		Sync sync = new Sync();
        for (int i = 0; i < 3; i++) {  
            Thread thread = new ThreadTest(sync);  
            thread.start();  
        }  
    }
}
class Sync {  
    public synchronized void test() {  
        System.out.println("test开始..");  
        try {  
            Thread.sleep(1000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println("test结束..");  
    }  
}  
  
class ThreadTest extends Thread {  
	private Sync sync = new Sync();
	public ThreadTest(Sync sync) {
		this.sync = sync;
	}
    public void run() {  
        sync.test();  
    }  
}