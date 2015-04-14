package org.effectivejava.examples;

public class B extends A {
	static {
		System.out.println(" b static ");
	}
	
	public B() {
		System.out.println(" b construct");
	}
	
	public void print(){
		System.out.println(" b print");
	}
}
