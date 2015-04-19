package jdk.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
/**
 * CountDownLatch是java.util.concurrent中的一个同步辅助类，可以把它看做一个倒数计数器，就像神舟十号发射时倒数：10,9,8,7….2,1,0,走你。
 * 初始化时先设置一个倒数计数初始值，每调用一次countDown()方法，倒数值减一，await()方法会阻塞当前进程，直到倒数至0。
 * @author pingan
 *
 */
public class ThreadSon extends Thread{
	
	private CountDownLatch countDown = new CountDownLatch(5);;
	
	public void run()  {  
        System.out.println(this.getName() + "子线程开始");  
        try  {  
            Thread.sleep(5000);  // 子线程休眠五秒  
        }  catch (InterruptedException e)  {  
            e.printStackTrace();  
        }  
        System.out.println(this.getName() + "子线程结束");  
        countDown.countDown();
    }
	
	@Test
	public void test(){
		long start = System.currentTimeMillis();
		Thread thread = null;
		for(int i=0;i<5;i++){
	        thread = new ThreadSon();  
	        thread.start();  
		}
		try {
			countDown.await();
			long end = System.currentTimeMillis();  
			System.out.println("主线程执行时长：" + (end - start));  
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
       
	}
}
