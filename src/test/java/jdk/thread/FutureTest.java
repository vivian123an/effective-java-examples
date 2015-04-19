package jdk.thread;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class FutureTest {

	@Test
	public void test10Times() throws InterruptedException, ExecutionException{
		for(int j=0;j<10;j++){thread();}
	}
	public void thread() throws InterruptedException, ExecutionException{
		final List<Object> list = new Vector<Object>(10); 
		int poolSize = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        CountDownLatch countDownLatch = new CountDownLatch(poolSize);
        for(int i=0;i<poolSize;i++){
            executorService.submit(new ThreadTest5(list,countDownLatch));
        }
        executorService.shutdown();  
        countDownLatch.await();
        System.out.println(list.size());
	}
}
class ThreadTest5 implements Callable<List<Object>>{
	private List<Object> list;
	private CountDownLatch countDownLatch; 
	public ThreadTest5(List<Object> list,CountDownLatch countDownLatch) {
		this.list = list;
		this.countDownLatch = countDownLatch;
	}
	@Override
	public List<Object> call() throws Exception {
		synchronized (list) {
			for(int i = 0; i < 100; i++)  {  // 每个线程向List中添加100个元素  
	            list.add(new Object());  
	        } 
			countDownLatch.countDown();
			return list;
		}
	}
}
