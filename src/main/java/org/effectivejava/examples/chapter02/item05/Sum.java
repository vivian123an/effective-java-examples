package org.effectivejava.examples.chapter02.item05;

import org.junit.Test;

public class Sum {
	// Hideously slow program! Can you spot the object creation?
	@Test
	public void createLongObject() {
		long time = System.currentTimeMillis();
		Long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println("new Long time:"+(System.currentTimeMillis()-time));

	}
	
	@Test
	public void userPrimaryLong() {
		long time = System.currentTimeMillis();
		long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println("primary long time:"+(System.currentTimeMillis()-time));

	}
}

