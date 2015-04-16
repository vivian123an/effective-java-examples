package google.guava;

import java.util.HashSet;

import org.junit.Test;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public class CollectTest {

	@Test
	public void test(){
		HashSet<Integer> setA = Sets.newHashSet(1, 2, 3, 4, 5);
		HashSet<Integer> setB = Sets.newHashSet(4, 5, 6, 7, 8);
		 
		SetView<Integer> union = Sets.union(setA, setB);
		System.out.println("union:");
		for (Integer integer : union)
		    System.out.println(integer);        
		 
		SetView<Integer> difference = Sets.difference(setA, setB);
		System.out.println("difference:");
		for (Integer integer : difference)
		    System.out.println(integer);       
		 
		SetView<Integer> intersection = Sets.intersection(setA, setB);
		System.out.println("intersection:");
		for (Integer integer : intersection)
		    System.out.println(integer);
	}
}
