package google.guava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

public class ComparibleTest {

	public static final AgeComparator ageComp = new AgeComparator();
	
	
	public void test(){
		Person2 p1 = new Person2(25,"chen","vivian");
		Person2 p2 = new Person2(18,"beijing","baidu");
		Person2 p3 = new Person2(32,"beijing","sina");
		Person2 p4 = new Person2(15,"guangzhou","vip");
		Person2 p5 = new Person2(28,"hangzhou","alibaba");
		
		List<Person2> list = Arrays.asList(p1,p2,p3,p4,p5);
		
		Collections.sort(list,ageComp);
		System.out.println(list);
		
		//List<Person> sortedCopy = Ordering.from(byFirstName).compound(byLastName).reverse().sortedCopy(list.toArray());
		
	}
	
	@Test
	public void orderingTest(){
		Ordering<String> natural = Ordering.natural();
		List<String> abc = ImmutableList.of("a", "b", "c");
		System.out.println(natural.isOrdered(abc));

		List<String> cab = ImmutableList.of("c", "a", "b");
		System.out.println(natural.isOrdered(cab));
		System.out.println(cab = natural.sortedCopy(cab));
		System.out.println(natural.max(cab));
		System.out.println(natural.min(cab));
		System.out.println(natural.leastOf(cab, 2));
		System.out.println(natural.greatestOf(cab, 2));

		System.out.println("====================================");

		Ordering<Integer> intNatural = Ordering.natural();

		List<Integer> a123 = ImmutableList.of(1, 2, 3);
		System.out.println(intNatural.isOrdered(a123));

		List<Integer> a132 = ImmutableList.of(1, 3, 2);
		System.out.println(intNatural.isOrdered(a132));
		System.out.println(intNatural.sortedCopy(a132));

		List<Integer> a321 = ImmutableList.of(3, 2, 1);
		System.out.println(intNatural.reverse().isOrdered(a321));
	}
	
	private static class AgeComparator implements Comparator<Person2>{
		@Override
		public int compare(Person2 o1, Person2 o2){
			return o1.getAge()-o2.getAge();
		}
	}
	
	public final static Comparator<Person2> byLastName = new Comparator<Person2>() {
		@Override
	    public int compare(final Person2 p1, final Person2 p2) {
	        return p1.getLastName().compareTo(p2.getLastName());
	    }
	};
	 
	 
	public final static Comparator<Person2> byFirstName = new Comparator<Person2>() {
		@Override
	    public int compare(final Person2 p1, final Person2 p2) {
	        return p1.getFirstName().compareTo(p2.getFirstName());
	    }
	};
}

class Person2{
	private int age;
	private String lastName;
	private String firstName;
	
	public Person2(int age,String firstName,String lastName) {
		this.age = age;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return firstName+" "+lastName +":"+ age;
	}
}