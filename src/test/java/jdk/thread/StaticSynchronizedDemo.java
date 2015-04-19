package jdk.thread;
/**
 * synchronized(Sync.class)实现了全局锁的效果
 * static synchronized方法也相当于全局锁，相当于锁住了代码段
 * @author pingan
 *
 */
public class StaticSynchronizedDemo {
	public static void main(String[] args) {  
        for (int i = 0; i < 3; i++) {  
            Thread thread = new ThreadTest3();  
            thread.start();  
        }  
    }
}
class StaticSync {  
    /*public static synchronized void test() {  
        System.out.println("test开始..");  
        try {  
            Thread.sleep(1000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println("test结束..");  
    }*/ 
    public void test() {  
    	synchronized(StaticSync.class){
            System.out.println("test开始..");  
            try {  
                Thread.sleep(1000);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
            System.out.println("test结束..");  
    	}
    }
}  
class ThreadTest3 extends Thread {  
    public void run() {  
    	StaticSync sync = new StaticSync();  
        sync.test();  
    }  
} 