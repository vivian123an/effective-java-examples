package org.effectivejava.examples;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

public class GuavaIteratorsTest {

	public static void main(String[] args) {
		List<String> list = Lists.newArrayList("Apple", "Pear", "Peach","Banana");

		Predicate<String> condition = new Predicate<String>() {
			@Override
			public boolean apply(String input) {
				return ((String) input).startsWith("P");
			}
		};
		boolean allIsStartsWithP = Iterators.all(list.iterator(), condition);
		System.out.println("all result == " + allIsStartsWithP);
		boolean anyIsStartsWithP = Iterators.any(list.iterator(), condition);
		System.out.println("any result == " + anyIsStartsWithP);
	}
}
