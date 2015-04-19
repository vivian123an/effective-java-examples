package jdk.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.junit.Test;

public class CallableAndFuture {
	public static void main(String[] args) {  
        Callable<Integer> callable = new Callable<Integer>() {  
            public Integer call() throws Exception {  
                return new Random().nextInt(100);  
            }  
        };  
        FutureTask<Integer> future = new FutureTask<Integer>(callable);  
        new Thread(future).start();  
        try {  
            Thread.sleep(5000);// 可能做一些事情  
            System.out.println(future.get());  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } catch (ExecutionException e) {  
            e.printStackTrace();  
        }  
    }  
	
	public void submit(){
		ExecutorService threadPool = Executors.newSingleThreadExecutor();  
        Future<Integer> future = threadPool.submit(new Callable<Integer>() {  
            public Integer call() throws Exception {  
                return new Random().nextInt(100);  
            }  
        });  
        try {  
            Thread.sleep(5000);// 可能做一些事情  
            System.out.println(future.get());  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } catch (ExecutionException e) {  
            e.printStackTrace();  
        }
	}
	
	/**
	 * 执行多个带返回值的任务，并取得多个返回值
	 */
	@Test
	public void mutilThread(){
		ExecutorService threadPool = Executors.newCachedThreadPool();  
        CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threadPool);  
        for(int i = 1; i < 5; i++) {  
            final int taskID = i;  
            cs.submit(new Callable<Integer>() {  
                public Integer call() throws Exception {  
                    return taskID;  
                }  
            });  
        }  
        // 可能做一些事情  
        for(int i = 1; i < 5; i++) {  
            try {  
                System.out.println(cs.take().get());  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            } catch (ExecutionException e) {  
                e.printStackTrace();  
            }  
        }
	}
}
