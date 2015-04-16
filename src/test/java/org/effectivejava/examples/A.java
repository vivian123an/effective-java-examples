package org.effectivejava.examples;

public class A {
<<<<<<< HEAD

	static {
		System.out.println(" a static ");
	}
	
	public A() {
		System.out.println(" a construct");
	}
	
	public void print(){
		System.out.println(" a print");
	}
=======
    private B b;
    public void setB(B b) {
         this .b = b;
    }
    public B getB() {
         return b;
    }
>>>>>>> branch 'master' of https://github.com/vivian123an/effective-java-examples.git
}
