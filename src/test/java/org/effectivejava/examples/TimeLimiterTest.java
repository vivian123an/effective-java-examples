package org.effectivejava.examples;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.SimpleTimeLimiter;

public class TimeLimiterTest {
	public static void main(String[] args){
        SimpleTimeLimiter simpleTimeLimiter = new SimpleTimeLimiter();
        String hello = null;
        try {
            hello = simpleTimeLimiter.callWithTimeout(new Callable<String>(){
                @Override
                public String call() throws Exception {
                    return "Hello";
                }
            }, 1, TimeUnit.MILLISECONDS, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(hello);

        String word = null;
        try {
            word = simpleTimeLimiter.callWithTimeout(new Callable<String>(){
                @Override
                public String call() throws Exception {
                    Thread.sleep(100);
                    return "Word";
                }
            }, 1, TimeUnit.MILLISECONDS, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(word);
    }
}
