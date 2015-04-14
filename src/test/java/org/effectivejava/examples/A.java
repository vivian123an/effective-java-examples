package org.effectivejava.examples;

public class A {

	static {
		System.out.println(" a static ");
	}
	
	public A() {
		System.out.println(" a construct");
	}
	
	public void print(){
		System.out.println(" a print");
	}
}
