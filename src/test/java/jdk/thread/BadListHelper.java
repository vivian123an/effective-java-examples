package jdk.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
/**
 *   1 ：关注要点，为什么在有synchroniezed方法的同时会出现 Collections.synchronizedList
 *   2 ：知识背景： 您可能需要了解java Synchronized方法的加锁的各种机制，包括如何上锁，锁对象
 * @author pingan
 *
 * @param <E>
 */
public class BadListHelper<E> {
	public List<E> list = Collections.synchronizedList(new ArrayList<E>());  
    public boolean putIfAbsent(E x) {  
        synchronized (list) {  
            boolean absent = !list.contains(x);  
            if (absent)  
                list.add(x);  
            return absent;  
        }  
    }  
    @Test
    public void test(){
    	BadListHelper<Integer> badListHelper = new BadListHelper<Integer>();
    	for(int i=0;i<10;i++){
    		Thread thread = new Thread(new ThreadTest6(badListHelper));
    		thread.start();
    		badListHelper.list.size();
    	}
    }
}
class ThreadTest6 implements Runnable{
	private BadListHelper<Integer> badListHelper;
	public ThreadTest6(BadListHelper<Integer> badListHelper) {
		this.badListHelper = badListHelper;
	}
	@Override
	public void run() {
		for(int j=0;j<20;j++){
			badListHelper.putIfAbsent(j);
		}
	}
}