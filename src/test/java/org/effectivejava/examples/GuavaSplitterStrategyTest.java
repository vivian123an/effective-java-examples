package org.effectivejava.examples;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

public class GuavaSplitterStrategyTest {

	public static void main(String[] args) {
		
		System.out.println(Splitter.on(CharMatcher.anyOf(";,")).split("foo,;bar,quux"));
	}
}
