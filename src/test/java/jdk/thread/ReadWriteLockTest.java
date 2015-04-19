package jdk.thread;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.junit.Test;

public class ReadWriteLockTest {
	public static void main(String[] args) {  
        final Data data = new Data();  
        for (int i = 0; i < 3; i++) {  
            new Thread(new Runnable() {  
                public void run() {  
                    for (int j = 0; j < 5; j++) {  
                        data.set(new Random().nextInt(30));  
                    }  
                }  
            }).start();  
        }         
        for (int i = 0; i < 3; i++) {  
            new Thread(new Runnable() {  
                public void run() {  
                    for (int j = 0; j < 5; j++) {  
                        data.get();  
                    }  
                }  
            }).start();  
        }  
    }  
	
	/**
	 * 我们发现，虽然写入和写入互斥了，读取和写入也互斥了，但是读取和读取之间也互斥了，不能并发执行，效率较低，用读写锁实现代码如下：
	 */
	@Test
	public void ReentrantReadWriteLock(){
		final ReadWriteLockData data = new ReadWriteLockData();  
        for (int i = 0; i < 3; i++) {  
            new Thread(new Runnable() {  
                public void run() {  
                    for (int j = 0; j < 5; j++) {  
                        data.set(new Random().nextInt(30));  
                    }  
                }  
            }).start();  
        }         
        for (int i = 0; i < 3; i++) {  
            new Thread(new Runnable() {  
                public void run() {  
                    for (int j = 0; j < 5; j++) {  
                        data.get();  
                    }  
                }  
            }).start();  
        } 
	}
}  
class Data {      
    private int data;// 共享数据      
    public synchronized void set(int data) {  
        System.out.println(Thread.currentThread().getName() + "准备写入数据");  
        try {  
            Thread.sleep(20);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        this.data = data;  
        System.out.println(Thread.currentThread().getName() + "写入" + this.data);  
    }     
    public synchronized void get() {  
        System.out.println(Thread.currentThread().getName() + "准备读取数据");  
        try {  
            Thread.sleep(20);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println(Thread.currentThread().getName() + "读取" + this.data);  
    }
}

class ReadWriteLockData {      
    private int data;// 共享数据  
    private ReadWriteLock rwl = new ReentrantReadWriteLock();     
    public void set(int data) {  
        rwl.writeLock().lock();// 取到写锁  
        try {  
            System.out.println(Thread.currentThread().getName() + "准备写入数据");  
            try {  
                Thread.sleep(20);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
            this.data = data;  
            System.out.println(Thread.currentThread().getName() + "写入" + this.data);  
        } finally {  
            rwl.writeLock().unlock();// 释放写锁  
        }  
    }     
    public void get() {  
        rwl.readLock().lock();// 取到读锁  
        try {  
            System.out.println(Thread.currentThread().getName() + "准备读取数据");  
            try {  
                Thread.sleep(20);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
            System.out.println(Thread.currentThread().getName() + "读取" + this.data);  
        } finally {  
            rwl.readLock().unlock();// 释放读锁  
        }  
    }  
}  
