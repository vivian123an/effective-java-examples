// Wrapper class - uses composition in place of inheritance - Page 84
package org.effectivejava.examples.chapter04.item16;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class InstrumentedSet<E> extends ForwardingSet<E> {
	private int addCount = 0;

	public InstrumentedSet(Set<E> s) {
		super(s);
	}

	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}

	public int getAddCount() {
		return addCount;
	}

	public static void main(String[] args) {
		InstrumentedSet<String> s = new InstrumentedSet<String>(
				new HashSet<String>());
		s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
		System.out.println(s.getAddCount());
		
		/**
		 * 可以用来计算所有的Set具体实现类
		 */
		InstrumentedSet<Date> s2 = new InstrumentedSet<Date>(
				new TreeSet<Date>());
		s2.addAll(Arrays.asList(new Date(),new Date(2012,4,6), new Date(1988,07,26)));
		System.out.println(s2.getAddCount());
		
	}
}
