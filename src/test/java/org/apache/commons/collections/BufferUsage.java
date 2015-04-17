package org.apache.commons.collections;

import java.util.Comparator;

import org.apache.commons.collections.buffer.PriorityBuffer;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.collect.Collections2;

public class BufferUsage {
	public static void main(String[] args) {
        demoBufferUsage();
    }
 
    public static void demoBufferUsage() {
 
        System.out.println(StringUtils.center(" demoBagUsage ", 40, "="));
 
        // data setup
        Book book1 = new Book("RefactoringWorkbook", "7-5083-2208-8",29.8);
        Book book2 = new Book("J2EEDesign Patterns", "7-5083-3099-4",45);
        Book book3 = new Book("AgileSoftware Development", "7-5083-1503-0",59);
        Book book4 = new Book("ProfessionalJSP", "7-5053-8005-2",100);
 
        // create a Buffer
        Buffer buffer = BufferUtils.typedBuffer(new BoundedFifoBuffer(3), Book.class);
        buffer.add(book1);
        buffer.add(book2);
        buffer.add(book3);
        Book removed = (Book) buffer.remove();
        System.out.println("Removed:");
        System.out.println(removed);
        buffer.add(book4);
       
        // get items in buffer
        for (int i = 0; i < 3; i++) {
            System.out.println(buffer.get());
            buffer.remove();
        }
        System.out.println(StringUtils.repeat("=", 40));
 
    }
    
    @Test	
    public void PriorityBufferTest(){
    	// data setup
        Book book1 = new Book("RefactoringWorkbook", "7-5083-2208-8",29.8);
        Book book2 = new Book("J2EEDesign Patterns", "7-5083-3099-4",45);
        Book book3 = new Book("AgileSoftware Development", "7-5083-1503-0",59);
        Book book4 = new Book("Professional Java", "7-5053-8005-2",100);
        Book book5 = new Book("Professional Java", "7-5053-8005-1",100);
        Book book6 = new Book("Professional J2EE", "7-5053-8005-2",100);
        Book book7 = new Book("Professional J2EE", "7-5053-8005-2",60);
        Book book8 = new Book("Professional Redis", "7-5053-8005-0",100);
        
        Buffer buffer = BufferUtils.typedBuffer(new PriorityBuffer(priorityComp), Book.class);
        buffer.add(book1);
        buffer.add(book2);
        buffer.add(book3);
        buffer.add(book4);
        buffer.add(book5);
        buffer.add(book6);
        buffer.add(book7);
        buffer.add(book8);
        
        for (int i = 0; i < 8; i++) {
            System.out.println(buffer.get());
            buffer.remove();
        }
    }
    
    private static final Comparator<Book> priorityComp = new Comparator<Book>(){
    	@Override
    	public int compare(Book o1, Book o2) {
    		int first = o1.getName().compareTo(o2.getName());
    		if(first==0){
    			int second = o1.getIsbn().compareTo(o2.getIsbn());
    			if(second==0)
    				return new Double(o1.getRetailPrice()-o2.getRetailPrice()).intValue();
    			return second;
    		}
    		return first;
    	};
    };
}
