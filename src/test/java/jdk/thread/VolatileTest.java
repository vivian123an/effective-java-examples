package jdk.thread;

import org.junit.Test;

public class VolatileTest {

	@Test
	public void test(){
		for(int i=0;i<10;i++){
			new Thread() {public void run() {Test1.one();};}.start();
			new Thread() {public void run() {Test1.two();};}.start();
		}
	}
}
class Test1 {
	static int i = 0, j = 0;
	static void one() {
		i++;
		j++;
	}
	static void two() {
		System.out.println("i=" + i + " j=" + j);
	}
}