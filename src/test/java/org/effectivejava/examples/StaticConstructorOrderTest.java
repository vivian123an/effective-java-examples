package org.effectivejava.examples;

public class StaticConstructorOrderTest {

	public static void main(String[] args) {
		A a = new B();
		a.print();
	}
}
