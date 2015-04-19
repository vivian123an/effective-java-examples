package jdk.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
/**
 * newFixedThreadPool(3)
 * newCachedThreadPool()
 * newSingleThreadExecutor()
 * newScheduledThreadPool(3)
 * 创建了一个固定大小的线程池，容量为3，然后循环执行了4个任务，
 * 由输出结果可以看到，前3个任务首先执行完，然后空闲下来的线程去执行第4个任务，
 * 在FixedThreadPool中，有一个固定大小的池，如果当前需要执行的任务超过了池大小，那么多于的任务等待状态
 *	直到有空闲下来的线程执行任务，而当执行的任务小于池大小，空闲的线程也不会去销毁。
 * @author pingan
 *
 */
public class ThreadPoolTest {  
    public static void main(String[] args) {  
        ExecutorService threadPool = Executors.newFixedThreadPool(3);  
        for(int i = 1; i < 5; i++) {  
            final int taskID = i;  
            threadPool.execute(new Runnable() {  
                public void run() {  
                    for(int i = 1; i < 5; i++) {  
                        try {  
                            Thread.sleep(20);// 为了测试出效果，让每次任务执行都需要一定时间  
                        } catch (InterruptedException e) {  
                            e.printStackTrace();  
                        }  
                        System.out.println("第" + taskID + "次任务的第" + i + "次执行");  
                    }  
                }  
            });  
        }  
        threadPool.shutdown();// 任务执行完毕，关闭线程池  
    }  
    /**
     * SingleThreadExecutor得到的是一个单个的线程，这个线程会保证你的任务执行完成，
     * 如果当前线程意外终止，会创建一个新线程继续执行任务，这和我们直接创建线程不同，也和newFixedThreadPool(1)不同。
     */
    public void newSingleThreadExecutor(){
    	ExecutorService threadPool = Executors.newSingleThreadExecutor();  
        for(int i = 1; i < 5; i++) {  
            final int taskID = i;  
            threadPool.execute(new Runnable() {  
                public void run() {  
                    for(int i = 1; i < 5; i++) {  
                        try {  
                            Thread.sleep(20);// 为了测试出效果，让每次任务执行都需要一定时间  
                        } catch (InterruptedException e) {  
                            e.printStackTrace();  
                        }  
                        System.out.println("第" + taskID + "次任务的第" + i + "次执行");  
                    }  
                }  
            });  
        }  
        threadPool.shutdown();// 任务执行完毕，关闭线程池  
    }
    
    /**
     * 4个任务是交替执行的，CachedThreadPool会创建一个缓存区，将初始化的线程缓存起来，
     * 如果线程有可用的，就使用之前创建好的线程，如果没有可用的，就新创建线程，终止并且从缓存中移除已有60秒未被使用的线程
     */
    public void newCachedThreadPool(){
    	ExecutorService threadPool = Executors.newCachedThreadPool();  
        for(int i = 1; i < 5; i++) {  
            final int taskID = i;  
            threadPool.execute(new Runnable() {  
                public void run() {  
                    for(int i = 1; i < 5; i++) {  
                        try {  
                            Thread.sleep(20);// 为了测试出效果，让每次任务执行都需要一定时间  
                        } catch (InterruptedException e) {  
                            e.printStackTrace();  
                        }  
                        System.out.println("第" + taskID + "次任务的第" + i + "次执行");  
                    }  
                }  
            });  
        }  
        threadPool.shutdown();// 任务执行完毕，关闭线程池  
    }
    
    @Test
    public void newScheduledThreadPool(){
    	ScheduledExecutorService schedulePool = Executors.newScheduledThreadPool(1);  
        // 5秒后执行任务  
        schedulePool.schedule(new Runnable() {  
            public void run() {  
                System.out.println("爆炸");  
            }  
        }, 5, TimeUnit.SECONDS);  
        // 5秒后执行任务，以后每2秒执行一次  
        schedulePool.scheduleAtFixedRate(new Runnable() {  
            @Override  
            public void run() {  
                System.out.println("爆炸");  
            }  
        }, 5, 2, TimeUnit.SECONDS);  
    }    
}  