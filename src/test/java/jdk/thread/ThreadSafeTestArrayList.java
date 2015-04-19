package jdk.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;
/**
 * 非线程安全是指多线程操作同一个对象可能会出现问题。而线程安全则是多线程操作同一个对象不会有问题。
 * 线程安全必须要使用很多synchronized关键字来同步控制，所以必然会导致性能的降低。
 * 所以在使用的时候，如果是多个线程操作同一个对象，那么使用线程安全的Vector
 * @author pingan
 *
 */
public class ThreadSafeTestArrayList {
	@Test
	public void junit() {
		for (int i = 0; i < 10; i++) {
			test();
		}
	}
    public static void test()  {  
        //List<Object> list = new ArrayList<Object>();  
    	List<Object> list = Collections.synchronizedList(new ArrayList<Object>());
        //List<Object> list = new Vector<Object>();  
        int threadCount = 1000;  
        // 用来让主线程等待threadCount个子线程执行完毕  
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);  
        for(int i = 0; i < threadCount; i++){  
            Thread thread = new Thread(new ThreadTest4(list,countDownLatch));  
            thread.start();  
        }  
        try  {  
            countDownLatch.await();   // 主线程等待所有子线程执行完成，再向下执行  
        } catch (InterruptedException e)  {  
            e.printStackTrace();  
        }  
        System.out.println(list.size());  
    }
}
/**
 * synchronized锁住的是括号里的对象，而不是代码。
 * 对于非static的synchronized方法，锁的就是对象本身也就是this。
 * synchronized(ThreadTest4.class)实现了全局锁的效果,
 * static方法可以直接类名加方法名调用，方法中无法使用this，所以它锁的不是this，而是类的Class对象
 * static synchronized方法也相当于全局锁，相当于锁住了代码段
 * @author pingan
 *
 */
class ThreadTest4 implements Runnable  {  
    private List<Object> list;  
    private CountDownLatch countDownLatch;  
    public ThreadTest4(List<Object> list,CountDownLatch countDownLatch)  {  
        this.list = list;  
        this.countDownLatch = countDownLatch;  
    }  
    public void run()  {  
    	//synchronized(ThreadTest4.class){
    	//synchronized(this){
    	synchronized(list){
            for(int i = 0; i < 100; i++)  {  // 每个线程向List中添加100个元素  
                list.add(new Object());  
            }  
            countDownLatch.countDown();   // 完成一个子线程  
    	}
    }  
}